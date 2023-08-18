package com.preproject_35.member.Repository;


import com.preproject_35.member.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface MemberRepository extends CrudRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
}
