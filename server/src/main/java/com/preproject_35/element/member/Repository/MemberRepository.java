package com.preproject_35.element.member.Repository;


<<<<<<< HEAD
import com.preproject_35.element.member.entity.Member;
=======

import com.preproject_35.element.member.Entity.Member;
>>>>>>> 3fdc87512dda1d97a862a485d2cd42939ef48555
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface MemberRepository extends CrudRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
}
