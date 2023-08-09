package vn.plantpal.mobile_backend.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Accounts implements UserDetails {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;
    @Basic
    @Column(name = "username", nullable = true, length = 40)
    private String username;
    @Basic
    @Column(name = "google_id", nullable = true, length = 255)
    private String googleId;
    @Basic
    @Column(name = "password", nullable = true, length = 70)
    private String password;
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Roles role;
    @OneToMany(mappedBy = "account",fetch = FetchType.LAZY)
    private Collection<Tokens> tokens;
    @OneToMany(mappedBy = "account",fetch = FetchType.LAZY)
    private Collection<Users> users;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.getRoleType()));
    }
}
