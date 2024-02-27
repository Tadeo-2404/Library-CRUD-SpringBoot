package com.app.crud.controller;

import com.app.crud.model.memberBook.MemberBook;
import com.app.crud.service.MemberBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ResponseEntity<Object> getMemberBooks(@RequestParam Map<String,String> allParams) {
        String ID = allParams.get("ID");
        String member_id = allParams.get("member_id");
        String loan_id = allParams.get("loan_id");
        String isbn = allParams.get("isbn");
        Integer amount_borrowed = null;
        if (allParams.get("amount_borrowed") != null) {
            amount_borrowed = Integer.parseInt(allParams.get("amount_borrowed"));
        }

        if(ID != null) {
            return memberBookService.getById(ID);
        }
        else if(member_id != null) {
            return memberBookService.getByMember_MemberId(member_id);
        } else if(loan_id != null) {
            return memberBookService.getByLoan_ID(loan_id);
        } else if(isbn != null) {
            return memberBookService.getByBookISBN(isbn);
        } else if(amount_borrowed != null) {
            return memberBookService.getByAmountBorrowed(amount_borrowed);
        }

        return this.memberBookService.getMemberBooks();
    }

    @PostMapping
    public ResponseEntity<Object> createMemberBook(@RequestBody MemberBook memberBook) {;
        return this.memberBookService.createMemberBook(memberBook);
    }
}
