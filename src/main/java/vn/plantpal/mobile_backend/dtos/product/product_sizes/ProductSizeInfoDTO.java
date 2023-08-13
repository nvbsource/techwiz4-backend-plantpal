package vn.plantpal.mobile_backend.dtos.product.product_sizes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.plantpal.mobile_backend.entities.ProductSizes;
import vn.plantpal.mobile_backend.entities.Stocks;

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
    public String stockId;
    public int quantity;

    public static ProductSizeInfoDTO fromProductSizeCreateUpdateDTO(ProductSizeCreateUpdateDTO productSizeCreateUpdateDTO, String size, String stockId) {
        return ProductSizeInfoDTO.builder()
                .id(productSizeCreateUpdateDTO.id)
                .width(productSizeCreateUpdateDTO.width)
                .height(productSizeCreateUpdateDTO.height)
                .madeOnDate(productSizeCreateUpdateDTO.madeOnDate)
                .price(productSizeCreateUpdateDTO.price)
                .type(productSizeCreateUpdateDTO.type)
                .size(size)
                .sizeId(productSizeCreateUpdateDTO.sizeId)
                .quantity(productSizeCreateUpdateDTO.quantity)
                .stockId(stockId)
                .build();
    }

    public static ProductSizeInfoDTO fromProductSizeEntity(ProductSizes productSizeEntity, Stocks stock) {
        return ProductSizeInfoDTO.builder()
                .id(productSizeEntity.getId())
                .width(productSizeEntity.getWidth())
                .height(productSizeEntity.getHeight())
                .madeOnDate(productSizeEntity.getMadeOnDate())
                .price(productSizeEntity.getPrice())
                .type(productSizeEntity.getType())
                .size(productSizeEntity.getSize().getSizeType())
                .sizeId(productSizeEntity.getSize().getId())
                .quantity(stock.getQuantity())
                .stockId(stock.getId())
                .build();
    }

}
