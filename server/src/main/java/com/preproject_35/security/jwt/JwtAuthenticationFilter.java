package com.preproject_35.security.jwt;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
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
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String token = extractTokenFromRequest(request);

        if (token != null) {
            try {
                jwtValidator.validateToken(token);
                // 유효한 토큰인 경우, 토큰에서 추출한 인증 정보를 설정
                setAuthenticationFromToken(token);
            } catch (IllegalArgumentException ex) {
                // 유효하지 않은 토큰인 경우 예외 처리
                logger.warn("Invalid token: " + ex.getMessage());
                logger.debug("Invalid token details: ", ex);
            } catch (Exception ex) {
                // 기타 예외 처리
                logger.error("An error occurred while processing the token: " + ex.getMessage(), ex);
            }
        }
        // 다음 필터로 체인을 전달
        chain.doFilter(request, response);
    }


    private void setAuthenticationFromToken(String token) {
        Authentication authentication = jwtTokenizer.getAuthenticationFromToken(token);
        if (authentication != null) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
    }

    private String extractTokenFromRequest(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7); // "Bearer " 다음의 토큰 부분 추출
        }
        return null; // 토큰이 없는 경우 null 반환
    }
}
