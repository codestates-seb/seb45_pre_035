package com.preproject_35.element.member.Mapper;



import com.preproject_35.element.member.Dto.MemberPostDto;

import com.preproject_35.element.member.Dto.MemberResponseDto;
<<<<<<< HEAD
import com.preproject_35.element.member.entity.Member;
=======
import com.preproject_35.element.member.Entity.Member;
>>>>>>> 3fdc87512dda1d97a862a485d2cd42939ef48555
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberPostDtoToMember(MemberPostDto memberPostDto);
    MemberResponseDto memberToMemberResponseDto(Member member);
}
