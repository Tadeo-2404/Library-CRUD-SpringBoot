package com.app.crud.controller;

import com.app.crud.model.memberBook.MemberBook;
import com.app.crud.service.MemberBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/memberBooks")
public class MemberBookController {
    private final MemberBookService memberBookService;

    @Autowired
    public MemberBookController(MemberBookService memberBookService) {
        this.memberBookService = memberBookService;
    }

    @GetMapping
    public List<MemberBook> getMemberBooks() {
        return this.memberBookService.getMemberBooks();
    }

    @PostMapping
    public ResponseEntity<Object> createMemberBook(@RequestBody MemberBook memberBook) {
        System.out.println(memberBook.getBook().getISBN());
        System.out.println(memberBook.getMember().getMemberId());
        System.out.println(memberBook.getLoan().getID());
        System.out.println(memberBook.getAmountBorrowed());
        return this.memberBookService.createMemberBook(memberBook);
    }
}
