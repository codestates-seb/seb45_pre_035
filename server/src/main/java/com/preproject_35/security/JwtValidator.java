// - 토큰 검증 기능 구현

package com.preproject_35.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class JwtValidator {
    private String base64EncodedSecretKey;

    public JwtValidator(String base64EncodedSecretKey) {
        this.base64EncodedSecretKey = base64EncodedSecretKey;
    }

    public Claims validateToken(String token) {
        try {
            // Base64로 인코딩된 시크릿 키로 Key 객체 생성
            byte[] keyBytes = Decoders.BASE64.decode(base64EncodedSecretKey);
            Key key = Keys.hmacShaKeyFor(keyBytes);

            // JWT 토큰 파싱 및 검증
            Jws<Claims> jws = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);

            return jws.getBody();
        } catch (JwtException ex) {
            // 유효하지 않은 토큰인 경우 예외 처리
            throw new IllegalArgumentException("Invalid token", ex);
        }
    }
}
