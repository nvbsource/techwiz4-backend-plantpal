package vn.plantpal.mobile_backend.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductBaseDTO {
    private String productType;
    private PlantBaseDTO plant;
    private AccessoryBaseDTO accessory;
}
