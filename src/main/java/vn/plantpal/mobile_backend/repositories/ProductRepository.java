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
    Page<ProductSearchDTO> findAllByNameContainingOrDescriptionContaining(String keywordForName, String keywordForDes,Pageable pageable);

    @Query("SELECT ps.id FROM ProductSizes ps  WHERE ps.type = :type AND ps.price BETWEEN :lowerValue AND :upperValue")
    List<String> findProductsBetweenPrice(@Param("lowerValue") double lowerValue, @Param("upperValue") double upperValue, String type, Pageable pageable);
}
