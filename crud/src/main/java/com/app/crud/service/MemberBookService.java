package com.app.crud.service;

import com.app.crud.model.memberBook.MemberBook;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MemberBookService {
    public MemberBook getById(String memberBook_id);
    public List<MemberBook> getMemberBooks();
    public List<MemberBook> getByMember_MemberId(String memberId);
    public List<MemberBook> getByBookISBN(String ISBN);
    public List<MemberBook> getByLoan_ID(String loan_ID);
    public List<MemberBook> getByAmountBorrowed(int amount);
    public ResponseEntity<String> createMemberBook(MemberBook memberBook);
}
