package vn.plantpal.mobile_backend.dtos.cart;

import lombok.*;
import vn.plantpal.mobile_backend.entities.ProductSizes;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartMappingProductSizeDTO {
    private ProductSizes productSizes;
    private int quantity;
}
