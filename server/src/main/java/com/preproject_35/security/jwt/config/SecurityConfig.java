package com.preproject_35.security.jwt.config;

import com.preproject_35.security.jwt.JwtAuthenticationFilter;
import com.preproject_35.security.jwt.JwtTokenizer;
import com.preproject_35.security.jwt.JwtValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 모든 사용자의 권한이 동일하지만, 현재 클래스가 필요한 이유는 인증 과정을 통해 사용자를 식별하고
 * 사용자가 누구인지 확인하는 것이 중요하기 때문입니다. 인증 없이는 모든 사용자가 익명으로 여겨지고, 보안의 위협을 받을 수 있습니다.
 * 모든 사용자가 동일한 권한을 가져도, 로그인하지 않은 사용자의 액세스를 제한하는 것이 중요합니다.
 * 그 외에 CSRF방지, HTTP 보안 헤더로 웹 애플리케이션을 보호할 수 있습니다.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public static final String ROLE_USER = "ROLE_USER";
//    public static final String ROLE_ADMIN = "ROLE_ADMIN";

    public static final String PERMISSION_QUESTION_WRITE = "QUESTION_WRITE";
    public static final String PERMISSION_ANSWER_WRITE = "ANSWER_WRITE";
    public static final String PERMISSION_COMMENT_WRITE = "COMMENT_WRITE";

    @Autowired
    private JwtTokenizer jwtTokenizer;

    @Autowired
    private JwtValidator jwtValidator;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/questions").hasAuthority(PERMISSION_QUESTION_WRITE)
                .antMatchers("/answers").hasAuthority(PERMISSION_ANSWER_WRITE)
                .antMatchers("/comments").hasAuthority(PERMISSION_COMMENT_WRITE)
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/login").permitAll() // 로그인 요청은 허용
                .anyRequest().hasRole("USER") // 나머지 요청은 'USER' 역할이 필요
                .and()
                .addFilter(new JwtAuthenticationFilter(authenticationManager(), jwtTokenizer, jwtValidator)) // JwtAuthenticationFilter 추가
                .httpBasic().disable(); // HTTP Basic 인증 비활성화
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }
}