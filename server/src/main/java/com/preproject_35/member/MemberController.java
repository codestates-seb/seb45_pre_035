package com.preproject_35.member;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@RequestMapping("/v1/members")
public class MemberController {
    @PostMapping
    public ResponseEntity postMember(@Valid MemberDTO memberDto) {
        return new ResponseEntity<>(memberDto, HttpStatus.CREATED);
    }

}