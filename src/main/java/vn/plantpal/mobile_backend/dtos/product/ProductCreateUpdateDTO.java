package vn.plantpal.mobile_backend.dtos.product;

import lombok.*;
import lombok.experimental.SuperBuilder;
import vn.plantpal.mobile_backend.dtos.product.product_sizes.ProductSizeDetailDTO;

import java.util.Collection;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductCreateUpdateDTO extends ProductBaseDTO {
    private String productType;
    private String name;
    private String description;
    private Collection <ProductSizeDetailDTO> productSizes;
    private Collection<String> productImages;
}
