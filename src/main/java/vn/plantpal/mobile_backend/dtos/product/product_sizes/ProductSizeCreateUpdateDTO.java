package vn.plantpal.mobile_backend.dtos.product.product_sizes;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSizeCreateUpdateDTO {
    public String id;
    @NotNull
    public int width;
    @NotNull
    public int height;
    public Date madeOnDate;
    @NotNull
    public double price;
    public String type;
    @NotNull
    public String sizeId;
    @NotNull
    public int quantity;
}
