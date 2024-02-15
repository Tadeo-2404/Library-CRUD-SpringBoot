package com.app.crud.repository;

import com.app.crud.model.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {
    @Override
    Member getById(String ID);
    List<Member> getByName(String name);
    List<Member> getByLastname(String lastname);
    List<Member> getByAge(int age);

    List<Member> getByNameAndLastname(String name, String lastname);
    List<Member> getByNameAndAge(String name, int age);
    List<Member> getByLastnameAndAge(String lastname, int age);
    List<Member> getByNameAndLastnameAndAge(String name, String lastname, int age);

}
