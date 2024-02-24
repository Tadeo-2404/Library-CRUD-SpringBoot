package com.app.crud.repository;

import com.app.crud.model.memberBook.MemberBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberBookRepository extends JpaRepository<MemberBook, String> {
    List<MemberBook> getByMember_MemberId(String memberId);
    List<MemberBook> getByBookISBN(String ISBN);
    List<MemberBook> getByLoan_ID(String loan_ID);
    List<MemberBook> getByAmountBorrowed(int amount);
}
