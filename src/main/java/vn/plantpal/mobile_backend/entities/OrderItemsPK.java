package vn.plantpal.mobile_backend.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Embeddable
public class OrderItemsPK implements Serializable {
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private String id;
    @Column(name = "bill_id", nullable = false, length = 36)
    private String billId;
    @Column(name = "product_size_id", nullable = false, length = 36)
    private String productSizeId;
}