package vn.plantpal.mobile_backend.dtos.product_size;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductSizeCreateDTO {
    private String productId;
    private String sizeId;
    private Double price;
    private String type;
    private Date madeOnDate;
    private Integer height;
    private Integer width;
}
