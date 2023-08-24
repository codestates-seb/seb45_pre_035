<<<<<<< HEAD
package com.preproject_35.answerComment.dto;
=======
package com.preproject_35.element.comment.answerComment.dto;
>>>>>>> 3fdc87512dda1d97a862a485d2cd42939ef48555

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class AnswerCommentPatchDto {
    private long AnswerCommentId;
<<<<<<< HEAD

=======
>>>>>>> 3fdc87512dda1d97a862a485d2cd42939ef48555
    @Email
    private String email;
    @NotBlank
    private String content;
}
