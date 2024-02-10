package com.app.crud.repository;

import com.app.crud.model.memberBook.MemberBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberBookRepository extends JpaRepository<MemberBook, String> {
}
