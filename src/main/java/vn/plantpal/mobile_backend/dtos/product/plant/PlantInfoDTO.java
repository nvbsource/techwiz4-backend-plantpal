package vn.plantpal.mobile_backend.dtos.product.plant;

import lombok.*;
import lombok.experimental.SuperBuilder;
import vn.plantpal.mobile_backend.dtos.product.product_images.ProductImageDTO;
import vn.plantpal.mobile_backend.dtos.product.product_sizes.ProductSizeInfoDTO;
import vn.plantpal.mobile_backend.dtos.product.ProductBaseDTO;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class PlantInfoDTO extends ProductBaseDTO {

    private String id;
    private String name;
    private String description;
    private String instruction;
    private String careLevel;
    private Boolean toxicity;
    private Date madeOnDate;
    private List<ProductImageDTO> images;
    private List<ProductSizeInfoDTO> sizes;
}
