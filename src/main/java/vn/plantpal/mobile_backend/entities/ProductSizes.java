package vn.plantpal.mobile_backend.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Lazy;

import java.sql.Date;
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
    @Column(name = "price", nullable = true, precision = 0)
    private Double price;
    @Basic
    @Column(name = "type", nullable = true, precision = 0)
    private String type;
    @Basic
    @Column(name = "made_on_date", nullable = true)
    private Date madeOnDate;
    @Basic
    @Column(name = "height", nullable = true)
    private Integer height;
    @Basic
    @Column(name = "width", nullable = true)
    private Integer width;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Products product;
    @Basic
    @Column(name = "is_deleted", nullable = false, columnDefinition = "boolean default false")
    private  boolean isDeleted;
    @ManyToOne
    @JoinColumn(name = "size_id", referencedColumnName = "id")
    private Sizes size;
    @OneToMany(mappedBy = "productSize",fetch = FetchType.LAZY)
    private Collection<Carts> carts;
    @OneToMany(mappedBy = "productSize",fetch = FetchType.LAZY)
    private Collection<OrderItems> orderItems;
    @OneToOne(mappedBy = "productSize")
    private Stocks stock;
    public ProductSizes(Double price, String type, Date madeOnDate, Integer height, Integer width, Products product, Sizes size) {
        this.price = price;
        this.type = type;
        this.madeOnDate = madeOnDate;
        this.height = height;
        this.width = width;
        this.product = product;
        this.size = size;
    }

    public ProductSizes(String id, Double price, String type, Date madeOnDate, Integer height, Integer width, Products product, Sizes size) {
        this.id = id;
        this.price = price;
        this.type = type;
        this.madeOnDate = madeOnDate;
        this.height = height;
        this.width = width;
        this.product = product;
        this.size = size;
    }

}
