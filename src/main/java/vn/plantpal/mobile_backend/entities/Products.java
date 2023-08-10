package vn.plantpal.mobile_backend.entities;

import jakarta.persistence.*;
import lombok.*;
import test123.ProductSizes;

import java.util.Collection;
import java.util.Objects;

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
    private String type;
    @Basic
    @Column(name = "name", nullable = true, length = 255)
    private String name;
    @Basic
    @Column(name = "description", nullable = true,length = 500)
    private String description;
    @OneToOne(mappedBy = "product",fetch = FetchType.LAZY)
    private Accessories accessory;
    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
    private Collection<Carts> carts;
    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
    private Collection<OrderItems> orderItems;
    @OneToMany(mappedBy = "product_0",fetch = FetchType.LAZY)
    private Collection<OrderItems> orderItems_0;
    @OneToOne(mappedBy = "product",fetch = FetchType.LAZY)
    private Plants plant;
    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
    private Collection<Stocks> stocks;
    @OneToMany(mappedBy = "product_0",fetch = FetchType.LAZY)
    private Collection<Stocks> stocks_0;
    @OneToMany(mappedBy = "product")
    private Collection<ProductSizes> productSizes;
}
