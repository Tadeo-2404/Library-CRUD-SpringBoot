package com.app.crud.controller;

import com.app.crud.model.book.Book;
import com.app.crud.model.member.Member;
import com.app.crud.service.BookService;
import com.app.crud.service.MemberService;
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
    public List<Member> getMembers(@RequestParam(required = false) String name, @RequestParam(required = false) String lastname, @RequestParam(required = false) Integer age) {
        if (name != null) {
            return memberService.getMemberByName(name);
        } else if (lastname != null) {
            return memberService.getMemberByLastname(lastname);
        } else if (age != null) {
            return memberService.getMemberByAge(age);
        } else {
            return memberService.getMembers();
        }
    }

    @PostMapping
    public ResponseEntity<Object> registerMember(@RequestBody Member member) {
        return this.memberService.addMember(member);
    }

}
