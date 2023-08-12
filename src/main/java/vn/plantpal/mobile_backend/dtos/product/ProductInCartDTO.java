package vn.plantpal.mobile_backend.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductInCartDTO {
    private String productSizeId;
    private int quantity;
}
