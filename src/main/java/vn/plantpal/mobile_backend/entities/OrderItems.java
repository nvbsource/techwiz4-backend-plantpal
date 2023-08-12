package vn.plantpal.mobile_backend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "order_items", schema = "TechwizDB", catalog = "")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderItems {
    @EmbeddedId
    private OrderItemsPK id;
    @MapsId("billId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id", referencedColumnName = "id", nullable = false, columnDefinition = "varchar(36)")
    private Billings billing;
    @MapsId("productSizeId")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_size_id", referencedColumnName = "id", nullable = false, columnDefinition = "varchar(36)")
    private ProductSizes productSize;
    @Basic
    @Column(name = "product_type", nullable = false)
    private String productType;
    @Basic
    @Column(name = "quantity", nullable = true)
    private Integer quantity;
    @Basic
    @Column(name = "rate", nullable = true, precision = 0)
    private Double rate;
    @Basic
    @Column(name = "amount", nullable = true, precision = 0)
    private Double amount;
}