package vn.plantpal.mobile_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.plantpal.mobile_backend.entities.Billings;
import vn.plantpal.mobile_backend.entities.Carts;

import java.util.List;

@Repository
public interface BillingRepository extends JpaRepository<Billings,String> {
    List<Billings> findByUserId(String userId);
}
