package vn.plantpal.mobile_backend.dtos.cart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.plantpal.mobile_backend.dtos.product.ProductBaseDTO;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartBaseDTO {
    private String id;
    private ProductBaseDTO product;
    private int quantity;
}
