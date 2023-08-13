package vn.plantpal.mobile_backend.services.cart;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.plantpal.mobile_backend.dtos.accesoryType.AccessoryTypeInfoDto;
import vn.plantpal.mobile_backend.dtos.cart.SaveCardResponseDTO;
import vn.plantpal.mobile_backend.dtos.cart.SaveToCartDTO;
import vn.plantpal.mobile_backend.dtos.cart.CartBaseDTO;
import vn.plantpal.mobile_backend.dtos.product.ProductInfoCartDTO;
import vn.plantpal.mobile_backend.dtos.product.accessories.AccessoriesInfoCartDTO;
import vn.plantpal.mobile_backend.dtos.product.plant.PlantInfoCartDTO;
import vn.plantpal.mobile_backend.dtos.product.plant.PlantInfoDTO;
import vn.plantpal.mobile_backend.dtos.product.product_images.ProductImageDTO;
import vn.plantpal.mobile_backend.dtos.product.product_sizes.ProductSizeInfoDTO;
import vn.plantpal.mobile_backend.entities.Accessories;
import vn.plantpal.mobile_backend.entities.Carts;
import vn.plantpal.mobile_backend.entities.Plants;
import vn.plantpal.mobile_backend.entities.ProductSizes;
import vn.plantpal.mobile_backend.exceptions.BadRequestException;
import vn.plantpal.mobile_backend.exceptions.ResourceNotFoundException;
import vn.plantpal.mobile_backend.repositories.CartRepository;
import vn.plantpal.mobile_backend.repositories.ProductRepository;
import vn.plantpal.mobile_backend.repositories.ProductSizeRepository;
import vn.plantpal.mobile_backend.utils.CartStatusType;
import vn.plantpal.mobile_backend.utils.EntityMapper;
import vn.plantpal.mobile_backend.utils.ProductType;

import java.util.ArrayList;
import java.util.List;
@Service
public class CartServiceImp implements CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductSizeRepository productSizeRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private EntityMapper entityMapper;

    @Override
    @Transactional
    public List<CartBaseDTO> findByUserId(String userId) {
        List<Carts> listCartFromDB = cartRepository.findByUserId(userId);
        List<CartBaseDTO> listCart = new ArrayList<>();
        listCartFromDB.forEach(cart -> {
            CartBaseDTO mapCartBaseDTO = CartBaseDTO.builder()
                    .id(cart.getId())
                    .quantity(cart.getQuantity())
                    .build();
            ProductInfoCartDTO productInfoCartDTO = new ProductInfoCartDTO();
            if(cart.getProductType().equals(ProductType.PLANT.name())) {
                Plants plant = cart.getProduct().getPlant();
                PlantInfoCartDTO mapPlantBaseDTO = PlantInfoCartDTO.builder()
                        .id(plant.getId())
                        .name(plant.getName())
                        .description(plant.getDescription())
                        .instruction(plant.getInstruction())
                        .careLevel(plant.getCareLevel())
                        .toxicity(plant.getToxicity())
                        .madeOnDate(cart.getProductSize().getMadeOnDate())
                        .images(entityMapper.mapList(cart.getProduct().getProductImages().stream().toList(), ProductImageDTO.class))
                        .size(modelMapper.map(cart.getProductSize(), ProductSizeInfoDTO.class))
                        .build();
                productInfoCartDTO.setProductType(ProductType.PLANT.name());
                productInfoCartDTO.setPlant(mapPlantBaseDTO);
                mapCartBaseDTO.setProduct(productInfoCartDTO);
                listCart.add(mapCartBaseDTO);
            }
            if(cart.getProductType().equals(ProductType.ACCESSORIES.name())) {
                Accessories accessories = cart.getProduct().getAccessory();
                AccessoriesInfoCartDTO mapAccessoriesBaseDTO = AccessoriesInfoCartDTO.builder()
                        .id(accessories.getId())
                        .name(accessories.getName())
                        .description(accessories.getDescription())
                        .instruction(accessories.getInstruction())
                        .type(modelMapper.map(accessories.getAccessoriesType(), AccessoryTypeInfoDto.class))
                        .images(entityMapper.mapList(accessories.getProduct().getProductImages().stream().toList(), ProductImageDTO.class))
                        .size(modelMapper.map(cart.getProductSize(), ProductSizeInfoDTO.class))
                        .build();
                productInfoCartDTO.setProductType(ProductType.ACCESSORIES.name());
                productInfoCartDTO.setAccessory(mapAccessoriesBaseDTO);
                mapCartBaseDTO.setProduct(productInfoCartDTO);
                listCart.add(mapCartBaseDTO);
            }
        });
//        for (int i = 0; i < listCart.size(); i++) {
//            CartBaseDTO cart = listCart.get(i);
//            if(cart.getProduct().getPlant() != null){
//                modelMapper.map(listCartFromDB.get(i).getProductSize(), cart.getProduct().getPlant());
//            }
//            if(cart.getProduct().getAccessory() != null) {
//                modelMapper.map(listCartFromDB.get(i).getProductSize(), cart.getProduct().getAccessory());
//            }
//        }
        return listCart;
    }

    @Override
    public SaveCardResponseDTO save(SaveToCartDTO data, String userId) {
        ProductSizes productSizes = productSizeRepository.findById(data.getProductSizeId())
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        Carts cartByUser = cartRepository.findByUserIdAndProductSizeId(userId, productSizes.getId());
        if(cartByUser == null && data.getQuantity() <= 0) {
            throw new BadRequestException("Quantity must be greater than or equal to 1");
        }
        if (cartByUser == null){
            Carts cartNew = new Carts();
            cartNew.setUserId(userId);
            cartNew.setProductId(productSizes.getProduct().getId());
            cartNew.setProductSizeId(productSizes.getId());
            cartNew.setQuantity(data.getQuantity());
            cartNew.setProductType(productSizes.getType());
            cartRepository.save(cartNew);
            return SaveCardResponseDTO.builder().typeStatus(CartStatusType.CREATED.name()).build();
        }else if (data.getQuantity() <= 0) {
            cartRepository.delete(cartByUser);
            return SaveCardResponseDTO.builder().typeStatus(CartStatusType.DELETED.name()).build();
        }else {
            cartByUser.setQuantity(data.getQuantity());
            cartRepository.save(cartByUser);
            return SaveCardResponseDTO.builder().typeStatus(CartStatusType.UPDATED.name()).build();
        }
    }

    @Override
    public void delete(String productSizeId, String userId) {
        Carts cartByUser = cartRepository.findByUserIdAndProductSizeId(userId, productSizeId);
        if (cartByUser == null) {
            throw new ResourceNotFoundException("Cart not found");
        }
        cartRepository.delete(cartByUser);
    }
}
