package vn.plantpal.mobile_backend.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.plantpal.mobile_backend.entities.Carts;

import vn.plantpal.mobile_backend.entities.Products;

import java.util.List;

public interface ProductRepository extends JpaRepository<Products,String>, JpaSpecificationExecutor<Products> {
    List<Products> findAllByNameContainingOrDescriptionContaining(String keywordForName, String keywordForDes);
}
