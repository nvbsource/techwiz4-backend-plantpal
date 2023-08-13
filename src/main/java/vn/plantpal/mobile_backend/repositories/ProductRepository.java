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
import vn.plantpal.mobile_backend.utils.ProductType;

import java.util.List;

public interface ProductRepository extends JpaRepository<Products,String> {
    @Query("""
    SELECT new vn.plantpal.mobile_backend.dtos.product.ProductSearchDTO(
        p.id,
        p.name,
        p.description,
        MIN(ps.price),
        CASE WHEN COUNT(*) > 1 THEN MAX(ps.price) END,
        SUM(st.quantity),
         pi.productImage
    )
   from ProductSizes ps
        join Sizes s ON ps.size.id = s.id
        join Products p ON ps.product.id = p.id
        join Stocks st ON ps.id = st.productSizesId
        join ProductImages pi ON ps.product.id = pi.product.id AND pi.isThumbnail = TRUE
        group by ps.product.id, p.id, p.name,pi.productImage
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
            ,String keyword
            ,Double priceFrom
            ,Double priceTo
            ,String sortField
            ,String sortOrder
            ,String userId
            ,Pageable pageable
    );


    @Query("""
            SELECT new  vn.plantpal.mobile_backend.dtos.product.ProductSearchDTO(
                pl.id,
                pl.name,
                pl.description,
                MIN(ps.price),
                CASE WHEN COUNT(*) > 1 THEN MAX(ps.price) END,
                SUM(st.quantity),
                pi.productImage,
                CASE WHEN fav.userId IS NOT NULL THEN TRUE ELSE FALSE END
            )
            from ProductSizes ps
            join Sizes s ON ps.size.id = s.id
            join Plants pl ON ps.product.id = pl.id
            join Stocks st ON ps.id = st.productSizesId
            join ProductImages pi ON ps.product.id = pi.product.id
            left join Favorites fav ON pl.id = fav.productId AND fav.userId = :userId
            WHERE
            (:speciesName IS NULL OR pl.specie.name = :speciesName)
            AND (:keyword IS NULL OR pl.name LIKE %:keyword% OR pl.description LIKE %:keyword%)
            AND (:priceFrom IS NULL OR ps.price >= :priceFrom)
            AND (:priceTo IS NULL OR ps.price <= :priceTo)
            AND pi.isThumbnail = TRUE
            AND ps.type = 'PLANT'
            GROUP BY pl.id, pl.name, pl.description,pi.productImage
            ORDER BY
            CASE WHEN :sortField = 'name' AND :sortOrder = 'asc' THEN pl.name END ASC,
            CASE WHEN :sortField = 'name' AND :sortOrder = 'desc' THEN pl.name END DESC,
            CASE WHEN :sortField = 'minPrice' AND :sortOrder = 'asc' THEN MIN(ps.price) END ASC,
            CASE WHEN :sortField = 'minPrice' AND :sortOrder = 'desc' THEN MIN(ps.price) END DESC,
            CASE WHEN :sortField = 'maxPrice' AND :sortOrder = 'asc' THEN MAX(ps.price) END ASC,
            CASE WHEN :sortField = 'maxPrice' AND :sortOrder = 'desc' THEN MAX(ps.price) END DESC,
            CASE WHEN :sortField = 'stockCount' AND :sortOrder = 'asc' THEN SUM(st.quantity) END ASC,
            CASE WHEN :sortField = 'stockCount' AND :sortOrder = 'desc' THEN SUM(st.quantity) END DESC
            """)
    Page<ProductSearchDTO> findAllPlants(
            String speciesName
            ,String keyword
            ,Double priceFrom
            ,Double priceTo
            ,String sortField
            ,String sortOrder
            ,String userId
            ,Pageable pageable
    );


    @Query("""
            SELECT new  vn.plantpal.mobile_backend.dtos.product.ProductSearchDTO(
                ac.id,
                ac.name,
                ac.description,
                MIN(ps.price),
                CASE WHEN COUNT(*) > 1 THEN MAX(ps.price) END,
                SUM(st.quantity),
                pi.productImage,
                CASE WHEN fav.userId IS NOT NULL THEN TRUE ELSE FALSE END
            )
            from ProductSizes ps
            join Sizes s ON ps.size.id = s.id
            join Accessories ac ON ps.product.id = ac.id
            join Stocks st ON ps.id = st.productSizesId
            join ProductImages pi ON ps.product.id = pi.product.id
            left join Favorites fav ON ac.id = fav.productId AND fav.userId = :userId
            WHERE
            (:accessoriesType IS NULL OR ac.accessoriesType.name = :accessoriesType)
            AND (:keyword IS NULL OR ac.name LIKE %:keyword% OR ac.description LIKE %:keyword%)
            AND (:priceFrom IS NULL OR ps.price >= :priceFrom)
            AND (:priceTo IS NULL OR ps.price <= :priceTo)
            AND pi.isThumbnail = TRUE
            AND ps.type = 'ACCESSORIES'
            GROUP BY ac.id, ac.name, ac.description,pi.productImage
            ORDER BY
            CASE WHEN :sortField = 'name' AND :sortOrder = 'asc' THEN ac.name END ASC,
            CASE WHEN :sortField = 'name' AND :sortOrder = 'desc' THEN ac.name END DESC,
            CASE WHEN :sortField = 'minPrice' AND :sortOrder = 'asc' THEN MIN(ps.price) END ASC,
            CASE WHEN :sortField = 'minPrice' AND :sortOrder = 'desc' THEN MIN(ps.price) END DESC,
            CASE WHEN :sortField = 'maxPrice' AND :sortOrder = 'asc' THEN MAX(ps.price) END ASC,
            CASE WHEN :sortField = 'maxPrice' AND :sortOrder = 'desc' THEN MAX(ps.price) END DESC,
            CASE WHEN :sortField = 'stockCount' AND :sortOrder = 'asc' THEN SUM(st.quantity) END ASC,
            CASE WHEN :sortField = 'stockCount' AND :sortOrder = 'desc' THEN SUM(st.quantity) END DESC
            """)
    Page<ProductSearchDTO> findAllAccessories(
            String accessoriesType
            ,String keyword
            ,Double priceFrom
            ,Double priceTo
            ,String sortField
            ,String sortOrder
            ,String userId
            ,Pageable pageable
    );

    @Query("SELECT COUNT (pr.id) FROM Products pr")
    long sumAllQuantity();
}
