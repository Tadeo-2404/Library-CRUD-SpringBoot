package com.app.crud.model.memberBook;

import com.app.crud.model.book.Book;
import com.app.crud.model.member.Member;
import jakarta.persistence.*;

@Entity
@Table
public class MemberBook {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "memberBook_id")
    private String memberBook_id;

    @ManyToOne
    @JoinColumn(name = "member_book_memberId", referencedColumnName = "memberId")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "ISBN", referencedColumnName = "ISBN")
    private Book book;

    private int amountBorrowed;
}
