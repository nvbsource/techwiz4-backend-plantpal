package vn.plantpal.mobile_backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class OrderItemsPK implements Serializable {
    @Column(name = "id", nullable = false, length = 36)
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "bill_id", nullable = false, length = 36)
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String billId;
    @Column(name = "product_id", nullable = false, length = 36)
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String productId;
}
