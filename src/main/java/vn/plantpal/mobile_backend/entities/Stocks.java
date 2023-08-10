package vn.plantpal.mobile_backend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@IdClass(StocksPK.class)
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
    @Id
    @Column(name = "product_sizes_id", nullable = false, length = 36)
    private String productSizesId;
    @Basic
    @Column(name = "quantity", nullable = true)
    private Integer quantity;
    @Basic
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at", nullable = true)
    private Timestamp updatedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    private Products product;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    private Products product_0;


}
