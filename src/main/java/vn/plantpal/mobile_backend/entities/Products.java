package vn.plantpal.mobile_backend.entities;

import jakarta.persistence.*;
import lombok.*;
import vn.plantpal.mobile_backend.utils.ProductType;

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
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private Collection<ProductSizes> productSizes;
    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
    private Collection<ProductImages> productImages;
    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
    private Collection<Favorites> favorites;


    public Products(String name, String description, String productType) {
        this.productType = productType;
        this.name = name;
        this.description = description;
    }

    public Products(String id, String productType, String name, String description) {
        this.id = id;
        this.productType = productType;
        this.name = name;
        this.description = description;
    }
}
