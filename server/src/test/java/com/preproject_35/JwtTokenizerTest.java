package com.preproject_35;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.preproject_35.security.JwtTokenizer;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTokenizerTest {

    private JwtTokenizer tokenizer;
    private String secretKey = "YourSecretKeyHere";
    private String base64SecretKey;

    // @BeforeEach -> 각 테스트 메서드 실행 전 자동으로 호출
    // 이 메서드에서는 JwtTokenizer 객체를 초기화하고, 시크릿 키를 Base64로 인코딩하여 준비
    @BeforeEach
    public void setUp() {
        tokenizer = new JwtTokenizer();
        base64SecretKey = tokenizer.encodeBase64SecretKey();
    }

    // generateAccessToken() 메서드 테스트
    @Test
    public void testGenerateAccessToken() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", "user");
        String subject = "user1";
        Date expiration = new Date(System.currentTimeMillis() + 600000); // 토큰 만료 시간: 10분 후

        String token = tokenizer.generateAccessToken(claims, subject, expiration, base64SecretKey);

        assertNotNull(token);

        Jws<Claims> parsedToken = Jwts.parserBuilder().setSigningKey(base64SecretKey).build().parseClaimsJws(token);
        // assertEquals(기대하는 값, 실제 값) 두 값이 다르면 테스트는 실패한다.
        assertEquals("user", parsedToken.getBody().get("role"));
        assertEquals("user1", parsedToken.getBody().getSubject());
    }
}

