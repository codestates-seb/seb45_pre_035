package com.preproject_35.element.member.Repository;


import com.preproject_35.element.member.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface MemberRepository extends CrudRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
}
