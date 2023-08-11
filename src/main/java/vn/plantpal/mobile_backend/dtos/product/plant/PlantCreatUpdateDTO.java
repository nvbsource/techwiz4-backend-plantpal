package vn.plantpal.mobile_backend.dtos.product.plant;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlantCreatUpdateDTO{
    private String name;
    private String description;
    private Double price;
    private String careLevel;
    private Boolean toxicity;
    private Date planted;
    private Integer height;
    private Integer width;
    private String speciesId;
    private String lightRequireId;
}
