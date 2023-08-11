package vn.plantpal.mobile_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.plantpal.mobile_backend.entities.Plants;

import java.util.Optional;

public interface PlantRepository extends JpaRepository<Plants,String> {
    Optional<Plants> findByName(String name);
}
