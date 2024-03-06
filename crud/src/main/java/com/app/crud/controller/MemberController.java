package com.app.crud.controller;

import com.app.crud.dto.AddressDTO;
import com.app.crud.dto.MemberDTO;
import com.app.crud.model.address.Address;
import com.app.crud.model.book.Book;
import com.app.crud.model.member.Member;
import com.app.crud.service.BookService;
import com.app.crud.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/members")
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
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

    public static class MemberRegistrationRequest {
        private MemberDTO member;
        private AddressDTO address;
        public MemberDTO getMember() {
            return member;
        }
        public AddressDTO getAddress() {
            return address;
        }
    }

    public static class MemberEditionRequest {
        private MemberDTO member;
        private AddressDTO address;
        public MemberDTO getMember() {
            return member;
        }
        public AddressDTO getAddress() {
            return address;
        }
    }

    @PostMapping
    public ResponseEntity<Object> registerMember(@RequestBody MemberRegistrationRequest request) {
        MemberDTO member = request.getMember();
        AddressDTO address = request.getAddress();
        return this.memberService.addMember(member, address);
    }

    @PutMapping
    public ResponseEntity<Object> editMember(@RequestBody MemberEditionRequest request) {
        MemberDTO member = request.getMember();
        AddressDTO address = request.getAddress();
        return this.memberService.editMember(member, address);
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteMember(@RequestParam String memberId) {
        return this.memberService.deleteMember(memberId);
    }
}
