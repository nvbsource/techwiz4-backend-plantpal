package vn.plantpal.mobile_backend.dtos.stock;

import lombok.Data;
import lombok.NoArgsConstructor;
import vn.plantpal.mobile_backend.dtos.product.product_sizes.ProductSizeDetailDTO;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Data
public class StockResponseDTO {
    private String stockId;
    private String productSizeId;
    private String productId;
    private String name;
    private String size;
    private Integer quantity;
    private String productImage;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public StockResponseDTO(String stockId, String productSizeId, String productId, String name, String size, Integer quantity, String productImage, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.stockId = stockId;
        this.productSizeId = productSizeId;
        this.productId = productId;
        this.name = name;
        this.size = size;
        this.quantity = quantity;
        this.productImage = productImage;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
