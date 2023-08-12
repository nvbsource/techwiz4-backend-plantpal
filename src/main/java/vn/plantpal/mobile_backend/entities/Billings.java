package vn.plantpal.mobile_backend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Objects;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Billings {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;
    @Basic
    @Column(name = "order_date", nullable = true)
    private LocalDateTime orderDate;
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
    @Column(name = "status", nullable = false, length = 20)
    private String status;
    @Basic
    @Column(name = "payment_status", nullable = false, length = 20)
    private String paymentStatus;
    @Basic
    @Column(name = "paymentMethod", nullable = false, length = 20)
    private String paymentMethod;
    @Basic
    @Column(name = "address", nullable = true, length = 255)
    private String address;
    @Basic
    @Column(name = "billCode", nullable = true, length = 255)
    private String billCode;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users user;
    @OneToMany(mappedBy = "billing", fetch = FetchType.LAZY)
    private Collection<OrderItems> orderItems;
}
