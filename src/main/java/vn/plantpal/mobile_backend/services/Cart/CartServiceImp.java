package vn.plantpal.mobile_backend.services.Cart;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.plantpal.mobile_backend.dtos.cart.SaveCardResponseDTO;
import vn.plantpal.mobile_backend.dtos.cart.SaveToCartDTO;
import vn.plantpal.mobile_backend.dtos.cart.CartBaseDTO;
import vn.plantpal.mobile_backend.dtos.product.ProductBaseDTO;
import vn.plantpal.mobile_backend.entities.Carts;
import vn.plantpal.mobile_backend.entities.Products;
import vn.plantpal.mobile_backend.exceptions.BadRequestException;
import vn.plantpal.mobile_backend.exceptions.ResourceNotFoundException;
import vn.plantpal.mobile_backend.repositories.CartRepository;
import vn.plantpal.mobile_backend.repositories.ProductRepository;
import vn.plantpal.mobile_backend.utils.CartStatusType;
import vn.plantpal.mobile_backend.utils.EntityMapper;
import vn.plantpal.mobile_backend.utils.ProductType;

import java.util.List;
@Service
public class CartServiceImp implements CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private EntityMapper entityMapper;

    @Override
    public List<CartBaseDTO> findByUserId(String userId) {
        return entityMapper.mapList(cartRepository.findByUserId(userId), CartBaseDTO.class);
    }

    @Override
    public SaveCardResponseDTO save(SaveToCartDTO data, String userId) {
        Products product = productRepository.findById(data.getProductId()).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        Carts cartByUser = cartRepository.findByUserIdAndProductId(userId, product.getId());
        if(cartByUser == null && data.getQuantity() <= 0) {
            throw new BadRequestException("Quantity must be greater than or equal to 1");
        }
        if (cartByUser == null){
            Carts cartNew = new Carts();
            cartNew.setUserId(userId);
            cartNew.setProductId(product.getId());
            cartNew.setQuantity(data.getQuantity());
            cartRepository.save(cartNew);
            return SaveCardResponseDTO.builder().typeStatus(CartStatusType.CREATED.name()).build();
        }else if (data.getQuantity() <= 0) {
            cartRepository.delete(cartByUser);
            return SaveCardResponseDTO.builder().typeStatus(CartStatusType.DELETED.name()).build();
        }else {
            cartByUser.setQuantity(data.getQuantity());
            return SaveCardResponseDTO.builder().typeStatus(CartStatusType.UPDATED.name()).build();
        }
    }

    @Override
    public void delete(String productId, String userId) {
        Carts cartByUser = cartRepository.findByUserIdAndProductId(userId, productId);
        if (cartByUser == null) {
            throw new ResourceNotFoundException("Cart not found");
        }
        cartRepository.delete(cartByUser);
    }
}
