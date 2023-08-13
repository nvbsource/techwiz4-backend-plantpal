package vn.plantpal.mobile_backend.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.plantpal.mobile_backend.dtos.stock.StockResponseDTO;
import vn.plantpal.mobile_backend.entities.Stocks;

@Repository
public interface StockRepository extends JpaRepository<Stocks,String> {
    @Query("""
            SELECT new  vn.plantpal.mobile_backend.dtos.stock.StockResponseDTO(
                st.id,
                ps.id,
                p.id,
                p.name,
                ps.size.sizeType,
                st.quantity,
                pi.productImage,
                st.createdAt,
                st.updatedAt
            )
            from ProductSizes ps
            join Sizes s ON ps.size.id = s.id
            join Products p ON ps.product.id = p.id
            join Stocks st ON ps.id = st.productSizesId
            join ProductImages pi ON ps.product.id = pi.product.id
            WHERE
            (:productType IS NULL OR p.productType = :productType)
            AND (:keyword IS NULL OR p.name LIKE %:keyword%)
            AND (:priceFrom IS NULL OR ps.price >= :priceFrom)
            AND (:priceTo IS NULL OR ps.price <= :priceTo)
            AND pi.isThumbnail = TRUE
            GROUP BY st.id,
                ps.id,
                p.id,
                p.name,
                ps.size.sizeType,
                st.quantity,
                pi.productImage,
                st.createdAt,
                st.updatedAt
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
    Page<StockResponseDTO> getStocks(
            String productType
            , String keyword
            , Double priceFrom
            , Double priceTo
            , String sortField
            , String sortOrder
            , Pageable pageable
    );


    @Query("SELECT SUM(oi.quantity) FROM OrderItems oi")
    Long getTotalStocks();

    Stocks getFirstByProductSize_Id(String id);
}
