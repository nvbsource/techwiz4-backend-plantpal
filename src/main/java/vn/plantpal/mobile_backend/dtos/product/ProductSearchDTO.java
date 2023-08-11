package vn.plantpal.mobile_backend.dtos.product;

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductSearchDTO {
    private String id;
    private float price;
    private int stockCount;
    private String productImage;
}
