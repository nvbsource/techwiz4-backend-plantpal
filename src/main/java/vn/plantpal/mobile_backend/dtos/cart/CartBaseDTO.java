package vn.plantpal.mobile_backend.dtos.cart;

import lombok.*;
import vn.plantpal.mobile_backend.dtos.product.ProductBaseDTO;
import vn.plantpal.mobile_backend.dtos.product.ProductInfoDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartBaseDTO {
    private String id;
    private ProductInfoDTO product;
    private int quantity;
}
