package com.preproject_35.element.member.entity;

import com.preproject_35.element.answer.entity.Answer;
import com.preproject_35.element.comment.answerComment.entitiy.AnswerComment;
import com.preproject_35.element.comment.questionComment.question.entity.QuestionComment;
import com.preproject_35.element.question.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long memberId;

    @Column(nullable = false, unique = true)
    private String email;
    public Member(String email){
        this.email = email;
    }

    @Column(name = "USERNAME")
    private String username;

    @Column(nullable = false, length = 20 )
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Answer> answer = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Question> questions = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<AnswerComment> answerComments = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<QuestionComment> questionComments = new ArrayList<>();
}