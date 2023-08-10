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
    @Basic
    @Column(name = "product_id", nullable = true, length = 36)
    private String productId;
    @Basic
    @Column(name = "size_id", nullable = true, length = 36)
    private String sizeId;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Products product;
    @ManyToOne
    @JoinColumn(name = "size_id", referencedColumnName = "id")
    private Sizes size;
    @OneToMany(mappedBy = "productSizes")
    private Collection<Stocks> stocks;
}
