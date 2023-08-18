package com.preproject_35.security;

import org.springframework.context.annotation.Bean;
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
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 'user'와 'anotherUser'가 있는 이유: 시나리오 테스트를 위해서
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password(passwordEncoder().encode("password")).roles("USER")
                .and()
                .withUser("anotherUser").password(passwordEncoder().encode("anotherPassword")).roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .anyRequest().hasRole("USER")
                .and()
                .httpBasic();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}