package vn.plantpal.mobile_backend.dtos.product.plant;

import lombok.*;
import lombok.experimental.SuperBuilder;
import vn.plantpal.mobile_backend.dtos.SpeciesDto;
import vn.plantpal.mobile_backend.dtos.lights.LightRequiresDto;
import vn.plantpal.mobile_backend.dtos.product.product_images.ProductImageDTO;
import vn.plantpal.mobile_backend.dtos.product.product_sizes.ProductSizeDetailDTO;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class PlantMasterInfoDTO {
    private String id;
    private String name;
    private String description;
    private String instruction;
    private String careLevel;
    private Boolean toxicity;
    private SpeciesDto specie;
    private LightRequiresDto lightRequire;
    private List<ProductImageDTO> images;
    private List<ProductSizeDetailDTO> sizes;

    public PlantMasterInfoDTO(String id, String name, String description, String instruction, String careLevel, Boolean toxicity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.instruction = instruction;
        this.careLevel = careLevel;
        this.toxicity = toxicity;

    }
}
