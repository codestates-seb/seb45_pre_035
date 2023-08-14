package com.preproject_35.member;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Member {

    private long memberID;
    private String email;
    private String username;
    private String password;
    private String join_date;

}
