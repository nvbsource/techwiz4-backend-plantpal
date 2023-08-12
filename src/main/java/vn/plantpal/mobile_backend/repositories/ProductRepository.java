package vn.plantpal.mobile_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.plantpal.mobile_backend.dtos.product.ProductSearchDTO;
import vn.plantpal.mobile_backend.entities.Products;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products,String> {
    List<ProductSearchDTO> findAllByNameContainingOrDescriptionContaining(String keywordForName, String keywordForDes);
   List<Products> findByIdIn(List<String> ids);
}
