package vn.plantpal.mobile_backend.dtos.billing;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.plantpal.mobile_backend.entities.OrderItems;
import vn.plantpal.mobile_backend.entities.Users;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BillingBaseDTO {
    private String id;
    private LocalDateTime orderDate;
    private Double totalAmount;
    private String fullName;
    private String phone;
    private String address;
    private String paymentMethod;
    private String status;
}
