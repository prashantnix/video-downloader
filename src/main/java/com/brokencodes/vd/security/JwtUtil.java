package com.brokencodes.vd.security;

import com.brokencodes.vd.services.api.ITimeOutParser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

@Component
public class JwtUtil implements IJwtUtil {

    @Value("${vd.time-outs.jwt}")
    private String jwtExpirationTime;

    @Value("${vd.security.jwt-token-key}")
    private String secret;

    @Autowired
    private ITimeOutParser timeOutParser;

    @Override
    public String generateToken(String email) {
        ITimeOutParser.TimeOut timeOutInstance = timeOutParser.getTimeOut(jwtExpirationTime);
        return Jwts.builder()
                .setClaims(new HashMap<String, Object>())
                .setSubject(email)
                .setIssuedAt(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
                .setExpiration(Date.from(LocalDateTime.now().plus(timeOutInstance.getTimeOut(), timeOutInstance.getUnit()).atZone(ZoneId.systemDefault()).toInstant()))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    @Override
    public boolean validateToken(String token, String email) {
        String subject = extractSubject(token);
        return email != null
                && email.equalsIgnoreCase(subject)
                && !hasTokenExpired(token);
    }

    @Override
    public String extractSubject(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private boolean hasTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

}
