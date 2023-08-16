package com.preproject_35.member;

public class MemberDTO {

    private String memberid;
    private String email;
    private String username;
    private String password;
    private String join_date;

    public MemberDTO() {
    }

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJoin_date() {
        return join_date;
    }

    public void setJoin_date(String join_date) {
        this.join_date = join_date;
    }

    @Override
    public String toString() {
        return "MemberDTO [memberid=" + memberid + ", username=" + username +", password=" + password + ", join_date=" + join_date +"]";
    }
}
