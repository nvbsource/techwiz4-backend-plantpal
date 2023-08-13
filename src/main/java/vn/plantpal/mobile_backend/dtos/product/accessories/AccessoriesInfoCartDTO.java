package vn.plantpal.mobile_backend.dtos.product.accessories;

import lombok.*;
import vn.plantpal.mobile_backend.dtos.accesoryType.AccessoryTypeInfoDto;
import vn.plantpal.mobile_backend.dtos.product.product_images.ProductImageDTO;
import vn.plantpal.mobile_backend.dtos.product.product_sizes.ProductSizeInfoDTO;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccessoriesInfoCartDTO {
    private String id;
    private String name;
    private String description;
    private String instruction;
    private AccessoryTypeInfoDto type;
    private List<ProductImageDTO> images;
    private ProductSizeInfoDTO size;
}
