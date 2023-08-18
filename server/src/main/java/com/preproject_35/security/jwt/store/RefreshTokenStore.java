package com.preproject_35.security.jwt.store;


import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

// ------------------------------------------------------------------------------------------------------
// - 토큰 취소 및 무효화는 주로 서버 측에서 리프레시 토큰을 관리하는 방식으로 이루어진다.
// - 서버에서 유효한 리프레시 토큰 목록을 저장 -> 사용자 로그아웃 or 토큰 취소 요청 시 목록에서 제거
// - 토큰 갱신 요청 시 서버에서 유효한 리프레시 토큰 목록을 확인해 요청한 리프레시 토큰이 목록에 있는지 검사 후, 없으면 거부
// - 아래 코드는 리프레시 토큰을 저장하고, 유효성을 검사하는 기능을 가진 클래스를 구현했습니다.
// - addRefreshToken 메서드 -> 리프레시 토큰 저장
// - removeRefreshToken 메서드 -> 리프레시 토큰 목록에서 제거
// - isValidRefreshToken 메서드 -> 리프레시 토큰 유효성 검사
// ------------------------------------------------------------------------------------------------------

@Component
public class RefreshTokenStore {

    private final Set<String> refreshTokenStore = new HashSet<>();

    public void addRefreshToken(String refreshToken) {
        refreshTokenStore.add(refreshToken);
    }

    public void removeRefreshToken(String refreshToken) {
        refreshTokenStore.remove(refreshToken);
    }

    public boolean isValidRefreshToken(String refreshToken) {
        return refreshTokenStore.contains(refreshToken);
    }
}

