package com.app.crud.service;

import com.app.crud.model.memberBook.MemberBook;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MemberBookService {
    public List<MemberBook> getMemberBooks();
    public List<MemberBook> getByMember_id(String member_id);
    public List<MemberBook> getByISBN(String ISBN);
    public List<MemberBook> getByLoan_ID(String loan_ID);
    public List<MemberBook> getByAmount(int amount);
    public ResponseEntity<Object> createMemberBook(MemberBook memberBook);
}
