package vn.plantpal.mobile_backend.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.plantpal.mobile_backend.entities.Species;

@Repository
public interface SpeciesRepository extends JpaRepository<Species, String> {
    //    Page<Species> findAllPage(Pageable pageable);
    @Query("SELECT s FROM Species s")
    Page<Species> findAllPage(Pageable pageable);

    boolean existsByName(String name);

    boolean existsByNameAndIdNot(String name, String id);
}
