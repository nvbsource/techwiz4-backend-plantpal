package vn.plantpal.mobile_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.plantpal.mobile_backend.entities.Billings;
import vn.plantpal.mobile_backend.entities.OrderItems;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItems,String> {

}