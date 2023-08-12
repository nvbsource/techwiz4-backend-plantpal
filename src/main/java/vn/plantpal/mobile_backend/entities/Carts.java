package vn.plantpal.mobile_backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@IdClass(CartsPK.class)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Carts {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;
    @Id
    @Column(name = "user_id", nullable = false, length = 36)
    private String userId;
    @Id
    @Column(name = "product_id", nullable = false, length = 36)
    private String productId;
    @Id
    @Column(name = "product_size_id", nullable = false, length = 36)
    private String productSizeId;
    @Basic
    @Column(name = "product_type", nullable = false)
    private String productType;
    @Basic
    @Column(name = "quantity", nullable = true)
    private Integer quantity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Users user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Products product;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_size_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private ProductSizes productSize;
}
