package vn.plantpal.mobile_backend.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.plantpal.mobile_backend.dtos.product.ProductSearchDTO;

import vn.plantpal.mobile_backend.entities.Plants;
import vn.plantpal.mobile_backend.entities.Products;

import java.util.List;

public interface ProductRepository extends JpaRepository<Products,String> {
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
    Page<ProductSearchDTO> findAllByNameContainingOrDescriptionContaining(@Param("keyword") String keyword,Pageable pageable);

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
}
