package vn.plantpal.mobile_backend.dtos.ProductSize;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSizeInfoDTO {
    public String id;
    public int width;
    public int height;
    public Date madeOnDate;
    public double price;
    public String type;
    public String size;
    public String sizeId;
}
