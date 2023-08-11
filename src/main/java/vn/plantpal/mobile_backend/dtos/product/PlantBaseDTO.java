package vn.plantpal.mobile_backend.dtos.product;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlantBaseDTO extends PlantInfoDTO{
    private String id;
    private String name;
    private String description;
    private Double price;
}
