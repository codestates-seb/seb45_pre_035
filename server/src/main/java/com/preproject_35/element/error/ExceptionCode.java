package com.preproject_35.element.error;

import lombok.Getter;

public enum ExceptionCode {
    MEMBER_NOT_FOUND(false,404, "Member Not Found"),
    MEMBER_EXISTS(false,200,"OK"),
    QUESTION_NOT_FOUND(false,404, "Question Not Found"),
<<<<<<< HEAD
    COMMENT_NOT_FOUND(false, 404, "Comment Not Found");
=======
    COMMENT_NOT_FOUND(false, 404, "Comment Not Found"),
    ANSWER_NOT_FOUND(false, 404, "Answer Not Found"),
    NOT_AUTHORIZED(false, 401, "UnAuthorized");


>>>>>>> 3fdc87512dda1d97a862a485d2cd42939ef48555

    @Getter
    private boolean success;
    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(boolean success, int status, String message) {
        this.success = success;
        this.status = status;
        this.message = message;
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 3fdc87512dda1d97a862a485d2cd42939ef48555
