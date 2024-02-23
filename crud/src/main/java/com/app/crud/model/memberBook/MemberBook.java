package com.app.crud.model.memberBook;

import com.app.crud.model.book.Book;
import com.app.crud.model.loan.Loan;
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
    @JoinColumn(name = "member_id", referencedColumnName = "memberId")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "ISBN", referencedColumnName = "ISBN")
    private Book book;

    @OneToOne
    @JoinColumn(
            name = "loan_ID",
            referencedColumnName = "ID"
    )
    private Loan loan;
    private int amountBorrowed;
}