package vn.plantpal.mobile_backend.services.product_sizes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.plantpal.mobile_backend.dtos.product.product_sizes.ProductSizeCreateUpdateDTO;
import vn.plantpal.mobile_backend.dtos.product.product_sizes.ProductSizeDetailDTO;
import vn.plantpal.mobile_backend.dtos.product.product_sizes.ProductSizeInfoDTO;
import vn.plantpal.mobile_backend.entities.ProductSizes;
import vn.plantpal.mobile_backend.entities.Products;
import vn.plantpal.mobile_backend.entities.Sizes;
import vn.plantpal.mobile_backend.exceptions.BadRequestException;
import vn.plantpal.mobile_backend.exceptions.DuplicateRecordException;
import vn.plantpal.mobile_backend.exceptions.ResourceNotFoundException;
import vn.plantpal.mobile_backend.repositories.ProductRepository;
import vn.plantpal.mobile_backend.repositories.ProductSizeRepository;
import vn.plantpal.mobile_backend.repositories.SizeRepository;
import vn.plantpal.mobile_backend.services.sizes.SizeService;
import vn.plantpal.mobile_backend.utils.EntityMapper;
import vn.plantpal.mobile_backend.utils.ProductType;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductSizeServiceImpl implements ProductSizeService {
    private final ProductSizeRepository productSizeRepository;
    private final SizeRepository sizeRepository;
    private final SizeService sizeService;
    private final ProductRepository productRepository;


    @Override
    public List<ProductSizeInfoDTO> getAll() {
        return productSizeRepository.findAll().stream().map(ps -> EntityMapper.mapToDto(ps, ProductSizeInfoDTO.class)).toList();
    }

    @Override
    public List<ProductSizeDetailDTO> getAllProductSizeByProductId(String productId) {
        return productSizeRepository.getAllProductSizeByProductId(productId).stream().map(ps -> EntityMapper.mapToDto(ps, ProductSizeDetailDTO.class)).toList();
    }

    @Override
    public ProductSizeInfoDTO getOneById(String id) {
        return productSizeRepository.findById(id).map(ps -> EntityMapper.mapToDto(ps, ProductSizeInfoDTO.class) ).orElseThrow(()-> new ResourceNotFoundException("ProductSize","id",id));
    }

    @Override
    public ProductSizeInfoDTO create(ProductSizeCreateUpdateDTO productSizeCreateDTO) {
        String productId = productSizeCreateDTO.getId();
        String sizeId = productSizeCreateDTO.getSizeId();
        String type = productSizeCreateDTO.getType();
        Integer width = productSizeCreateDTO.getWidth();
        Integer height = productSizeCreateDTO.getHeight();
        Double price = productSizeCreateDTO.getPrice();

        boolean productSizeHasExisted = productSizeRepository.existsByProductIdAndSizeId(productId, sizeId);
        if(productSizeHasExisted){
            throw new DuplicateRecordException("Product with provided Size already exists");
        }
        Products products = productRepository.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product","id",productId));
        Sizes sizes = EntityMapper.mapToEntity(sizeService.getOneById(sizeId),Sizes.class);
        ProductSizes productSizes = ProductSizes.builder()
                .product(products)
                .size(sizes)
                .height(height)
                .width(width)
                .price(price)
                .type(type)
                .build();

        return EntityMapper.mapToDto(productSizeRepository.save(productSizes),ProductSizeInfoDTO.class);
    }



    @Override
    public void delete(String id) {
        if(productSizeRepository.existsBySizeId(id)){
            throw new DuplicateRecordException("Size existing on another Product");
        }
        ProductSizes sizes = productSizeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ProductSize","id",id));
        productSizeRepository.delete(sizes);
    }
    @Override
    public List<ProductSizes> saveAll(List<ProductSizes> productSizes) {
        return productSizeRepository.saveAll(productSizes);
    }

    @Override
    public List<ProductSizes> saveAllFromDto(List<ProductSizeCreateUpdateDTO> productSizeCreateUpdateDTOS, Products products, ProductType productType) {
        List<ProductSizes> productSizes = productSizeCreateUpdateDTOS.stream().map(productSizeCreateUpdateDTO -> new ProductSizes(
                productSizeCreateUpdateDTO.getPrice(),
                productType.toString(),
                productSizeCreateUpdateDTO.getMadeOnDate(),
                productSizeCreateUpdateDTO.getHeight(),
                productSizeCreateUpdateDTO.getWidth(),
                products,
                sizeRepository.findById(productSizeCreateUpdateDTO.getSizeId()).orElseThrow(() -> new BadRequestException("Size not found"))
        )).toList();
        return productSizeRepository.saveAll(productSizes);
    }

    @Override
    public List<ProductSizes> updateAllFromDto(List<ProductSizeCreateUpdateDTO> productSizeCreateUpdateDTOS, Products products, ProductType productType) {
        List<String> sizeId = new ArrayList<>();
        productSizeCreateUpdateDTOS.forEach((s) -> {
            if (!sizeId.contains(s.getSizeId())) sizeId.add(s.getSizeId());
        });
        sizeId.forEach((s) -> {
            if (!sizeRepository.existsById(s)) throw new BadRequestException("Size not found");
        });
        productSizeRepository.deleteAllByProduct_Id(products.getId());
        List<ProductSizes> productSizes = productSizeCreateUpdateDTOS.stream().map(productSizeCreateUpdateDTO -> new ProductSizes(
                productSizeCreateUpdateDTO.getPrice(),
                productType.toString(),
                productSizeCreateUpdateDTO.getMadeOnDate(),
                productSizeCreateUpdateDTO.getHeight(),
                productSizeCreateUpdateDTO.getWidth(),
                products,
                sizeRepository.findById(productSizeCreateUpdateDTO.getSizeId()).orElseThrow(() -> new BadRequestException("Size not found"))
        )).toList();
        productSizeRepository.flush();
        return productSizeRepository.saveAll(productSizes);
    }
}
