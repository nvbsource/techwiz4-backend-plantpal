package vn.plantpal.mobile_backend.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.plantpal.mobile_backend.dtos.product.ProductSearchDTO;

import vn.plantpal.mobile_backend.entities.Products;

import java.util.List;

public interface ProductRepository extends JpaRepository<Products, String> {
    List<ProductSearchDTO> findAllByNameContainingOrDescriptionContaining(String keywordForName, String keywordForDes);

    Page<Products> findAllByProductType(String productType, Pageable pageable);

}
