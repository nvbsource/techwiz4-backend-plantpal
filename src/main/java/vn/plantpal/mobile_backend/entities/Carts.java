package vn.plantpal.mobile_backend.entities;

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
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @Column(name = "user_id", nullable = false, length = 36)
    private String userId;
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @Column(name = "product_id", nullable = false, length = 36)
    private String productId;
    @Basic
    @Column(name = "quantity", nullable = true)
    private Integer quantity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private Users user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private Products product;
}
