package com.app.crud.model.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {
    List<Member> getByName(String name);
    List<Member> getByLastname(String lastname);
    List<Member> getByAge(int age);
}
