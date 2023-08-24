<<<<<<< HEAD
package com.preproject_35.answerComment.dto;
=======
package com.preproject_35.element.comment.answerComment.dto;
>>>>>>> 3fdc87512dda1d97a862a485d2cd42939ef48555

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AnswerCommentResponseDto {
    private boolean success;
    private String message;
    private long answerCommentId;
    private String content;
    private LocalDateTime createAt;
    private String author;
    private long memberId;
}
