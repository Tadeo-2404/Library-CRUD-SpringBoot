package com.app.crud.controller;

import com.app.crud.model.address.Address;
import com.app.crud.model.book.Book;
import com.app.crud.model.member.Member;
import com.app.crud.service.BookService;
import com.app.crud.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/members")
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public List<Member> getMembers(@RequestParam(required = false) String name, @RequestParam(required = false) String lastname, @RequestParam(required = false) Integer age, @RequestParam(required = false) String city) {
        if (name != null) {
            return memberService.getMemberByName(name);
        } else if (lastname != null) {
            return memberService.getMemberByLastname(lastname);
        } else if (age != null) {
            return memberService.getMemberByAge(age);
        } else if(city != null) {
            return memberService.getMembersByCity(city);
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
