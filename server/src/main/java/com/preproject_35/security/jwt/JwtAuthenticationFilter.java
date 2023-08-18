package com.preproject_35.security.jwt;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final JwtTokenizer jwtTokenizer;
    private final JwtValidator jwtValidator;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, JwtTokenizer jwtTokenizer, JwtValidator jwtValidator) {
        super(authenticationManager);
        this.jwtTokenizer = jwtTokenizer;
        this.jwtValidator = jwtValidator;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String token = extractTokenFromRequest(request);

        if (token != null) {
            try {
                jwtValidator.validateToken(token);
                // 유효한 토큰인 경우, 토큰에서 추출한 인증 정보를 설정
                setAuthenticationFromToken(token);
            } catch (IllegalArgumentException ex) {
                // 유효하지 않은 토큰인 경우 예외 처리
                logger.warn("Invalid token: " + ex.getMessage());
            }
        }

        chain.doFilter(request, response);
    }

    private void setAuthenticationFromToken(String token) {
        Authentication authentication = jwtTokenizer.getAuthenticationFromToken(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private String extractTokenFromRequest(HttpServletRequest request) {
        // 토큰 추출 로직은 이전과 동일하게 구현
    }
}
