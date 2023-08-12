package vn.plantpal.mobile_backend.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.plantpal.mobile_backend.entities.ProductSizes;

@Repository
public interface ProductSizeRepository extends JpaRepository<ProductSizes, String> {
    void deleteAllByProduct_Id(String productId);
}
