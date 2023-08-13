package vn.plantpal.mobile_backend.repositories;

import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.plantpal.mobile_backend.entities.OrderItems;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

;
import java.time.LocalDate;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItems,String> {
    @Query(value = """
            SELECT COUNT(*)
            FROM billings b join order_items oi ON b.id = oi.bill_id
            WHERE DATE (b.order_date) = :currentDate
            AND oi.product_type = :type
            """, nativeQuery = true)
    Long getOrderByTypeAndDate(@Param("currentDate") String currentDate, String type);

}
