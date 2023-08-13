package vn.plantpal.mobile_backend.dtos.product.plant;

import lombok.*;
import vn.plantpal.mobile_backend.dtos.product.product_images.ProductImageDTO;
import vn.plantpal.mobile_backend.dtos.product.product_sizes.ProductSizeCreateUpdateDTO;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlantCreatUpdateDTO{
    private String name;
    private String description;
    private String instruction;
    private String careLevel;
    private Boolean toxicity;
    private String speciesId;
    private String lightRequireId;
    private List<ProductImageDTO> images;
    private List<ProductSizeCreateUpdateDTO> sizes;
}
