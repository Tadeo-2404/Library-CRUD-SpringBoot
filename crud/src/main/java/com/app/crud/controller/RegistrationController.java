package com.app.crud.controller;

import com.app.crud.dto.MemberDTO;
import com.app.crud.model.member.Member;
import com.app.crud.model.member.Role;
import com.app.crud.repository.MemberRepository;
import com.app.crud.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    private MemberService memberService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register/member")
    public ResponseEntity<Object> createMember(@RequestBody Member member) {
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        // Create a set to store roles
        Set<Role> roles = new HashSet<>();
        for (Role role: member.getRoles()) {
            roles.add(role);
        }

        // Set the roles for the member
        member.setRoles(roles);
        //create dto object
        MemberDTO memberDTO = new MemberDTO(
                member.getMemberId(),
                member.getEmail(),
                member.getPassword(),
                member.getUsername(),
                member.getName(),
                member.getLastname(),
                member.getAge(),
                member.getRoles()
        );

        return memberService.addMember(memberDTO);
    }
}
