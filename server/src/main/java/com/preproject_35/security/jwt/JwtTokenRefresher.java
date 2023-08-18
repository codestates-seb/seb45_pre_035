package com.preproject_35.security.jwt;

import io.jsonwebtoken.Claims;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTokenRefresher {
    private final JwtTokenizer jwtTokenizer;
    private final JwtValidator jwtValidator;
    private final String base64EncodedSecretKey;
    private final int accessTokenExpiration;
    private final int refreshTokenExpiration;

    public JwtTokenRefresher(JwtTokenizer jwtTokenizer, JwtValidator jwtValidator,
                             String base64EncodedSecretKey, int accessTokenExpiration, int refreshTokenExpiration) {
        this.jwtTokenizer = jwtTokenizer;
        this.jwtValidator = jwtValidator;
        this.base64EncodedSecretKey = base64EncodedSecretKey;
        this.accessTokenExpiration = accessTokenExpiration;
        this.refreshTokenExpiration = refreshTokenExpiration;
    }

    public Map<String, String> refreshToken(String refreshToken) {
        // 리프레시 토큰 검증
        Claims claims = jwtValidator.validateToken(refreshToken);

        // 액세스 토큰 재발행
        String subject = claims.getSubject();
        Date accessTokenExpirationDate = new Date(System.currentTimeMillis() + accessTokenExpiration * 1000);
        String newAccessToken = jwtTokenizer.generateAccessToken(new HashMap<>(), subject, accessTokenExpirationDate, base64EncodedSecretKey);

        // 리프레시 토큰 재발행
        Date refreshTokenExpirationDate = new Date(System.currentTimeMillis() + refreshTokenExpiration * 1000);
        String newRefreshToken = jwtTokenizer.generateRefreshToken(subject, refreshTokenExpirationDate, base64EncodedSecretKey);

        // 재발행된 토큰 반환
        Map<String, String> tokens = new HashMap<>();
        tokens.put("accessToken", newAccessToken);
        tokens.put("refreshToken", newRefreshToken);

        return tokens;
    }
}
