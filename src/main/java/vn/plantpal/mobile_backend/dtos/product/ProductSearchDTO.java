package vn.plantpal.mobile_backend.dtos.product;

import lombok.*;
import vn.plantpal.mobile_backend.entities.Favorites;

@Builder
@Setter
@Getter
@NoArgsConstructor
public class ProductSearchDTO {
    private String id;
    private String name;
    private String description;
    private Double minPrice;
    private Double maxPrice;
    private Long stockCount;
    private String productImage;
    private Boolean isFavorited;

    public ProductSearchDTO(String id, String name, String description, Double minPrice, Double maxPrice, Long stockCount, String productImage, Boolean isFavorited) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.stockCount = stockCount;
        this.productImage = productImage;
        this.isFavorited = isFavorited;
    }

    public ProductSearchDTO(String id, String name, String description, Double minPrice, Double maxPrice, Long stockCount, String productImage) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.stockCount = stockCount;
        this.productImage = productImage;
    }
}
