package vn.plantpal.mobile_backend.dtos.product.product_sizes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@Builder
public class ProductSizeDetailDTO {
    private String id;
    private Double price;
    private String type;
    private Date madeOnDate;
    private Integer width;
    private Integer height;
    private int stock;
    private String sizeName;
    public ProductSizeDetailDTO(String id, Double price, String type, Date madeOnDate, Integer width, Integer height, int stock,String sizeName) {
        this.id = id;
        this.price = price;
        this.type = type;
        this.madeOnDate = madeOnDate;
        this.width = width;
        this.height = height;
        this.stock = stock;
        this.sizeName = sizeName;
    }
}
