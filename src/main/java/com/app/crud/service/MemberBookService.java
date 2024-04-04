package com.app.crud.service;

import com.app.crud.model.memberBook.MemberBook;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MemberBookService {
    public ResponseEntity<Object> getById(String memberBook_id);
    public ResponseEntity<Object> getMemberBooks();
    public ResponseEntity<Object> getByMember_MemberId(String memberId);
    public ResponseEntity<Object> getByBookISBN(String ISBN);
    public ResponseEntity<Object> getByLoan_ID(String loan_ID);
    public ResponseEntity<Object> getByAmountBorrowed(int amount);
    public ResponseEntity<Object> createMemberBook(MemberBook memberBook);
}
