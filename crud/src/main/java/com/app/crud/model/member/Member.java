package com.app.crud.model.member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

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
    @Column(name = "email", nullable = false, length = 250)
    private String email;
    @Column(name = "username", nullable = false, length = 250)
    private String username;
    @Column(name = "password", nullable = false, length = 250)
    private String password;
    @Column(name = "name", nullable = false, length = 250)
    private String name;
    @Column(name = "lastname", nullable = false, length = 250)
    private String lastname;
    @Column(name = "age", nullable = true)
    private int age;

    @ManyToMany(
            fetch = FetchType.EAGER,
            targetEntity = Role.class,
            cascade = CascadeType.PERSIST
    )
    @JoinTable(
            name = "member_roles",
            joinColumns = @JoinColumn(name = "member_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "role_id", nullable = false)

    )
    private Set<Role> roles = new HashSet<>();
}
