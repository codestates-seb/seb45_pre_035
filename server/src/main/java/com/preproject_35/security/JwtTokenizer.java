package com.preproject_35.security;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

// ----------------------
// - 시크릿 키 생성 및 관리
// - 토큰 발행 기능 구현
// ----------------------

public class JwtTokenizer {
    // 새로운 시크릿 키를 생성하고 이를 Base64로 인코딩
    public String encodeBase64SecretKey() {
        // Create a strong secret key for HMAC-SHA256
        SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        return Encoders.BASE64.encode(secretKey.getEncoded());
    }

    /** 액세스 토큰을 생성
    * @claims: 토큰에 추가할 클레임(정보)을 포함한 맵
    * @subject: 토큰의 주제로 일반적으로 사용자 아이디나 이메일 주소
    * @expiration: 토큰의 만료 시간
    * @base64EncodedSecretKey: Base64로 인코딩된 시크릿 키 문자열
    */
    public String generateAccessToken(Map<String, Object> claims,
                                      String subject,
                                      Date expiration,
                                      String base64EncodedSecretKey) {
        // Base64로 인코딩된 시크릿 키로 Key 객체를 생성
        Key key = getKeyFromBase64EncodedKey(base64EncodedSecretKey);

        // JWT 토큰을 생성
        return Jwts.builder()
                .setClaims(claims) // 클레임 설정
                .setSubject(subject) // 주제 설정
                .setIssuedAt(Calendar.getInstance().getTime()) // 토큰 발급 시간
                .setExpiration(expiration) // 토큰 만료 시간
                .signWith(key) // 시크릿 키 서명
                .compact(); // JWT토큰 문자열 반환
    }

    // 리프레시 토큰을 생성
    public String generateRefreshToken(String subject, Date expiration, String base64EncodedSecretKey) {
        Key key = getKeyFromBase64EncodedKey(base64EncodedSecretKey);

        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(Calendar.getInstance().getTime())
                .setExpiration(expiration)
                .signWith(key)
                .compact();
    }



    // Base64로 인코딩된 시크릿 키 문자열로부터 Key 객체를 생성
    private Key getKeyFromBase64EncodedKey(String base64EncodedSecretKey) {
        byte[] keyBytes = Decoders.BASE64.decode(base64EncodedSecretKey); // Base64 디코딩 수행
        Key key = Keys.hmacShaKeyFor(keyBytes); // 디코딩된 바이트 배열로 HMAC-SHA 키를 생성

        return key;
    }
}
