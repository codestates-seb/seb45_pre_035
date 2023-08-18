package com.preproject_35.security.login.handler;

import com.preproject_35.security.jwt.JwtProperties;
import com.preproject_35.security.jwt.JwtTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private final JwtTokenizer jwtTokenizer;
    private final String base64EncodedSecretKey;
    private final JwtProperties jwtProperties;

//    @Value("${jwt.secret-key}")
//    private String secretKey;

    public JwtAuthenticationSuccessHandler(JwtTokenizer jwtTokenizer, JwtProperties jwtProperties) {
        this.jwtTokenizer = jwtTokenizer;
        this.base64EncodedSecretKey = jwtTokenizer.encodeBase64SecretKey();
        this.jwtProperties = jwtProperties;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String username = authentication.getName();
        Map<String, Object> claims = new HashMap<>();

        long expirationInSeconds = jwtProperties.getExpiration();
        Date expirationDate = new Date(System.currentTimeMillis() + expirationInSeconds * 1000); // 토큰 유효 기간 -> expirationInSeconds 초

        String token = jwtTokenizer.generateAccessToken(claims, username, expirationDate, base64EncodedSecretKey);

        response.addHeader("Authorization", "Bearer " + token);
        response.getWriter().write("{\"token\":\"Bearer " + token + "\"}");
    }


}