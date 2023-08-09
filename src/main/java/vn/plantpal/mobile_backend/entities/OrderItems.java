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
@IdClass(OrderItemsPK.class)
public class OrderItems {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @Column(name = "bill_id", nullable = false, length = 36)
    private String billId;
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @Column(name = "product_id", nullable = false, length = 36)
    private String productId;
    @Basic
    @Column(name = "quantity", nullable = true)
    private Integer quantity;
    @Basic
    @Column(name = "rate", nullable = true, precision = 0)
    private Double rate;
    @Basic
    @Column(name = "amount", nullable = true, precision = 0)
    private Double amount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    private Billings billing;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    private Products product;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    private Products product_0;
}
