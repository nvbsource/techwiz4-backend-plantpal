package vn.plantpal.mobile_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.plantpal.mobile_backend.entities.Carts;
import vn.plantpal.mobile_backend.entities.Feedback;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback,String> {
    int countByUserIdAndCreatedAtBetween(String userId, LocalDateTime start, LocalDateTime end);
    List<Feedback> findAllByUserId(String userId);
    boolean existsByUser_IdAndContentIgnoreCase(String userId, String content);
}
