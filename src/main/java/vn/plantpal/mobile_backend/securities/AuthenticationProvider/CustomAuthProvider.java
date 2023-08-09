package vn.plantpal.mobile_backend.securities.AuthenticationProvider;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import vn.plantpal.mobile_backend.exceptions.UserNotFoundException;
import vn.plantpal.mobile_backend.securities.CustomUserDetailServices.CustomUserDetailService;

@Component
@RequiredArgsConstructor
public class CustomAuthProvider  implements AuthenticationProvider {
    private final PasswordEncoder passwordEncoder;
    private final CustomUserDetailService userDetailService;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        boolean isPasswordCorrect;
        boolean isUsernameCorrect;
        String username = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();

        if(username == null || password == null){
            throw new BadCredentialsException("Username and Password cannot be blank");
        }

        UserDetails userDetails = userDetailService.loadUserByUsername(username);
        if(userDetails != null && userDetails.getPassword() != null && userDetails.getUsername() != null){
            isUsernameCorrect = userDetails.getUsername().equals(username);
            isPasswordCorrect = passwordEncoder.matches(password, userDetails.getPassword());
            if(!isPasswordCorrect || !isUsernameCorrect){
                throw new UserNotFoundException("Invalid Username or Password");
            }else{
                return new UsernamePasswordAuthenticationToken(userDetails,userDetails.getPassword(),userDetails.getAuthorities());
            }
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
