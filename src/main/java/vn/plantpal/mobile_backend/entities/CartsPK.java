package vn.plantpal.mobile_backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

public class CartsPK implements Serializable {
    @Column(name = "id", nullable = false, length = 36)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(name = "user_id", nullable = false, length = 36)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userId;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
        CartsPK cartsPK = (CartsPK) o;
        return Objects.equals(id, cartsPK.id) && Objects.equals(userId, cartsPK.userId) && Objects.equals(productId, cartsPK.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, productId);
    }
}
