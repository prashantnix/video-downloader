package com.brokencodes.vd.security;

public interface IJwtUtil {

    String generateToken(String email);

    boolean validateToken(String token, String email);

    String extractSubject(String token);

}
