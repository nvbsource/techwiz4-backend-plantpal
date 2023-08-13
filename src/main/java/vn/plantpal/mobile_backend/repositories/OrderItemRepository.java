package vn.plantpal.mobile_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.plantpal.mobile_backend.entities.Billings;
import vn.plantpal.mobile_backend.entities.OrderItems;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItems,String> {
    @Query("""
            SELECT COUNT(b.id)
            FROM Billings b join OrderItems oi ON b.id = oi.billing.id
            WHERE b.orderDate >= :startDate AND b.orderDate <= :endDate
            AND oi.productType = :type
            """)
    public List<Long> getOrderByTypeLast7days(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate, String type);
}
