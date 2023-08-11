package vn.plantpal.mobile_backend.entities;

import jakarta.persistence.*;
import lombok.*;

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
    @ManyToOne
    @JoinColumn(name = "size_id", referencedColumnName = "id")
    private Sizes size;
}
