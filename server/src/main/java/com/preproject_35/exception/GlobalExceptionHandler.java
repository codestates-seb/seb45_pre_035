package com.preproject_35.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // JWT 검증에 실패한 경우의 예외 처리
    @ExceptionHandler(JwtValidationException.class)
    public ResponseEntity<String> handleJwtValidationException(JwtValidationException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    /**
     *UNAUTHORIZED (401): 이 상태 코드는 클라이언트가 권한이 없는 리소스에 액세스하려고 할 때 반환됩니다. 클라이언트는 리소스에 액세스하기 위한 적절한 인증 정보를 제공해야 합니다. 이는 일반적으로 사용자가 로그인하지 않았거나, 유효하지 않은 토큰을 사용하였을 때 발생합니다.
     */

    // 토큰 갱신에 실패한 경우의 예외 처리
    @ExceptionHandler(TokenRefreshException.class)
    public ResponseEntity<String> handleTokenRefreshException(TokenRefreshException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
    }

    /**
     *FORBIDDEN (403): 이 상태 코드는 클라이언트가 인증되었지만 요청한 리소스에 대한 권한이 없을 때 반환됩니다. 즉, 클라이언트의 자격 증명은 유효하지만, 해당 리소스에 액세스 할 수 있는 권한이 없습니다.
     */

    // 기타 모든 예외 처리
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

/**
 * INTERNAL_SERVER_ERROR (500): 이 상태 코드는 서버 내부에서 오류가 발생했을 때 반환됩니다. 이는 일반적으로 예상치 못한 서버 오류로 인해 요청을 처리할 수 없을 때 발생합니다.
 */

class JwtValidationException extends RuntimeException {
    public JwtValidationException(String message) {
        super(message);
    }
}

/**
 * 'JwtValidationException'과 'TokenRefreshException'은 사용자 정의 예외입니다.
 * 해당 예외 유형 발생 시 적절한 HTTP 상태 코드와 에러 메세지를 클라이언트에게 응답합니다.
 */

class TokenRefreshException extends RuntimeException {
    public TokenRefreshException(String message) {
        super(message);
    }
}
