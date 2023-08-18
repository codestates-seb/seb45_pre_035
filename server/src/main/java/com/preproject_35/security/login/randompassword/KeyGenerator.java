package com.preproject_35.security.login.randompassword;

import java.util.Random;

// 32바이트 용량의 토큰 비밀번호를 무작위로 생성해주는 생성기입니다.
public class KeyGenerator {
    private static final String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static String generateKey(int length) {
        Random random = new Random();
        StringBuilder key = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            key.append(characters.charAt(index));
        }

        return key.toString();
    }
}
