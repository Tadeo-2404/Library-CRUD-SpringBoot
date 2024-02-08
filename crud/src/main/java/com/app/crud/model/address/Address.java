package com.app.crud.model.address;

import com.app.crud.model.member.Member;
import com.app.crud.model.memberBook.MemberBook;
import jakarta.persistence.*;

@Entity
@Table
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "address_id")
    private String address_id;
    private String street;
    private String city;
    private String state;
    private String postalCode;

    @OneToOne
    @JoinColumn(name = "member_id", referencedColumnName = "memberId")
    private Member member;

    public Member getMember() {
        return member;
    }
}

