package vn.plantpal.mobile_backend.services.product_sizes;


import vn.plantpal.mobile_backend.dtos.product.product_sizes.ProductSizeDetailDTO;
import vn.plantpal.mobile_backend.dtos.product_size.ProductSizeCreateDTO;
import vn.plantpal.mobile_backend.dtos.product_size.ProductSizeResponseDTO;

import java.util.List;

public interface ProductSizesService {
    List<ProductSizeResponseDTO> getAll();

    List<ProductSizeDetailDTO> getAllProductSizeByProductId(String productId);

    ProductSizeResponseDTO getOneById(String id);
    ProductSizeResponseDTO create(ProductSizeCreateDTO productSizeCreateDTO);
    void delete(String id);
}
