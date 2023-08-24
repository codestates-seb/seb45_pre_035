package com.preproject_35.element.member.Service;


import com.preproject_35.element.error.BusinessLogicException;
import com.preproject_35.element.error.ExceptionCode;
import com.preproject_35.element.member.Repository.MemberRepository;
<<<<<<< HEAD
import com.preproject_35.element.member.entity.Member;
=======
import com.preproject_35.element.member.Entity.Member;

>>>>>>> 3fdc87512dda1d97a862a485d2cd42939ef48555
import com.preproject_35.security.utils.CustomAuthorityUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private MemberRepository memberRepository;


    private final PasswordEncoder passwordEncoder;
    private final CustomAuthorityUtils authorityUtils;

    // 생성자 DI용 파라미터 추가
    public MemberService(MemberRepository memberRepository,
                         PasswordEncoder passwordEncoder,
                         CustomAuthorityUtils authorityUtils) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorityUtils = authorityUtils;
    }

//    public MemberService(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    public Member createMember(Member member) {

        verifyExistsEamil(member.getEmail());

        // Password 암호화 (seongwon)
        String encryptedPassword = passwordEncoder.encode(member.getPassword());
        member.setPassword(encryptedPassword);

        // DB에 User Role 저장 (seongwon)
        List<String> roles = authorityUtils.createRoles(member.getEmail());
        member.setRoles(roles);

        return memberRepository.save(member);
    }

//    public Member updateMember(Member member) {
//
//        Member findMember = findVerifiedMember(member.getMemberId());
//
//        Optional.ofNullable(member.getUsername())
//                .ifPresent(username -> findMember.setUsername(username));
//        Optional.ofNullable(member.getPassword())
//                .ifPresent(password -> findMember.setPassword(password));
//
//        return memberRepository.save(findMember);
//    }
    public Member findMember(long memberId) {
        return findVerifiedMember(memberId);
    }

    public List<Member> findMembers() {
        return (List<Member>) memberRepository.findAll();
    }

    public Member findVerifiedMember(long memberId) {
        Optional<Member> optionalMember =
                memberRepository.findById(memberId);
        Member findMember =
                optionalMember.orElseThrow(() ->
                        new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
        return findMember;
    }

    private void verifyExistsEamil(String email) {
        Optional<Member> member = memberRepository.findByEmail(email);
        if (member.isPresent())
            throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);
    }

}