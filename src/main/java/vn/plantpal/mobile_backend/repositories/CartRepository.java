package vn.plantpal.mobile_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.plantpal.mobile_backend.dtos.cart.CartBaseDTO;
import vn.plantpal.mobile_backend.entities.Carts;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Carts,String> {
    List<Carts> findByUserId(String userId);
    Carts findByUserIdAndProductSizeId(String userId, String productId);
    void deleteAllByUserId(String userId);
}
