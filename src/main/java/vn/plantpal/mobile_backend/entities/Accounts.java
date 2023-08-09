package vn.plantpal.mobile_backend.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "accounts")
public class Accounts implements UserDetails {

    @Id
    @Column(name = "id",  length = 36)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Basic
    @Column(name = "username", nullable = true, length = 40,unique = true)
    private String username;
    @Basic
    @Column(name = "password", nullable = true, length = 70)
    private String password;
    @Basic
    @Column(name = "google_id", nullable = true, length = 70)
    private String googleId;
    @Basic
    @Column(name = "is_deleted", nullable = true)
    private Boolean isDeleted;
    @Basic
    @Column(name = "role_id", nullable = false, length = 36)
    private String roleId;

    @OneToOne(mappedBy = "accountByAccountId",fetch = FetchType.LAZY)
    private Users usersById;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Roles rolesByRoleId;
    @OneToMany(mappedBy = "accountsByAccountId",fetch = FetchType.LAZY)
    private Collection<Tokens> tokensByTokenId;

    @PrePersist
    public void prePersist() {
        this.id = UUID.randomUUID().toString();
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(rolesByRoleId.getRoleType()));
    }
    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
