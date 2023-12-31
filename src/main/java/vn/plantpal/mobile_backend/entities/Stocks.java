package vn.plantpal.mobile_backend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Stocks {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "product_sizes_id", nullable = false, length = 36, unique = true)
    private String productSizesId;
    @Basic
    @Column(name = "quantity", nullable = false)
    private Integer quantity;
    @Basic
    @Column(name = "created_at", nullable = true)
    private LocalDateTime createdAt;
    @Basic
    @Column(name = "updated_at", nullable = true)
    private LocalDateTime updatedAt;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_sizes_id", referencedColumnName = "id", insertable = false, updatable = false)
    private ProductSizes productSize;

//    public Stocks(Integer quantity, ProductSizes productSize, LocalDateTime createdAt, LocalDateTime updatedAt) {
//        this.quantity = quantity;
//        this.createdAt = createdAt;
//        this.updatedAt = updatedAt;
//        this.productSize = productSize;
//    }

    public Stocks(Integer quantity, ProductSizes productSize, String productSizesId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.productSizesId = productSizesId;
        this.quantity = quantity;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.productSize = productSize;
    }
}
