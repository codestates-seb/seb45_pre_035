package com.preproject_35.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member {

    @Id
    @GeneratedValue
    private long memberId;

    private String email;
    public Member(String email){
        this.email = email;
    }

    private String username;
    private String password;

}

