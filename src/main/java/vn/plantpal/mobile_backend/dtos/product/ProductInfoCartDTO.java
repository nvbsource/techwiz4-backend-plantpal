package vn.plantpal.mobile_backend.dtos.product;

import lombok.*;
import vn.plantpal.mobile_backend.dtos.product.accessories.AccessoriesInfoCartDTO;
import vn.plantpal.mobile_backend.dtos.product.accessories.AccessoriesInfoDTO;
import vn.plantpal.mobile_backend.dtos.product.plant.PlantInfoCartDTO;
import vn.plantpal.mobile_backend.dtos.product.plant.PlantInfoDTO;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductInfoCartDTO {
    private String productType;
    private PlantInfoCartDTO plant;
    private AccessoriesInfoCartDTO accessory;
}
