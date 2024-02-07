package com.app.crud.model.member;

import com.app.crud.model.address.Address;
import com.app.crud.model.book.Book;
import com.app.crud.model.memberBook.MemberBook;
import jakarta.persistence.*;


@Entity
@Table
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "memberId")
    private String memberId;
    private String name;
    private int age;

    public Member() {};
    public Member(String name) {
        this.name = name;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) { this.age = age; }

    public String getName() {
        return this.name;
    }

    public String getMemberId() {
        return this.memberId;
    }

    public int getAge() {
        return age;
    }
}
