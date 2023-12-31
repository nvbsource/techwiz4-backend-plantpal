package vn.plantpal.mobile_backend.securities.JWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import vn.plantpal.mobile_backend.entities.Accounts;
import vn.plantpal.mobile_backend.entities.Tokens;
import vn.plantpal.mobile_backend.exceptions.AppException;
import vn.plantpal.mobile_backend.services.accounts.AccountService;
import vn.plantpal.mobile_backend.services.refresh_token.RefreshTokenService;
import vn.plantpal.mobile_backend.utils.EntityMapper;
import vn.plantpal.mobile_backend.utils.TokenType;

import java.security.Key;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class JwtService {
    @Value("${app.jwt-secret}")
    public String jwtSecret;
    @Value("${app.jwt-expiration-milliseconds}")
    public Long jwtExpiry;

    private final RefreshTokenService refreshTokenService;
    private final AccountService accountService;
    private final String ACCESS_TOKEN = TokenType.ACCESS_TOKEN.toString();
    private final String REFRESH_TOKEN = TokenType.REFRESH_TOKEN.toString();


    private Key getSignInKey(){
        return Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }

    public String generateToken(String tokenType, UserDetails userDetails){
        return generateToken(tokenType, new HashMap<>(),userDetails);
    }

    public String generateToken(String tokenType, Map<String,Object> extraClaims, UserDetails userDetails){
        long timeExpired = 0;
        Instant issuedAt = Instant.ofEpochSecond(System.currentTimeMillis());
        String username = userDetails.getUsername();
        if(tokenType == null) {
            throw new AppException(HttpStatus.INTERNAL_SERVER_ERROR, "Token Type Is Required");
        }else if(tokenType.equals(ACCESS_TOKEN)){
            timeExpired = System.currentTimeMillis() + jwtExpiry;
        }else if(tokenType.equals(REFRESH_TOKEN)){
            //expiry time of refresh token greater than 3 times access token
            //example access token expiry time is 1 day so refresh token is 3 days.
            timeExpired = System.currentTimeMillis() + jwtExpiry*3;
        }
        String token = Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(username)
                .setIssuedAt(Date.from(issuedAt))
                .setExpiration(new Date(timeExpired))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();


        if(tokenType.equals(REFRESH_TOKEN)){
            Accounts account = EntityMapper.mapToEntity(accountService.getOneByUsername(username), Accounts.class);
            Instant instant = Instant.ofEpochMilli(timeExpired);
            Tokens refreshTokens = Tokens.builder()
                    .token(token)
                    .tokenType(REFRESH_TOKEN)
                    .expiryTime(LocalDateTime.ofInstant(instant, ZoneId.systemDefault()))
                    .account(account)
                    .createdAt(LocalDateTime.now())
                    .build();
            refreshTokenService.save(refreshTokens);
        }
        return token;
    }

    public String extractUsername(String token){
        return extractClaim(token,Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims,T> claimsResolver){
        Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public Claims extractAllClaims(String token){
        return Jwts.parserBuilder().setSigningKey(getSignInKey())
                .build().parseClaimsJws(token).getBody();
    }

    public boolean isTokenValid(String token, UserDetails userDetails){
        String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) || !isTokenExpired(token);
    }



    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token,Claims::getExpiration);
    }

    public String getTokenFromHeader(HttpServletRequest request){
        String bearerToken = request.getHeader("Authorization");
        if(Strings.hasText(bearerToken) && bearerToken.startsWith("Bearer")){
            return bearerToken.substring(7);
        }
        return null;
    }
}
