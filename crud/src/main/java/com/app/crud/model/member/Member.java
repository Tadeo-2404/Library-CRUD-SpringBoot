package com.app.crud.model.member;

import com.app.crud.model.address.Address;
import com.app.crud.model.book.Book;
import com.app.crud.model.memberBook.MemberBook;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "memberId", unique = true, nullable = false)
    private String memberId;
    @Column(name = "name", unique = false, nullable = false, length = 50)
    private String name;
    @Column(name = "lastname", unique = false, nullable = false, length = 50)
    private String lastname;
    @Column(name = "age", unique = false, nullable = true)
    private int age;

    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL)
    @JsonIgnore
    private Address address;

}
