package com.app.crud.controller;

import com.app.crud.dto.AddressDTO;
import com.app.crud.dto.MemberDTO;
import com.app.crud.dto.mapper.AddressDTOMapper;
import com.app.crud.dto.mapper.MemberDTOMapper;
import com.app.crud.dto.request.member.MemberRequest;
import com.app.crud.model.address.Address;
import com.app.crud.model.book.Book;
import com.app.crud.model.member.Member;
import com.app.crud.model.member.Role;
import com.app.crud.repository.MemberRepository;
import com.app.crud.service.BookService;
import com.app.crud.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "api/v1/members")
public class MemberController {
    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;
    private final MemberDTOMapper memberDTOMapper;
    private final AddressDTOMapper addressDTOMapper;
    private final MemberRepository memberRepository;

    @Autowired
    public MemberController(MemberService memberService,
                            PasswordEncoder passwordEncoder,
                            MemberDTOMapper memberDTOMapper,
                            AddressDTOMapper addressDTOMapper,
                            MemberRepository memberRepository) {
        this.memberService = memberService;
        this.passwordEncoder = passwordEncoder;
        this.memberDTOMapper = memberDTOMapper;
        this.addressDTOMapper = addressDTOMapper;
        this.memberRepository = memberRepository;
    }

    @GetMapping
    public ResponseEntity<Object> getMembers(@RequestParam Map<String,String> allParams) {
        String ID = allParams.get("ID");
        String email = allParams.get("email");
        String name = allParams.get("name");
        String ageStr = allParams.get("age");
        Integer age = null;
        if (ageStr != null) {
            age = Integer.parseInt(ageStr);
        }
        String lastname = allParams.get("lastname");

        if(allParams.size() > 1) {
            if(name != null && lastname != null) {
                return memberService.getMemberByNameAndLastname(name, lastname);
            } else if(name != null && age != null) {
                return memberService.getMemberByNameAndAge(name, age);
            } else if(lastname != null && age != null) {
                return memberService.getMemberByLastnameAndAge(lastname, age);
            } else if(name != null && lastname != null && age != null) {
                return memberService.getMemberByNameAndLastnameAndAge(name, lastname, age);
            }
        }

        if (ID != null) {
            return memberService.getMemberByID(ID);
        } else if(email != null) {
            return memberService.getMemberByEmail(email);
        } else if (name != null) {
            return memberService.getMemberByName(name);
        } else if (lastname != null) {
            return memberService.getMemberByLastname(lastname);
        } else {
            return memberService.getMembers();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Object> registerMember(@RequestBody MemberRequest request) {
        Member member = request.getMember();
        Address address = request.getAddress();
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        // Create a set to store roles
        Set<Role> roles = new HashSet<>();
        for (Role role: member.getRoles()) {
            roles.add(role);
        }
        // Set the roles for the member
        member.setRoles(roles);
        return memberService.addMember(memberDTOMapper.mapToMemberDTO(member));
    }

    @PutMapping
    public ResponseEntity<Object> editMember(@RequestBody MemberRequest request) {
        Member member = request.getMember();
        Address address = request.getAddress();
        return this.memberService.editMember(memberDTOMapper.mapToMemberDTO(member), addressDTOMapper.mapToAddressDTO(address));
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteMember(@RequestParam String memberId) {
        return this.memberService.deleteMember(memberId);
    }
}
