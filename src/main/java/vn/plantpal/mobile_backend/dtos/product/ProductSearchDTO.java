package vn.plantpal.mobile_backend.dtos.product;

import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
public class ProductSearchDTO {
    private String id;
    private String name;
    private Double minPrice;
    private Double maxPrice;
    private Long stockCount;
    private String productImage;
    private Boolean isFavorited;

    public ProductSearchDTO(String id, String name, Double minPrice, Double maxPrice, Long stockCount, String productImage, Boolean isFavorited) {
        this.id = id;
        this.name = name;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.stockCount = stockCount;
        this.productImage = productImage;
        this.isFavorited = isFavorited;
    }

    public ProductSearchDTO(String id, String name,  Double minPrice, Double maxPrice, Long stockCount, String productImage) {
        this.id = id;
        this.name = name;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.stockCount = stockCount;
        this.productImage = productImage;
    }
}
