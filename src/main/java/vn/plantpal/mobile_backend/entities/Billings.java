package vn.plantpal.mobile_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Billings {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;
    @Basic
    @Column(name = "order_date", nullable = true)
    private Timestamp orderDate;
    @Basic
    @Column(name = "total_amount", nullable = true, precision = 0)
    private Double totalAmount;
    @Basic
    @Column(name = "full_name", nullable = true, length = 255)
    private String fullName;
    @Basic
    @Column(name = "phone", nullable = true, length = 255)
    private String phone;
    @Basic
    @Column(name = "address", nullable = true, length = 255)
    private String address;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users user;
    @OneToMany(mappedBy = "billing",fetch = FetchType.LAZY)
    private Collection<OrderItems> orderItems;
}
