package vn.plantpal.mobile_backend.dtos.product.plant;

import lombok.*;
import vn.plantpal.mobile_backend.dtos.ProductImageDTO;
import vn.plantpal.mobile_backend.dtos.ProductSize.ProductSizeCreateUpdateDTO;

import java.sql.Date;
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
