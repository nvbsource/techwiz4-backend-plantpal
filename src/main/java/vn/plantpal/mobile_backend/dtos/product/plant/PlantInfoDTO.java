package vn.plantpal.mobile_backend.dtos.product.plant;

import lombok.*;
import lombok.experimental.SuperBuilder;
import vn.plantpal.mobile_backend.dtos.product.ProductBaseDTO;

import java.sql.Date;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlantInfoDTO extends ProductBaseDTO {
    private String careLevel;
    private Boolean toxicity;
}
