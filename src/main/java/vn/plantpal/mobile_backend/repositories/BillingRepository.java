package vn.plantpal.mobile_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.plantpal.mobile_backend.entities.Billings;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface BillingRepository extends JpaRepository<Billings,String> {
    List<Billings> findByUserId(String userId);
    int countAllByStatus(String status);
    @Query("""
            SELECT b FROM Billings b
            WHERE b.orderDate BETWEEN :date AND :date1
            """)
    List<Billings> getBillByOrderDateBetween(LocalDateTime date, LocalDateTime date1);
    List<Billings> findByOrderDate(LocalDateTime date);
}
