package vn.plantpal.mobile_backend.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.plantpal.mobile_backend.dtos.lights.LightRequiresDto;
import vn.plantpal.mobile_backend.entities.LightRequires;

import java.util.List;

@Repository
public interface LightRepository extends JpaRepository<LightRequires, String> {
    //    Page<Species> findAllPage(Pageable pageable);
    @Query("SELECT s FROM Species s")
    Page<LightRequires> findAllPage(Pageable pageable);

    boolean existsByStrength(String strength);
    boolean existsByOrders(Integer orders);
//    Find all by order where order is larger than current order
    @Query("SELECT s FROM LightRequires s WHERE s.orders > ?1")
    List<LightRequires> findAllByOrderLargerThanNum(Integer order);

//    List<LightRequires> findAllByOrder(Integer order);
    boolean existsByStrengthAndIdNot(String strength, String id);

    @Query("select li from LightRequires li join Plants pl on pl.lightRequire.id = li.id where pl.id =:id")
    LightRequires findByPlantId(String id);
}
