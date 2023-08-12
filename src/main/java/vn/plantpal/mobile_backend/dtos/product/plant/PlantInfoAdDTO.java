package vn.plantpal.mobile_backend.dtos.product.plant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import vn.plantpal.mobile_backend.dtos.ProductImageDTO;
import vn.plantpal.mobile_backend.dtos.ProductSize.ProductSizeInfoDTO;
import vn.plantpal.mobile_backend.dtos.product.ProductBaseDTO;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class PlantInfoAdDTO {

    private String id;
    private String name;
    private String description;
    private String instruction;
    private String careLevel;
    private Boolean toxicity;
    private List<ProductImageDTO> images;
    private List<ProductSizeInfoDTO> sizes;
}
