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
    private String lastname;
    private int age;

    @OneToOne(mappedBy = "member")
    private Address address;

    public Member() {};
    public Member(String name, String lastname, int age) {
        this.name = name;
        this.age = age;
        this.lastname = lastname;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAge(int age) { this.age = age; }

    public String getName() {
        return this.name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getMemberId() {
        return this.memberId;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
