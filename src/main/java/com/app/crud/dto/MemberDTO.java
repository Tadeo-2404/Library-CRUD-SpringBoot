package com.app.crud.dto;

import com.app.crud.model.member.Permission;
import com.app.crud.model.member.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
public class MemberDTO implements Serializable {
    final String memberId;
    final String email;
    final String username;
    final String password;
    final String name;
    final String lastname;
    final int age;
    final Set<Role> roles;
    final Set<Permission> permissions;
}
