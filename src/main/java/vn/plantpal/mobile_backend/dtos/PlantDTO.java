package vn.plantpal.mobile_backend.dtos;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlantDTO {
    private String id;
    private String name;
    //private String commonName;
    private String description;
    private Double price;
    private String careLevel;
    private Boolean toxicity;
    private Date planted;
    private Integer height;
    private Integer width;
    //SpeciesDTO
    //lightRequireDTO
}
