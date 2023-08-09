package vn.plantpal.mobile_backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Table(name = "order_items", schema = "TechwizDB", catalog = "")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(OrderItemsPK.class)
public class OrderItems {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "bill_id", nullable = false, length = 36)
    private String billId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @ManyToOne
    @JoinColumn(name = "bill_id", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    private Billings billingsByBillId;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    private Products productsByProductId;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    private Products productsByProductId_0;

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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItems that = (OrderItems) o;
        return Objects.equals(id, that.id) && Objects.equals(billId, that.billId) && Objects.equals(productId, that.productId) && Objects.equals(quantity, that.quantity) && Objects.equals(rate, that.rate) && Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, billId, productId, quantity, rate, amount);
    }

    public Billings getBillingsByBillId() {
        return billingsByBillId;
    }

    public void setBillingsByBillId(Billings billingsByBillId) {
        this.billingsByBillId = billingsByBillId;
    }

    public Products getProductsByProductId() {
        return productsByProductId;
    }

    public void setProductsByProductId(Products productsByProductId) {
        this.productsByProductId = productsByProductId;
    }

    public Products getProductsByProductId_0() {
        return productsByProductId_0;
    }

    public void setProductsByProductId_0(Products productsByProductId_0) {
        this.productsByProductId_0 = productsByProductId_0;
    }
}
