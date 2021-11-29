package com.diepvusinhtu1.ecommerce.security.jwt;

import com.diepvusinhtu1.ecommerce.security.model.*;
import io.jsonwebtoken.*;
import org.slf4j.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
public class JwtTokenProvider {
    private String JWT_SECRET = "ZTdhNzU5MDZjZjA2MWFjZGFhYjBiZmE4M2QxZTVmODgxZGVkZjI0N2FmMzQ0ODg3Zjc3ZDQ4MTUzOGFmNGNhNjMxOTg3YmNmNzlmYmEwNTBjYTN";

    private final long JWT_EXPIRATION = 604800000L;

    Logger log = LoggerFactory.getLogger(JwtTokenProvider.class);

    public String generateToken(CustomUserDetails userDetails) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);
        Claims claims = Jwts.claims().setSubject(userDetails.getUser().getUsername());

        return Jwts.builder().setClaims(claims).setIssuedAt(now).setExpiration(expiryDate).signWith(SignatureAlgorithm.HS512, JWT_SECRET).compact();
    }

    public String getUserNameFromJWT(String token) {
        Claims claims = Jwts.parser()
            .setSigningKey(JWT_SECRET)
            .parseClaimsJws(token)
            .getBody();

        return claims.getSubject();
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
        }
        return false;
    }
}
