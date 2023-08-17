package com.preproject_35.answer.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnswerResponseDto {

    private boolean success;
    private String message;
    private Long answerId;
    private String content;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime createdAt;

//    private String author;
//    private Long memberId;

    /*    private boolean success;
    private String message;
    private Long answerId;
    private String content;
    private LocalDateTime createdAt;
    private String author; // private Member author로 수정 필요
    private Long memberId; // private Member id로 하는게 수정 필요

*/
/*
    public AnswerResponseDto(boolean success, String message, Long answerId, String content, LocalDateTime createdAt, String author, Long memberId) {
        this.success = success;
        this.message = message;
        this.answerId = answerId;
        this.content = content;
        this.createdAt = createdAt;
        this.author = author; // this.author = answer.getMember().getUsername(); 수정 필요
        this.memberId = memberId; // this.author = answer.getMember().getMemberId(); 수정 필요
    }
 */
}
