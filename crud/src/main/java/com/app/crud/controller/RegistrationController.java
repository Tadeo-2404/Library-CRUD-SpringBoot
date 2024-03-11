package com.app.crud.controller;

import com.app.crud.model.member.Member;
import com.app.crud.model.member.Role;
import com.app.crud.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(path = "api/v1")
public class RegistrationController {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register/member")
    public Member createMember(@RequestBody Member member) {
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        // Create a set to store roles
        Set<Role> roles = new HashSet<>();
        for (Role role: member.getRoles()) {
            roles.add(role);
        }

        // Set the roles for the member
        member.setRoles(roles);

        return memberRepository.save(member);
    }
}
