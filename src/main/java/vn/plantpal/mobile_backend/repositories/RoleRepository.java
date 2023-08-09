package vn.plantpal.mobile_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.plantpal.mobile_backend.entities.Roles;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Roles,String> {
    Optional<Roles> findByRoleType(String roleType);
    @Query("SELECT r FROM Roles r JOIN Accounts a ON a.rolesByRoleId.id = r.id where a.id =:accountId")
    Optional<Roles> findByAccountId(String accountId);
}
