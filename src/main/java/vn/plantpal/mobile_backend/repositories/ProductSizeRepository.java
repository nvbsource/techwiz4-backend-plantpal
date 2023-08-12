package vn.plantpal.mobile_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.plantpal.mobile_backend.entities.ProductSizes;
import vn.plantpal.mobile_backend.entities.Products;

import java.util.List;

@Repository
public interface ProductSizeRepository extends JpaRepository<ProductSizes,String> {
    List<ProductSizes> findByIdIn(List<String> ids);
}
