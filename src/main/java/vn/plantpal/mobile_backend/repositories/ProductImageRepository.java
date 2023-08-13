package vn.plantpal.mobile_backend.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.plantpal.mobile_backend.entities.ProductImages;

import java.util.List;

public interface ProductImageRepository extends JpaRepository<ProductImages, String> {
//    List<ProductImages> saveAll(List<ProductImages> productImages);
    void deleteAllByProduct_Id(String productId);

    @Query("select im from ProductImages im right join Plants pl on pl.id = im.product.id where pl.id=:id ")
    List<ProductImages> findAllPlantByProductId(String id);

    List<ProductImages> findAllByProduct_Id(String id);
}
