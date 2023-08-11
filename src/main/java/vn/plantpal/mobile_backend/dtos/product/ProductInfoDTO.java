package vn.plantpal.mobile_backend.dtos.product;

import vn.plantpal.mobile_backend.dtos.product.accessories.AccessoriesInfoDTO;
import vn.plantpal.mobile_backend.dtos.product.plant.PlantInfoDTO;

public class ProductInfoDTO {
    private String productType;
    private PlantInfoDTO plant;
    private AccessoriesInfoDTO accessory;
}
