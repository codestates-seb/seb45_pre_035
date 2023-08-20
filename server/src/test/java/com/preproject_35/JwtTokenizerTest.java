package com.preproject_35;

import io.jsonwebtoken.ExpiredJwtException;
import com.preproject_35.security.auth.jwt.JwtTokenizer;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.concurrent.TimeUnit;

import java.security.Key;
import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class JwtTokenizerTest {
    private static JwtTokenizer jwtTokenizer;
    private String secretKey;
    private String base64EncodedSecretKey;

    // 테스트에 사용할 Secret Key를 Base64 형식으로 인코딩한 후, 인코딩 된 Secret Key를 각 테스트 케이스에서 사용
    @BeforeAll
    public void init() {
        jwtTokenizer = new JwtTokenizer();
        secretKey = "kevin1234123412341234123412341234";  // encoded "a2V2aW4xMjM0MTIzNDEyMzQxMjM0MTIzNDEyMzQxMjM0"

        base64EncodedSecretKey = jwtTokenizer.encodeBase64SecretKey(secretKey);
    }

    // Plain Text인 Secret Key가 Base64 형식으로 인코딩이 정상적으로 수행이 되는지 테스트
    @Test
    public void encodeBase64SecretKeyTest() {
        System.out.println(base64EncodedSecretKey);
        // Base64 형식으로 인코딩 된 Secret Key를 디코딩한 값이 원본 Plain Text Secret Key가 일치하는지
        assertThat(secretKey, is(new String(Decoders.BASE64.decode(base64EncodedSecretKey))));
    }

    // JwtTokenizer가 Access Token을 정상적으로 생성하는지 테스트
    @Test
    public void generateAccessTokenTest() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("memberId", 1);
        claims.put("roles", List.of("USER"));

        String subject = "test access token";
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, 10);
        Date expiration = calendar.getTime();

        String accessToken = jwtTokenizer.generateAccessToken(claims, subject, expiration, base64EncodedSecretKey);

        System.out.println(accessToken);
        // 생성된 Access Token이 null이 아닌지 여부만 테스트
        assertThat(accessToken, notNullValue());
    }

    // JwtTokenizer가 Refresh Token을 정상적으로 생성하는지 테스트
    // Access Token과 테스트 과정은 동일
    @Test
    public void generateRefreshTokenTest() {
        String subject = "test refresh token";
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, 24);
        Date expiration = calendar.getTime();

        String refreshToken = jwtTokenizer.generateRefreshToken(subject, expiration, base64EncodedSecretKey);

        System.out.println(refreshToken);

        assertThat(refreshToken, notNullValue());
    }

    // JwtTokenizer의 verifySignature() 메서드가 Signature를 잘 검증하는지 테스트
    @DisplayName("does not throw any Exception when jws verify")
    @Test
    public void verifySignatureTest() {
        String accessToken = getAccessToken(Calendar.MINUTE, 10);
        assertDoesNotThrow(() -> jwtTokenizer.verifySignature(accessToken, base64EncodedSecretKey));
    }

    // JWT 생성 시 지정한 만료일시가 지나면 JWT가 정말 만료되는지를 테스트
    @DisplayName("throw ExpiredJwtException when jws verify")
    @Test
    public void verifyExpirationTest() throws InterruptedException {
        String accessToken = getAccessToken(Calendar.SECOND, 1);
        assertDoesNotThrow(() -> jwtTokenizer.verifySignature(accessToken, base64EncodedSecretKey));

        TimeUnit.MILLISECONDS.sleep(1500);

        assertThrows(ExpiredJwtException.class, () -> jwtTokenizer.verifySignature(accessToken, base64EncodedSecretKey));
    }

    private String getAccessToken(int timeUnit, int timeAmount) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("memberId", 1);
        claims.put("roles", List.of("USER"));

        String subject = "test access token";
        Calendar calendar = Calendar.getInstance();
        calendar.add(timeUnit, timeAmount);
        Date expiration = calendar.getTime();
        String accessToken = jwtTokenizer.generateAccessToken(claims, subject, expiration, base64EncodedSecretKey);

        return accessToken;
    }
}

