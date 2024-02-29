package com.app.crud.model.memberBook;

import com.app.crud.model.book.Book;
import com.app.crud.model.loan.Loan;
import com.app.crud.model.member.Member;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "member_book")
public class MemberBook {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID")
    private String ID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "memberId", referencedColumnName = "memberId")
    private Member member;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ISBN", referencedColumnName = "ISBN")
    private Book book;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "loan_ID", referencedColumnName = "ID")
    private Loan loan;
    private int amountBorrowed;

    public MemberBook(Member member, Loan loanCreated, Book book, int amountBorrowed) {
        this.member = member;
        this.loan = loanCreated;
        this.book = book;
        this.amountBorrowed = amountBorrowed;
    }
}