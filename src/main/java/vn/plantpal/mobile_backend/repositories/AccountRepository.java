package vn.plantpal.mobile_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.plantpal.mobile_backend.entities.Accounts;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Accounts,String> {
    Optional<Accounts> findByEmail(String email);
    Optional<Accounts> findByGoogleId(String googleId);
}
