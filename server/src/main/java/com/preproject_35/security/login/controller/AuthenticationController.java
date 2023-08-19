package com.preproject_35.security.login.controller;

import com.preproject_35.security.jwt.JwtProperties;
import com.preproject_35.security.jwt.JwtTokenizer;
import com.preproject_35.security.login.AuthenticationRequest;
import com.preproject_35.security.login.AuthenticationResponse;
import com.preproject_35.security.login.handler.JwtAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private JwtTokenizer jwtTokenizer; // 생성 관련

    @Autowired
    private JwtProperties jwtProperties; // 설정 정보

    // 로그인 정보가 유효한 경우에는 JWT 토큰을 생성하여 응답에 포함시킵니다. 그렇지 않은 경우에는 에러 메시지를 반환합니다.
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest authenticationRequest, HttpServletRequest request, HttpServletResponse response) {
        try {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword());
            Authentication authentication = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // 로그인 성공 시 토큰 발급
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            Map<String, Object> claims = new HashMap<>();
            claims.put("roles", userDetails.getAuthorities()); // 사용자 역할 정보를 클레임에 추가

            long expirationInSeconds = jwtProperties.getExpiration();
            Date expirationDate = new Date(System.currentTimeMillis() + expirationInSeconds * 1000); // 토큰 유효 기간 -> expirationInSeconds 초

            String base64EncodedSecretKey = jwtTokenizer.encodeBase64SecretKey();
            String generatedToken = jwtTokenizer.generateAccessToken(claims, userDetails.getUsername(), expirationDate, base64EncodedSecretKey);

            // 생성된 토큰을 응답에 추가
            response.setHeader("Authorization", "Bearer " + generatedToken);

            // AuthenticationResponse 객체 생성 후 반환
            AuthenticationResponse authResponse = new AuthenticationResponse(true, "Login success", generatedToken);
            return new ResponseEntity<>(authResponse, HttpStatus.OK);
        } catch (AuthenticationException e) {
            // 인증 실패 시 에러 응답 반환
            AuthenticationResponse authResponse = new AuthenticationResponse(false, "Login failed", null);
            return new ResponseEntity<>(authResponse, HttpStatus.UNAUTHORIZED);
        }
    }
}