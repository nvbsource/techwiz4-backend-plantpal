package vn.plantpal.mobile_backend.services;


import vn.plantpal.mobile_backend.entities.Tokens;

import java.util.List;

public interface RefreshTokenService {
    List<Tokens> getAll();
    Tokens getOneById(String id);
    Tokens save(Tokens refreshTokens);
    Tokens findByRefreshToken(String token);
    void delete(String id);
}
