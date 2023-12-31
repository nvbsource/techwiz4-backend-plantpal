package vn.plantpal.mobile_backend.securities.CustomUserDetailServices;



import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import vn.plantpal.mobile_backend.dtos.AccountDTO;
import vn.plantpal.mobile_backend.dtos.AuthUserDTO;
import vn.plantpal.mobile_backend.securities.CustomUserDetails.CustomUserDetails;
import vn.plantpal.mobile_backend.services.accounts.AccountService;
import vn.plantpal.mobile_backend.services.role.RoleService;
import vn.plantpal.mobile_backend.services.users.UserService;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final AccountService accountService;
    private final UserService userService;
    private final RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountDTO accountDTO = accountService.getOneByUsername(username);
        if(accountDTO == null){
            throw new UsernameNotFoundException("Username not exists");
        }else{
            String accountId = accountDTO.getId();
            AuthUserDTO authUserDTO = new AuthUserDTO();
            String roleType = roleService.getOne(accountId).getRoleType();
            String userId = userService.getOne(accountId).getId();
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_" + roleType));
            authUserDTO.setUsername(accountDTO.getUsername());

            authUserDTO.setPassword(accountDTO.getPassword());
            authUserDTO.setAuthorities(authorities);
            authUserDTO.setUserID(userId);
            return new CustomUserDetails(authUserDTO);
        }
    }
}
