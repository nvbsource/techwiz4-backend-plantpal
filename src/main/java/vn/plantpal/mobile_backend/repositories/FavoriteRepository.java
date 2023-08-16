package vn.plantpal.mobile_backend.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.plantpal.mobile_backend.dtos.product.ProductSearchDTO;
import vn.plantpal.mobile_backend.entities.Favorites;
import vn.plantpal.mobile_backend.entities.FavoritesPK;

import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<Favorites, FavoritesPK> {
    @Query("""
            SELECT new  vn.plantpal.mobile_backend.dtos.product.ProductSearchDTO(
                p.id,
                p.name,
                MIN(ps.price),
                CASE WHEN COUNT(*) > 1 THEN MAX(ps.price) END,
                SUM(st.quantity),
                pi.productImage,
                CASE WHEN fav.userId IS NOT NULL THEN TRUE ELSE FALSE END
            )
            from ProductSizes ps
            join Sizes s ON ps.size.id = s.id
            join Products p ON ps.product.id = p.id
            join Stocks st ON ps.id = st.productSizesId
            join ProductImages pi ON ps.product.id = pi.product.id
            join Favorites fav ON p.id = fav.productId AND fav.userId = :userId
            WHERE
            (:productType IS NULL OR p.productType = :productType)
            AND (:keyword IS NULL OR p.name LIKE %:keyword%)
            AND (:priceFrom IS NULL OR ps.price >= :priceFrom)
            AND (:priceTo IS NULL OR ps.price <= :priceTo)
            AND pi.isThumbnail = TRUE
            GROUP BY p.id, p.name,pi.productImage
            ORDER BY
            CASE WHEN :sortField = 'name' AND :sortOrder = 'asc' THEN p.name END ASC,
            CASE WHEN :sortField = 'name' AND :sortOrder = 'desc' THEN p.name END DESC,
            CASE WHEN :sortField = 'minPrice' AND :sortOrder = 'asc' THEN MIN(ps.price) END ASC,
            CASE WHEN :sortField = 'minPrice' AND :sortOrder = 'desc' THEN MIN(ps.price) END DESC,
            CASE WHEN :sortField = 'maxPrice' AND :sortOrder = 'asc' THEN MAX(ps.price) END ASC,
            CASE WHEN :sortField = 'maxPrice' AND :sortOrder = 'desc' THEN MAX(ps.price) END DESC,
            CASE WHEN :sortField = 'stockCount' AND :sortOrder = 'asc' THEN SUM(st.quantity) END ASC,
            CASE WHEN :sortField = 'stockCount' AND :sortOrder = 'desc' THEN SUM(st.quantity) END DESC
            """)
    Page<ProductSearchDTO> getFavoritesByUserId(
            String productType
            , String keyword
            , Double priceFrom
            , Double priceTo
            , String sortField
            , String sortOrder
            , String userId
            , Pageable pageable
    );

    Optional<Favorites> findByUserIdAndProductId(String userId, String productId);
    boolean existsByUserIdAndProductId(String userId, String productId);
}
