package com.app.crud.controller;

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
    public List<Member> getMembers(@RequestParam Map<String,String> allParams) {
        String ID = allParams.get("ID");
        String name = allParams.get("name");
        String ageStr = allParams.get("age");
        Integer age = null;
        if (ageStr != null) {
            age = Integer.parseInt(ageStr);
        }
        String lastname = allParams.get("lastname");
        String city = allParams.get("city");
        String street = allParams.get("street");
        String state = allParams.get("state");
        String postalCode = allParams.get("postalCode");

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
            List<Member> list = new ArrayList<>();
            Member member = memberService.getMemberByID(ID);
            list.add(member);
            return list;
        } else if (name != null) {
            return memberService.getMemberByName(name);
        } else if (lastname != null) {
            return memberService.getMemberByLastname(lastname);
        } else if(city != null) {
            return memberService.getMembersByCity(city);
        } else if(street != null) {
            return memberService.getMembersByStreet(street);
        } else if(state != null) {
            return memberService.getMembersByState(state);
        } else if(postalCode != null) {
            return memberService.getMembersByPostalCode(postalCode);
        } else {
            return memberService.getMembers();
        }
    }

    public static class MemberRegistrationRequest {
        private Member member;
        private Address address;

        public Member getMember() {
            return member;
        }

        public Address getAddress() {
            return address;
        }
    }

    @PostMapping
    public ResponseEntity<Object> registerMember(@RequestBody MemberRegistrationRequest request) {
        Member member = request.getMember();
        Address address = request.getAddress();
        return this.memberService.addMember(member, address);
    }
}
