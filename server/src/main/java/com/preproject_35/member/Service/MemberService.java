package com.preproject_35.member.Service;

import com.preproject_35.member.BusinessLogicException;
import com.preproject_35.member.ExceptionCode;
import com.preproject_35.member.Member;
import com.preproject_35.member.Repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

  public Member createMember(Member member) {

      verifyExistsEamil(member.getEmail());
      return memberRepository.save(member);
  }

  public Member updateMember(Member member) {

      Member findMember = findVerifiedMember(member.getMemberId());

      Optional.ofNullable(member.getUsername())
              .ifPresent(username -> findMember.setUsername(username));
      Optional.ofNullable(member.getPassword())
              .ifPresent(password -> findMember.setPassword(password));

      return memberRepository.save(findMember);
  }
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

    public Optional<Member> findByEmail(String email) {
        return memberRepository.findByEmail(email);
    }
}
