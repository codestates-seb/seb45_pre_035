package com.preproject_35.element.member.Mapper;



import com.preproject_35.element.member.Dto.MemberPostDto;

import com.preproject_35.element.member.Dto.MemberResponseDto;
import com.preproject_35.element.member.Entity.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberPostDtoToMember(MemberPostDto memberPostDto);
    MemberResponseDto memberToMemberResponseDto(Member member);
}
