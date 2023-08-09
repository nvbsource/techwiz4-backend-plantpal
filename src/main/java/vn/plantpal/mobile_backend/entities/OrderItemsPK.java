package vn.plantpal.mobile_backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

public class OrderItemsPK implements Serializable {
    @Column(name = "id", nullable = false, length = 36)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(name = "bill_id", nullable = false, length = 36)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String billId;
    @Column(name = "product_id", nullable = false, length = 36)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String productId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemsPK that = (OrderItemsPK) o;
        return Objects.equals(id, that.id) && Objects.equals(billId, that.billId) && Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, billId, productId);
    }
}
