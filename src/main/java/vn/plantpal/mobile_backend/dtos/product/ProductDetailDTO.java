package vn.plantpal.mobile_backend.dtos.product;

import lombok.Builder;
import lombok.Data;
import vn.plantpal.mobile_backend.dtos.product.accessories.AccessoriesInfoDTO;
import vn.plantpal.mobile_backend.dtos.product.plant.PlantInfoDTO;
import vn.plantpal.mobile_backend.dtos.product.product_images.ProductImageDTO;
import vn.plantpal.mobile_backend.dtos.product.product_sizes.ProductSizeDetailDTO;

import java.util.List;

@Builder
@Data
public class ProductDetailDTO {
    private String id;
    private String name;
    private String description;
    private String productType;
    private PlantInfoDTO plant;
    private AccessoriesInfoDTO accessory;
    private List<ProductImageDTO> images;
    List<ProductSizeDetailDTO> sizes;

}
