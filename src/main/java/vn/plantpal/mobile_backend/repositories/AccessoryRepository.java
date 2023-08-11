package vn.plantpal.mobile_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.plantpal.mobile_backend.entities.Accessories;

public interface AccessoryRepository extends JpaRepository<Accessories,String> {
}
