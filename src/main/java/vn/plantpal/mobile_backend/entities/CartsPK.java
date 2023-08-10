package vn.plantpal.mobile_backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartsPK implements Serializable {
    private String id;
    private String userId;
    private String productId;
}
