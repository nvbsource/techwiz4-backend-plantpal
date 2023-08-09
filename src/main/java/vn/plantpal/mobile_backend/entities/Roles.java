package vn.plantpal.mobile_backend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Roles {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;
    @Basic
    @Column(name = "role_type", nullable = true, length = 255)
    private String roleType;
    @OneToMany(mappedBy = "rolesByRoleId")
    private Collection<Accounts> accountsById;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roles roles = (Roles) o;
        return Objects.equals(id, roles.id) && Objects.equals(roleType, roles.roleType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleType);
    }

    public Collection<Accounts> getAccountsById() {
        return accountsById;
    }

    public void setAccountsById(Collection<Accounts> accountsById) {
        this.accountsById = accountsById;
    }
}
