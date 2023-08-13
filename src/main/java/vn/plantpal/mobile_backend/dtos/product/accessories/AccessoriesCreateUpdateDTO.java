package vn.plantpal.mobile_backend.dtos.product.accessories;

import lombok.Data;
import vn.plantpal.mobile_backend.dtos.product.product_images.ProductImageDTO;
import vn.plantpal.mobile_backend.dtos.product.product_sizes.ProductSizeCreateUpdateDTO;

import java.util.List;

@Data
public class AccessoriesCreateUpdateDTO {
    private String name;
    private String instruction;
    private String description;
    private String typeId;
    private List<ProductImageDTO> images;
    private List<ProductSizeCreateUpdateDTO> sizes;
}
