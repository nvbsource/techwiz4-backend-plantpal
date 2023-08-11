package vn.plantpal.mobile_backend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Products {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;
    @Basic
    @Column(name = "type", nullable = true, length = 30)
    private String productType;
    @Basic
    @Column(name = "name", nullable = true, length = 255)
    private String name;
    @Basic
    @Column(name = "description", nullable = true, columnDefinition = "TEXT")
    private String description;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    private Accessories accessory;
    @OneToOne(mappedBy = "product", fetch = FetchType.LAZY)
    private Plants plant;
    @OneToMany(mappedBy = "product")
    private Collection<ProductSizes> productSizes;
    @OneToMany(mappedBy = "product")
    private Collection<ProductImages> productImages;
}
