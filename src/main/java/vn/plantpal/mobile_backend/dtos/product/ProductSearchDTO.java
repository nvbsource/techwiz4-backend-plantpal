package vn.plantpal.mobile_backend.dtos.product;

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductSearchDTO {
    private String id;
    private String name;
    private String description;
    private Double minPrice;
    private Double maxPrice;
    private Long stockCount;
//    private String productImage;
}
