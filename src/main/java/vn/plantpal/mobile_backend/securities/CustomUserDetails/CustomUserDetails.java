package vn.plantpal.mobile_backend.securities.CustomUserDetails;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import vn.plantpal.mobile_backend.dtos.AuthUserDTO;

import java.util.Collection;

@Data
public class CustomUserDetails implements UserDetails {
   private AuthUserDTO authUser;

    public CustomUserDetails(AuthUserDTO authUser) {
        this.authUser = authUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authUser.getAuthorities();
    }

    @Override
    public String getPassword() {
        return authUser.getPassword();
    }

    @Override
    public String getUsername() {
        return authUser.getUsername();
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
