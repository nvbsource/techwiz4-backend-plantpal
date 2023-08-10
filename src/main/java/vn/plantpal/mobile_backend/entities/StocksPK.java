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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StocksPK implements Serializable {
    @Column(name = "id", nullable = false, length = 36)
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "product_sizes_id", nullable = false, length = 36)
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String productSizesId;

}
