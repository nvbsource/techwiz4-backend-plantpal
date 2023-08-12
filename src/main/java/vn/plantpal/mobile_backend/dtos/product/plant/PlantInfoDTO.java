package vn.plantpal.mobile_backend.dtos.product.plant;

import lombok.*;
import lombok.experimental.SuperBuilder;
import vn.plantpal.mobile_backend.dtos.product.ProductBaseDTO;

import java.sql.Date;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class PlantInfoDTO extends ProductBaseDTO {
    private String careLevel;
    private Boolean toxicity;
    private Date madeOnDate;
    private Integer height;
    private Integer width;
}
