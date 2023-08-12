package vn.plantpal.mobile_backend.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.plantpal.mobile_backend.dtos.AuthUserDTO;
import vn.plantpal.mobile_backend.dtos.product.ProductSearchDTO;

import vn.plantpal.mobile_backend.entities.Plants;
import vn.plantpal.mobile_backend.entities.Products;

import java.util.List;

public interface ProductRepository extends JpaRepository<Products, String> {
    @Query("""
                SELECT new vn.plantpal.mobile_backend.dtos.product.ProductSearchDTO(
                    p.id,
                    p.name,
                    p.description,
                    MIN(ps.price),
                    CASE WHEN COUNT(*) > 1 THEN MAX(ps.price) END,
                    SUM(st.quantity)
                )
               from ProductSizes ps
                    join Sizes s ON ps.size.id = s.id
                    join Products p ON ps.product.id = p.id
                    join Stocks st ON ps.id = st.productSizesId
                    WHERE (p.name LIKE %:keyword%
                             OR p.description LIKE %:keyword%)
                    group by ps.product.id, p.id, p.name
            """)
    Page<ProductSearchDTO> findAllByNameContainingOrDescriptionContaining(@Param("keyword") String keyword, Pageable pageable);

    @Query("SELECT ps.id FROM ProductSizes ps  WHERE ps.type = :type AND ps.price BETWEEN :lowerValue AND :upperValue")
    Page<String> findProductsBetweenPrice(@Param("lowerValue") double lowerValue, @Param("upperValue") double upperValue, String type, Pageable pageable);

    @Query("""
                SELECT new vn.plantpal.mobile_backend.dtos.product.ProductSearchDTO(
                    p.id,
                    p.name,
                    p.description,
                    MIN(ps.price),
                    CASE WHEN COUNT(*) > 1 THEN MAX(ps.price) END,
                    SUM(st.quantity)
                )
               from ProductSizes ps
                    join Sizes s ON ps.size.id = s.id
                    join Products p ON ps.product.id = p.id
                    join Stocks st ON ps.id = st.productSizesId
                    group by ps.product.id, p.id, p.name
            """)
    Page<ProductSearchDTO> findAllProduct(Pageable pageable);


    @Query("""
            SELECT new  vn.plantpal.mobile_backend.dtos.product.ProductSearchDTO(
                p.id,
                p.name,
                p.description,
                MIN(ps.price),
                CASE WHEN COUNT(*) > 1 THEN MAX(ps.price) END,
                SUM(st.quantity),
                pi.productImage,
                FALSE
            )
            from ProductSizes ps
            join Sizes s ON ps.size.id = s.id
            join Products p ON ps.product.id = p.id
            join Stocks st ON ps.id = st.productSizesId
            join ProductImages pi ON ps.product.id = pi.product.id
            WHERE
            (:productType IS NULL OR p.productType = :productType)
            AND (:keyword IS NULL OR p.name LIKE %:keyword% OR p.description LIKE %:keyword%)
            AND (:priceFrom IS NULL OR ps.price >= :priceFrom)
            AND (:priceTo IS NULL OR ps.price <= :priceTo)
            AND pi.isThumbnail = TRUE
            GROUP BY p.id, p.name, p.description,pi.productImage
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
    Page<ProductSearchDTO> searchAndFilterProducts(
            String productType
            , String keyword
            , Double priceFrom
            , Double priceTo,
            String sortField
            , String sortOrder
            , Pageable pageable
    );

    @Query("""
            SELECT new  vn.plantpal.mobile_backend.dtos.product.ProductSearchDTO(
                p.id,
                p.name,
                p.description,
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
            left join Favorites fav ON p.id = fav.productId AND fav.userId = :userId
            WHERE
            (:productType IS NULL OR p.productType = :productType)
            AND (:keyword IS NULL OR p.name LIKE %:keyword% OR p.description LIKE %:keyword%)
            AND (:priceFrom IS NULL OR ps.price >= :priceFrom)
            AND (:priceTo IS NULL OR ps.price <= :priceTo)
            AND pi.isThumbnail = TRUE
            GROUP BY p.id, p.name, p.description,pi.productImage
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
    Page<ProductSearchDTO> searchAndFilterProducts(
            String productType
            , String keyword
            , Double priceFrom
            , Double priceTo
            , String sortField
            , String sortOrder
            , String userId
            , Pageable pageable
    );
}
