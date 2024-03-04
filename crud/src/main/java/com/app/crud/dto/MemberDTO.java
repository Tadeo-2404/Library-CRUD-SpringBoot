package com.app.crud.dto;

import com.app.crud.model.member.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Setter
@Getter
public class MemberDTO implements Serializable {
    final String memberId;
    final String username;
    final String password;
    final String name;
    final String lastname;
    final int age;
    final Role role;
}
