package vn.plantpal.mobile_backend.dtos;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AuthResponse {
    private String accessToken;
    private String refreshToken;
    private static final String tokenType = "Bearer";
}
