package vn.plantpal.mobile_backend.dtos.product;

import lombok.*;
import vn.plantpal.mobile_backend.dtos.product.accessories.AccessoriesInfoDTO;
import vn.plantpal.mobile_backend.dtos.product.plant.PlantInfoDTO;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductInfoDTO {
    private String productType;
    private PlantInfoDTO plant;
    private AccessoriesInfoDTO accessory;
}
