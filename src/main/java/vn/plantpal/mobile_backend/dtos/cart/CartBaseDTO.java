package vn.plantpal.mobile_backend.dtos.cart;

import lombok.*;
import vn.plantpal.mobile_backend.dtos.product.ProductBaseDTO;
import vn.plantpal.mobile_backend.dtos.product.ProductInfoCartDTO;
import vn.plantpal.mobile_backend.dtos.product.ProductInfoDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartBaseDTO {
    private String id;
    private ProductInfoCartDTO product;
    private int quantity;
}
