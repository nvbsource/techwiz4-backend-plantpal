package vn.plantpal.mobile_backend.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.plantpal.mobile_backend.entities.Accessories;
@Repository
public interface AccessoryRepository extends JpaRepository<Accessories,String> {
    @Query("select a from Accessories a")
    Page<Accessories> findAllPageable(Pageable pageable);



}
