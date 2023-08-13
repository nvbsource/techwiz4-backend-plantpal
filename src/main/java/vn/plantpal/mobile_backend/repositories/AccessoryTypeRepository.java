package vn.plantpal.mobile_backend.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.plantpal.mobile_backend.dtos.accesoryType.AccessoryTypeInfoDto;
import vn.plantpal.mobile_backend.entities.AccessoriesTypes;

@Repository
public interface AccessoryTypeRepository extends JpaRepository<AccessoriesTypes, String> {
    @Query("SELECT s FROM AccessoriesTypes s")
    Page<AccessoriesTypes> findAllPage(Pageable pageable);
    @Query("SELECT at FROM AccessoriesTypes at WHERE at.fatherAccessoriesTypes IS NULL")
    Page<AccessoriesTypes> findAllFatherPage(Pageable pageable);

    boolean existsByName(String name);

    boolean existsByNameAndIdNot(String name, String id);
    boolean existsByIdAndFatherAccessoriesTypesIsNotNull(String id);

    @Query("SELECT at FROM AccessoriesTypes at JOIN Accessories ac on at.id = ac.accessoriesType.id where ac.id =:id")
    AccessoriesTypes findByAccessoriesId(String id);
}
