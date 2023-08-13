package vn.plantpal.mobile_backend.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product_images", schema = "TechwizDB")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductImages {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;
    @Basic
    @Column(name = "product_image", nullable = true, length = 500)
    private String productImage;
    @Basic
    @Column(name = "is_thumbnail", nullable = false)
    private boolean isThumbnail = false;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Products product;

}
