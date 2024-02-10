package com.app.crud.model.address;

import com.app.crud.model.member.Member;
import com.app.crud.model.memberBook.MemberBook;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "address_id", unique = true, nullable = false)
    private String address_id;
    @Column(name = "street", unique = false, nullable = false, length = 50)
    private String street;
    @Column(name = "city", unique = false, nullable = false, length = 50)
    private String city;
    @Column(name = "state", unique = false, nullable = false, length = 50)
    private String state;
    @Column(name = "postalCode", unique = false, nullable = false, length = 50)
    private String postalCode;

    @OneToOne
    @JoinColumn(
            name = "member_id"
    )
    private Member member;

    public Address(Member member, String street, String city, String state, String postalCode) {
        this.member = member;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }
}

