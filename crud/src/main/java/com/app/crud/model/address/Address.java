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

    public String getAddress_id() {
        return this.address_id;
    }

    public String getStreet() {
        return this.street;
    }

    public String getCity() {
        return this.city;
    }

    public String getState() {
        return this.state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setAddress_id(String address_id) {
        this.address_id = address_id;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}

