package vn.plantpal.mobile_backend.services.product_sizes;

import vn.plantpal.mobile_backend.dtos.product.product_sizes.ProductSizeCreateUpdateDTO;
import vn.plantpal.mobile_backend.dtos.product.product_sizes.ProductSizeDetailDTO;
import vn.plantpal.mobile_backend.dtos.product.product_sizes.ProductSizeInfoDTO;
import vn.plantpal.mobile_backend.entities.ProductSizes;
import vn.plantpal.mobile_backend.entities.Products;
import vn.plantpal.mobile_backend.utils.ProductType;

import java.util.List;

public interface ProductSizeService {
    List<ProductSizes> saveAll(List<ProductSizes> productSizes);

    public List<ProductSizeInfoDTO> saveAllFromDto(List<ProductSizeCreateUpdateDTO> productSizeCreateUpdateDTOS, Products products, ProductType productType);


    List<ProductSizes> updateAllFromDto(List<ProductSizeCreateUpdateDTO> productSizeCreateUpdateDTOS, Products products, ProductType productType);

//    List<ProductSizeInfoDTO> getAll();

    List<ProductSizeDetailDTO> getAllProductSizeByProductId(String productId);

    ProductSizeInfoDTO getOneById(String id);
    ProductSizeInfoDTO create(ProductSizeCreateUpdateDTO productSizeCreateDTO);
    void delete(String id);
}
