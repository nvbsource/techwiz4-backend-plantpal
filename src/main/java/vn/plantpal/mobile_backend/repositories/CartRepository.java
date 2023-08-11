package vn.plantpal.mobile_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.plantpal.mobile_backend.entities.Carts;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Carts,String> {
    List<Carts> findByUserId(String userId);
    Carts findByUserIdAndProductId(String userId, String productId);
}
