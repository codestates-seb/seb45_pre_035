package com.preproject_35;

import com.preproject_35.security.auth.jwt.JwtTokenizer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class JwtTokenizerTest2 {
    @Autowired
    private JwtTokenizer jwtTokenizer;

    @Value("${jwt.key}")
    private String secretKey;

    @Test
    public void testSecretKey() {
        String expectedSecretKey = "1234567890abcdefghijklmnopqrstuvwxyz"; // 여기에 예상되는 secretKey 값을 입력하세요
        assertEquals(expectedSecretKey, secretKey);

        String actualSecretKey = jwtTokenizer.getSecretKey();
        assertEquals(expectedSecretKey, actualSecretKey);

        System.out.println("Expected Secret Key: " + expectedSecretKey);
        System.out.println("Loaded Secret Key from @Value annotation: " + secretKey);
        System.out.println("Loaded Secret Key from JwtTokenizer bean: " + actualSecretKey);
    }
}
