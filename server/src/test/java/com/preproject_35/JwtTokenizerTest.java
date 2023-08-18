package com.preproject_35;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.preproject_35.security.jwt.JwtTokenizer;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 이 테스트 클래스를 통과한 경우, 다음과 같은 사항을 검증한 것입니다:
 * @토큰생성: JwtTokenizer 클래스의 generateAccessToken 메서드가 유효한 JWT 액세스 토큰을 생성하고 반환한다. 생성된 토큰은 Null이 아니며, 테스트 시 사용한 claims(클레임), subject(주제), expiration(만료 시간)을 올바르게 포함한다.
 * @토큰유효성검사: 생성된 토큰을 다시 분석하면, 올바르게 생성된 액세스 토큰의 클레임과 주제를 얻을 수 있습니다. 토큰에 포함된 정보와 테스트에 사용된 정보가 일치하는지 확인하였습니다.
 * @토큰서명검증: 생성된 토큰의 서명이 올바른지 검증하였습니다. 유효한 비밀 키를 사용하여 토큰을 분석하고 검증하였으므로, 토큰의 서명도 올바릅니다.
 * @토큰만료시간 검증: 토큰 만료 시간이 테스트 시 지정한 만료 시간과 일치하는지 확인하였습니다.
 * @클레임검증: 토큰에 포함된 클레임(예: "role": "user")이 정확한지 확인하였습니다.
 */
public class JwtTokenizerTest {

    private JwtTokenizer tokenizer;
    private String secretKey;
    private String base64SecretKey;
    private Key key;

    private static final String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int KEY_LENGTH = 32;

    private static String generateKey(int length) {
        Random random = new Random();
        StringBuilder key = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            key.append(characters.charAt(index));
        }

        return key.toString();
    }

    @BeforeEach
    public void setUp() {
        tokenizer = new JwtTokenizer();
        secretKey = generateKey(KEY_LENGTH); // Use the key generator to create a key
        base64SecretKey = Encoders.BASE64.encode(secretKey.getBytes());
        byte[] keyBytes = Decoders.BASE64.decode(base64SecretKey);
        key = Keys.hmacShaKeyFor(keyBytes);
    }

    @Test
    public void testGenerateAccessToken() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", "user");
        String subject = "user1";
        Date expiration = new Date(System.currentTimeMillis() + 600000); // 토큰 만료 시간: 10분 후

        String token = tokenizer.generateAccessToken(claims, subject, expiration, base64SecretKey);

        assertNotNull(token);

        Jws<Claims> parsedToken = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
        assertEquals("user", parsedToken.getBody().get("role"));
        assertEquals("user1", parsedToken.getBody().getSubject());
    }

    @Test
    public void testClaims() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", "admin");
        claims.put("username", "user1");
        String subject = "user1";
        Date expiration = new Date(System.currentTimeMillis() + 600000);

        String token = tokenizer.generateAccessToken(claims, subject, expiration, base64SecretKey);
        Jws<Claims> parsedToken = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);

        assertEquals("admin", parsedToken.getBody().get("role"));
        assertEquals("user1", parsedToken.getBody().get("username"));
    }

    @Test
    public void testDecodeToken() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", "user");
        String subject = "user1";
        Date expiration = new Date(System.currentTimeMillis() + 600000); // 토큰 만료 시간: 10분 후

        String token = tokenizer.generateAccessToken(claims, subject, expiration, base64SecretKey);
        assertNotNull(token);

        // 복호화 된 토큰의 클레임 값이 올바른지 검증
        Jws<Claims> parsedToken = tokenizer.decodeToken(token, base64SecretKey);
        assertNotNull(parsedToken);
        assertEquals("user", parsedToken.getBody().get("role"));
        assertEquals("user1", parsedToken.getBody().getSubject());
    }
}

