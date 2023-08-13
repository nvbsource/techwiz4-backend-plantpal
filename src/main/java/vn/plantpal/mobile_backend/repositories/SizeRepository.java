package vn.plantpal.mobile_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.plantpal.mobile_backend.entities.Sizes;

import java.util.Optional;

public interface SizeRepository extends JpaRepository<Sizes,String> {
    boolean existsBySizeType(String sizeId);
}