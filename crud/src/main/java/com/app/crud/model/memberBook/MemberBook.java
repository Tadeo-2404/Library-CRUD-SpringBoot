package com.app.crud.model.memberBook;

import com.app.crud.model.book.Book;
import com.app.crud.model.loan.Loan;
import com.app.crud.model.member.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "member_book")
public class MemberBook {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "memberBook_id")
    private String memberBook_id;

    @ManyToOne
    @JoinColumn(name = "memberId", referencedColumnName = "memberId")
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