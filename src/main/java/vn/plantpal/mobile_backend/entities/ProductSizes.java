package vn.plantpal.mobile_backend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Entity
@Table(name = "product_sizes", schema = "TechwizDB"
        ,uniqueConstraints = {@UniqueConstraint(columnNames = {"product_id", "size_id"})})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductSizes {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Products product;
    @ManyToOne
    @JoinColumn(name = "size_id", referencedColumnName = "id")
    private Sizes size;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_id", referencedColumnName = "id")
    private Stocks stock;
}
