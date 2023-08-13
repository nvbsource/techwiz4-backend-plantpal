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

    public PlantCreatUpdateDTO(String name, String description, String instruction, String careLevel, Boolean toxicity, String speciesId, String lightRequireId) {
        this.name = name;
        this.description = description;
        this.instruction = instruction;
        this.careLevel = careLevel;
        this.toxicity = toxicity;
        this.speciesId = speciesId;
        this.lightRequireId = lightRequireId;
    }
}
