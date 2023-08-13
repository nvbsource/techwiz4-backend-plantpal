package vn.plantpal.mobile_backend.dtos.product.product_sizes;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import vn.plantpal.mobile_backend.dtos.product.ProductDetailDTO;
import vn.plantpal.mobile_backend.dtos.product.accessories.AccessoriesInfoDTO;
import vn.plantpal.mobile_backend.dtos.product.plant.PlantInfoDTO;
import vn.plantpal.mobile_backend.dtos.product_size.ProductSizeResponseDTO;

import java.sql.Date;

@Builder
@Data
public class ProductSizeDetailDTO {
    private String id;
    private Double price;
    private String type;
    private Date madeOnDate;
    private Integer width;
    private Integer height;
    private int stock;

    public ProductSizeDetailDTO(String id, Double price, String type, Date madeOnDate, Integer width, Integer height, int stock) {
        this.id = id;
        this.price = price;
        this.type = type;
        this.madeOnDate = madeOnDate;
        this.width = width;
        this.height = height;
        this.stock = stock;
    }
}
