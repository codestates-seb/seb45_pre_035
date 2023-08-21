package com.preproject_35.member.repository;


import com.preproject_35.member.entity.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface MemberRepository extends CrudRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
}