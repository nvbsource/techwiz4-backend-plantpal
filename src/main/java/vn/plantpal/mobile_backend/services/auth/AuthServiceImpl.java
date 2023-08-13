package vn.plantpal.mobile_backend.services.auth;


import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import vn.plantpal.mobile_backend.dtos.*;
import vn.plantpal.mobile_backend.entities.Accounts;
import vn.plantpal.mobile_backend.entities.Tokens;
import vn.plantpal.mobile_backend.entities.Users;
import vn.plantpal.mobile_backend.exceptions.AppException;
import vn.plantpal.mobile_backend.securities.JWT.JwtService;
import vn.plantpal.mobile_backend.services.accounts.AccountService;
import vn.plantpal.mobile_backend.services.email.EmailSenderService;
import vn.plantpal.mobile_backend.services.refresh_token.RefreshTokenService;
import vn.plantpal.mobile_backend.services.role.RoleService;
import vn.plantpal.mobile_backend.services.users.UserService;
import vn.plantpal.mobile_backend.utils.EntityMapper;
import vn.plantpal.mobile_backend.utils.GoogleValidator;
import vn.plantpal.mobile_backend.utils.RoleType;
import vn.plantpal.mobile_backend.utils.TokenType;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final RefreshTokenService refreshTokenService;
    private final AccountService accountService;
    private final UserService userService;
    private final RoleService roleService;
    private final JwtService jwtService;
    private final GoogleValidator googleValidator;
    private final EmailSenderService emailSenderService;
    private final String ACCESS_TOKEN = TokenType.ACCESS_TOKEN.toString();
    private final String REFRESH_TOKEN = TokenType.REFRESH_TOKEN.toString();
    private final String USER = RoleType.USER.toString();

    @Override
    public AuthResponse login(LoginDTO loginDTO) {
        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword();

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        AccountDTO accountDTO = accountService.getOneByUsername(username);
        if (accountDTO != null) {
            Accounts accounts = EntityMapper.mapToEntity(accountDTO, Accounts.class);
            String accessToken = jwtService.generateToken(ACCESS_TOKEN, accounts);
            String refreshToken = jwtService.generateToken(REFRESH_TOKEN, accounts);
            return AuthResponse.builder()
                    .accessToken(accessToken)
                    .refreshToken(refreshToken)
                    .build();
        }
        return null;
    }

    @Override
    @Transactional
    public RegisterDTO register(RegisterDTO registerDTO) {
        String username = registerDTO.getUsername();
        String password = registerDTO.getPassword();
        String fullName = registerDTO.getFullName();
        String email = registerDTO.getEmail();
        String phone = registerDTO.getPhone();
        Date dob = registerDTO.getDob();
        String address = registerDTO.getAddress();
        Boolean gender = registerDTO.getGender();
        String avatar = registerDTO.getAvatar();
        RoleDTO roleDTO = roleService.getOneByRoleType(USER);

        AccountDTO accountDTO = AccountDTO.builder()
                .username(username)
                .password(password)
                .roleId(roleDTO.getId()).build();
        accountDTO = accountService.create(accountDTO);
        UserDTO userDTO = UserDTO.builder()
                .accountId(accountDTO.getId())
                .email(email)
                .fullName(fullName)
                .avatar(avatar)
                .phone(phone)
                .gender(gender)
                .address(address)
                .dob(dob)
                .build();
        userService.create(userDTO);
        Map<String,String> data = new HashMap<>();
        data.put("username",username);
        String subject = "Welcome to PlantPal";
        emailSenderService.sendEmail(email,subject,"email_welcome.html",data);
        return RegisterDTO.builder()
                .username(accountDTO.getUsername())
                .email(email)
                .fullName(fullName)
                .avatar(avatar)
                .phone(phone)
                .gender(gender)
                .address(address)
                .dob(dob)
                .build();

    }

    @Override
    public AuthResponse refreshToken(String refreshToken) {

        Tokens token = refreshTokenService.findByRefreshToken(refreshToken);
        String newAccessToken = jwtService.generateToken(ACCESS_TOKEN, token.getAccount());
        return AuthResponse.builder()
                .accessToken(newAccessToken)
                .build();
    }

    @Override
    public RoleDTO createRole(String roleType) {
        return roleService.create(roleType.toUpperCase());
    }

    @Override
    public AuthResponse authenticateGoogleToken(String tokenId) {
        String accessToken;
        String refreshToken;
        AccountDTO accountDTO;
        GoogleIdToken.Payload payload = googleValidator.validateToken(tokenId);
        if (payload != null) {
            String googleId = payload.getSubject();
            String email = payload.getEmail();
            //get role with role type "user"
            RoleDTO roleDTO = roleService.getOneByRoleType(USER);
            String roleId = roleDTO.getId();
            //if account with googleID not exists
            Optional<AccountDTO> optionalAccounts = Optional.ofNullable(accountService.getOneByEmail(email));
            if (optionalAccounts.isPresent()) {
                accountDTO = optionalAccounts.get();
                if (accountDTO.getGoogleId() == null) {
                    accountDTO.setGoogleId(googleId);
                    accountService.update(accountDTO);
                }
            } else {
                accountDTO = AccountDTO.builder()
                        .username(email)
                        .password(null)
                        .googleId(googleId)
                        .roleId(roleId)
                        .build();
                accountService.create(accountDTO);
                //save users
                Users users = Users.builder().build();

            }
            Accounts accounts = EntityMapper.mapToEntity(accountDTO, Accounts.class);
            accessToken = jwtService.generateToken(ACCESS_TOKEN, accounts);
            refreshToken = jwtService.generateToken(REFRESH_TOKEN, accounts);
            return AuthResponse.builder()
                    .accessToken(accessToken)
                    .refreshToken(refreshToken)
                    .build();
        } else {
            throw new AppException(HttpStatus.UNAUTHORIZED, "IDToken Expired");
        }
    }
}


