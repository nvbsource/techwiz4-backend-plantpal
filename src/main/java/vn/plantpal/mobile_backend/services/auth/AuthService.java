package vn.plantpal.mobile_backend.services.auth;


import vn.plantpal.mobile_backend.dtos.AuthResponse;
import vn.plantpal.mobile_backend.dtos.LoginDTO;
import vn.plantpal.mobile_backend.dtos.RegisterDTO;
import vn.plantpal.mobile_backend.dtos.RoleDTO;

public interface AuthService {
    AuthResponse login(LoginDTO loginDTO);
    RegisterDTO register(RegisterDTO registerDTO);
    AuthResponse refreshToken(String refreshToken);

    RoleDTO createRole(String roleName);

    AuthResponse authenticateGoogleToken(String tokenId);
}
