package com.app.crud.model.member;
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
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Column(name = "lastname", nullable = false, length = 50)
    private String lastname;
    @Column(name = "age", nullable = true)
    private int age;
}
