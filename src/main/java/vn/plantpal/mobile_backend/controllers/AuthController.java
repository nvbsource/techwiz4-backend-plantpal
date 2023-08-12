package vn.plantpal.mobile_backend.controllers;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.plantpal.mobile_backend.dtos.AuthResponse;
import vn.plantpal.mobile_backend.dtos.LoginDTO;
import vn.plantpal.mobile_backend.dtos.RegisterDTO;
import vn.plantpal.mobile_backend.dtos.RoleDTO;
import vn.plantpal.mobile_backend.services.auth.AuthService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginDTO loginDTO){
        return ResponseEntity.ok(authService.login(loginDTO));
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterDTO> register(@Valid @RequestBody RegisterDTO registerDTO){
        return ResponseEntity.ok(authService.register(registerDTO));
    }

    @PostMapping("/refreshToken/{refreshToken}")
    public ResponseEntity<AuthResponse> refreshToken(@PathVariable String refreshToken){
        return ResponseEntity.ok(authService.refreshToken(refreshToken));
    }

    @PostMapping("/roles/{roleName}")
    public ResponseEntity<RoleDTO> createRole(@PathVariable String roleName){
        return ResponseEntity.ok(authService.createRole(roleName));
    }

    @PostMapping("/google/{tokenId}")
    public ResponseEntity<AuthResponse> validateGoogleToken(@PathVariable String tokenId){
         return ResponseEntity.ok(authService.authenticateGoogleToken(tokenId));
    }
    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
