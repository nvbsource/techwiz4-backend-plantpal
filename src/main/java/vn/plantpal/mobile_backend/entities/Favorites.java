package vn.plantpal.mobile_backend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@IdClass(FavoritesPK.class)
public class Favorites {
    @Basic
    @Column(name = "id", nullable = false, length = 36)
    private String id;
    @Id
    @Column(name = "user_id", nullable = false, length = 36)
    private String userId;
    @Id
    @Column(name = "product_id", nullable = false, length = 36)
    private String productId;
    @Basic
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    private Users user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    private Products product;

}
