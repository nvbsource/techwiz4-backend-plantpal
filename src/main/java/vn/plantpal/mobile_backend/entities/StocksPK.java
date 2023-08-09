package vn.plantpal.mobile_backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

public class StocksPK implements Serializable {
    @Column(name = "id", nullable = false, length = 36)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
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
        StocksPK stocksPK = (StocksPK) o;
        return Objects.equals(id, stocksPK.id) && Objects.equals(productId, stocksPK.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId);
    }
}
