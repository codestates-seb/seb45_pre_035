package com.preproject_35.member.Mapper;

import com.preproject_35.member.Dto.MemberPostDto;
import com.preproject_35.member.Dto.MemberResponseDto;
import com.preproject_35.member.Member;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-18T13:28:05+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.20 (Azul Systems, Inc.)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public Member memberPostDtoToMember(MemberPostDto memberPostDto) {
        if ( memberPostDto == null ) {
            return null;
        }

        Member member = new Member();

        member.setEmail( memberPostDto.getEmail() );
        member.setUsername( memberPostDto.getUsername() );
        member.setPassword( memberPostDto.getPassword() );

        return member;
    }

    @Override
    public MemberResponseDto memberToMemberResponseDto(Member member) {
        if ( member == null ) {
            return null;
        }

        long memberId = 0L;
        String email = null;
        String username = null;
        String password = null;

        memberId = member.getMemberId();
        email = member.getEmail();
        username = member.getUsername();
        password = member.getPassword();

        MemberResponseDto memberResponseDto = new MemberResponseDto( memberId, email, username, password );

        return memberResponseDto;
    }
}
