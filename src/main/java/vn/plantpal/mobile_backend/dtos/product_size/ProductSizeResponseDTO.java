package vn.plantpal.mobile_backend.dtos.product_size;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.sql.Date;

@Builder
@Data
public class ProductSizeResponseDTO {
    private String id;
    private Double price;
    private String type;
    private Date madeOnDate;
    private Integer width;
    private Integer height;
}
