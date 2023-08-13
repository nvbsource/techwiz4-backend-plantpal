package vn.plantpal.mobile_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.plantpal.mobile_backend.entities.ProductImages;

public interface ProductImageRepository extends JpaRepository<ProductImages,String> {
}
