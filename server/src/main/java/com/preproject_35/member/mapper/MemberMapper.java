package com.preproject_35.member.mapper;



import com.preproject_35.member.dto.MemberPostDto;
import com.preproject_35.member.dto.MemberResponseDto;
import com.preproject_35.member.entity.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberPostDtoToMember(MemberPostDto memberPostDto);
    MemberResponseDto memberToMemberResponseDto(Member member);
}
