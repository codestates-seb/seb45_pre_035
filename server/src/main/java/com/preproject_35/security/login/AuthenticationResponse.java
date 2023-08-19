package com.preproject_35.security.login;


public class AuthenticationResponse {
    private boolean success;
    private String message;
    private String token;

    public AuthenticationResponse(boolean success, String message, String token) {
        this.success = success;
        this.message = message;
        this.token = token;
    }
}
