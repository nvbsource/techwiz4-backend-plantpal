package vn.plantpal.mobile_backend.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.plantpal.mobile_backend.dtos.product.product_sizes.ProductSizeDetailDTO;
import vn.plantpal.mobile_backend.entities.ProductSizes;

import java.util.List;

@Repository
public interface ProductSizeRepository extends JpaRepository<ProductSizes, String> {
    void deleteAllByProduct_Id(String productId);
    List<ProductSizes> findByIdIn(List<String> ids);

    boolean existsBySizeId(String id);

    @Query("""
    SELECT new vn.plantpal.mobile_backend.dtos.product.product_sizes.ProductSizeDetailDTO(
        ps.id,
        ps.price,
        ps.type,
        ps.madeOnDate,
        ps.width,
        ps.height,
        st.quantity
    )
     FROM ProductSizes ps
     JOIN Stocks st ON st.productSize.id = ps.id
     WHERE ps.product.id = :productId
    """)
    List<ProductSizeDetailDTO> getAllProductSizeByProductId(String productId);


    boolean existsByProductIdAndSizeId(String productId, String sizeId);
}
