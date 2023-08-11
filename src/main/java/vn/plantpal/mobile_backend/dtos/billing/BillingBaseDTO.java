package vn.plantpal.mobile_backend.dtos.billing;

import jakarta.persistence.*;
import vn.plantpal.mobile_backend.entities.OrderItems;
import vn.plantpal.mobile_backend.entities.Users;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

public class BillingBaseDTO {
    private String id;
    private Timestamp orderDate;
    private Double totalAmount;
    private String fullName;
    private String phone;
    private String address;
    private String paymentMethod;
    private String status;
}
