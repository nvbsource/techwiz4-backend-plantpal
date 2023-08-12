package vn.plantpal.mobile_backend.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.plantpal.mobile_backend.entities.Plants;

import java.util.List;
import java.util.Optional;

public interface PlantRepository extends JpaRepository<Plants,String> {
    Optional<Plants> findByName(String name);
    Page<Plants> findAllByIdIn(List<String> ids, Pageable pageable);
}
