package vn.plantpal.mobile_backend.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import vn.plantpal.mobile_backend.entities.ProductImages;

import java.util.List;

public interface ProductImageRepository extends JpaRepository<ProductImages, String> {
//    List<ProductImages> saveAll(List<ProductImages> productImages);
    void deleteAllByProduct_Id(String productId);

    List<ProductImages> findAllByProduct_Id(String id);
}
