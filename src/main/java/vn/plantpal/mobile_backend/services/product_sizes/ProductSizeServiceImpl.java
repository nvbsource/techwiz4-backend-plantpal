package vn.plantpal.mobile_backend.services.product_sizes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.plantpal.mobile_backend.dtos.product.ProductBaseDTO;
import vn.plantpal.mobile_backend.dtos.product.product_sizes.ProductSizeDetailDTO;
import vn.plantpal.mobile_backend.dtos.product_size.ProductSizeCreateDTO;
import vn.plantpal.mobile_backend.dtos.product_size.ProductSizeResponseDTO;
import vn.plantpal.mobile_backend.dtos.size.SizeResponseDTO;
import vn.plantpal.mobile_backend.entities.ProductSizes;
import vn.plantpal.mobile_backend.entities.Products;
import vn.plantpal.mobile_backend.entities.Sizes;
import vn.plantpal.mobile_backend.exceptions.DuplicateRecordException;
import vn.plantpal.mobile_backend.exceptions.ResourceNotFoundException;
import vn.plantpal.mobile_backend.repositories.ProductRepository;
import vn.plantpal.mobile_backend.repositories.ProductSizeRepository;
import vn.plantpal.mobile_backend.repositories.SizeRepository;
import vn.plantpal.mobile_backend.services.product.ProductService;
import vn.plantpal.mobile_backend.services.size.SizeService;
import vn.plantpal.mobile_backend.utils.EntityMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductSizeServiceImpl implements ProductSizesService{
    private final ProductSizeRepository productSizeRepository;
    private final SizeService sizeService;
    private final ProductRepository productRepository;

    @Override
    public List<ProductSizeResponseDTO> getAll() {
        return productSizeRepository.findAll().stream().map(ps -> EntityMapper.mapToDto(ps, ProductSizeResponseDTO.class)).toList();
    }

    @Override
    public List<ProductSizeDetailDTO> getAllProductSizeByProductId(String productId) {
        return productSizeRepository.getAllProductSizeByProductId(productId).stream().map(ps -> EntityMapper.mapToDto(ps, ProductSizeDetailDTO.class)).toList();
    }

    @Override
    public ProductSizeResponseDTO getOneById(String id) {
        return productSizeRepository.findById(id).map(ps -> EntityMapper.mapToDto(ps, ProductSizeResponseDTO.class) ).orElseThrow(()-> new ResourceNotFoundException("ProductSize","id",id));
    }

    @Override
    public ProductSizeResponseDTO create(ProductSizeCreateDTO productSizeCreateDTO) {
        String productId = productSizeCreateDTO.getProductId();
        String sizeId = productSizeCreateDTO.getSizeId();
        String type = productSizeCreateDTO.getType();
        Integer width = productSizeCreateDTO.getWidth();
        Integer height = productSizeCreateDTO.getHeight();
        Double price = productSizeCreateDTO.getPrice();

        boolean productSizeHasExisted = productSizeRepository.existsByProductIdAndSizeId(productId, sizeId);
        if(productSizeHasExisted){
            throw new DuplicateRecordException("Product with that Size already exists");
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

        return EntityMapper.mapToDto(productSizeRepository.save(productSizes),ProductSizeResponseDTO.class);
    }



    @Override
    public void delete(String id) {
        if(productSizeRepository.existsBySizeId(id)){
            throw new DuplicateRecordException("Size existing on another Product");
        }
        ProductSizes sizes = productSizeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ProductSize","id",id));
        productSizeRepository.delete(sizes);
    }
}
