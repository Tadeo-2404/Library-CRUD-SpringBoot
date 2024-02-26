package com.app.crud.controller;

import com.app.crud.model.memberBook.MemberBook;
import com.app.crud.service.MemberBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;

@RestController
@RequestMapping(path = "api/v1/memberBooks")
public class MemberBookController {
    private final MemberBookService memberBookService;

    @Autowired
    public MemberBookController(MemberBookService memberBookService) {
        this.memberBookService = memberBookService;
    }

    @GetMapping
    public List<MemberBook> getMemberBooks(@RequestParam Map<String,String> allParams) {
        String member_book_id = allParams.get("member_book_id");
        String member_id = allParams.get("member_id");
        String loan_id = allParams.get("loan_id");
        String isbn = allParams.get("isbn");
        int amount_borrowed = parseInt(allParams.get("amount_borrowed"));

        if(member_book_id != null) {
            MemberBook memberBook = memberBookService.getById(member_book_id);
            return Collections.singletonList(memberBook);
        }
        else if(member_id != null) {
            return memberBookService.getByMember_MemberId(member_id);
        } else if(loan_id != null) {
            return memberBookService.getByLoan_ID(loan_id);
        } else if(isbn != null) {
            return memberBookService.getByBookISBN(isbn);
        } else if(amount_borrowed != 0) {
            return memberBookService.getByAmountBorrowed(amount_borrowed);
        }

        return this.memberBookService.getMemberBooks();
    }

    @PostMapping
    public ResponseEntity<String> createMemberBook(@RequestBody MemberBook memberBook) {;
        return this.memberBookService.createMemberBook(memberBook);
    }
}
