package com.app.crud.repository;

import com.app.crud.model.memberBook.MemberBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberBookRepository extends JpaRepository<MemberBook, String> {
    List<MemberBook> getByMember_id(String member_id);
    List<MemberBook> getByISBN(String ISBN);
    List<MemberBook> getByLoan_id(String loan_id);
    List<MemberBook> getByAmount(int amount);
}
