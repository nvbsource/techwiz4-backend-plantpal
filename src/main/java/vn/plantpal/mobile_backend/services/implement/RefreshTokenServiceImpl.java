package vn.plantpal.mobile_backend.services.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import vn.plantpal.mobile_backend.entities.Tokens;
import vn.plantpal.mobile_backend.exceptions.AppException;
import vn.plantpal.mobile_backend.exceptions.ResourceNotFoundException;
import vn.plantpal.mobile_backend.repositories.RefreshTokenRepository;
import vn.plantpal.mobile_backend.services.RefreshTokenService;
import vn.plantpal.mobile_backend.utils.TokenType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RefreshTokenServiceImpl implements RefreshTokenService {
    private final String REFRESH_TOKEN = TokenType.REFRESH_TOKEN.toString();

    private final RefreshTokenRepository refreshTokenRepository;

    @Override
    public List<Tokens> getAll() {
        return refreshTokenRepository.findAll();
    }

    @Override
    public Tokens getOneById(String id) {
        Tokens token = refreshTokenRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(REFRESH_TOKEN,"id",id));
        int compareTime = token.getExpiryTime().compareTo(Instant.now());
        if(compareTime >= 0){
            // >= 0 means this token expired
            throw new AppException(HttpStatus.UNAUTHORIZED,"Refresh Token Expired");
        }else{
            return token;
        }
    }

    @Override
    public Tokens save(Tokens refreshTokens) {
        return refreshTokenRepository.save(refreshTokens);
    }

    @Override
    public Tokens findByRefreshToken(String refreshToken) {
        Tokens token =
                refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(()->new ResourceNotFoundException(REFRESH_TOKEN,"token",refreshToken));


        Date now = new Date(System.currentTimeMillis());
        Date tokenExpiryTime;
        try {
            tokenExpiryTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS").parse(String.valueOf(token.getExpiryTime()));
        } catch (ParseException e) {
            throw new AppException(HttpStatus.INTERNAL_SERVER_ERROR,"The Date Could Not Be Parsed.");
        }
        boolean isAfter = tokenExpiryTime.after(now);

        if(isAfter){
            return token;
        }else{
            refreshTokenRepository.delete(token);
            throw new AppException(HttpStatus.UNAUTHORIZED,"Refresh Token Expired");
        }
    }

    @Override
    public void delete(String id) {
        Tokens refreshToken = refreshTokenRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(REFRESH_TOKEN,"id",id));
        refreshTokenRepository.delete(refreshToken);
    }
}
