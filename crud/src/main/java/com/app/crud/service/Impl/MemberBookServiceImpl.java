package com.app.crud.service.Impl;

import com.app.crud.model.book.Book;
import com.app.crud.model.loan.Loan;
import com.app.crud.model.member.Member;
import com.app.crud.model.memberBook.MemberBook;
import com.app.crud.repository.BookRepository;
import com.app.crud.repository.LoanRepository;
import com.app.crud.repository.MemberBookRepository;
import com.app.crud.repository.MemberRepository;
import com.app.crud.service.MemberBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class MemberBookServiceImpl implements MemberBookService {
    private final MemberBookRepository memberBookRepository;
    private final BookRepository bookRepository;
    private final LoanRepository loanRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public MemberBookServiceImpl(MemberBookRepository memberBookRepository,
                                 BookRepository bookRepository,
                                 LoanRepository loanRepository,
                                 MemberRepository memberRepository) {
        this.memberBookRepository = memberBookRepository;
        this.bookRepository = bookRepository;
        this.loanRepository = loanRepository;
        this.memberRepository = memberRepository;
    }

    public MemberBook getById(String ID) {
        return memberBookRepository.getById(ID);
    }

    public List<MemberBook> getMemberBooks() {
        return memberBookRepository.findAll();
    }

    public List<MemberBook> getByMember_MemberId(String memberId) {
        return memberBookRepository.getByMember_MemberId(memberId);
    }

    public List<MemberBook> getByBookISBN(String ISBN) {
        return memberBookRepository.getByBookISBN(ISBN);
    }

    public List<MemberBook> getByLoan_ID(String loan_ID) {
        return memberBookRepository.getByLoan_ID(loan_ID);
    }

    @Override
    public List<MemberBook> getByAmountBorrowed(int amount) {
        return memberBookRepository.getByAmountBorrowed(amount);
    }

    public ResponseEntity<String> createMemberBook(MemberBook memberBook) {
        try {
            //check if book exists
            Book book = bookRepository.getById(memberBook.getBook().getISBN());
            if (book == null) {
                return new ResponseEntity<>(
                        "Book with ISBN " + memberBook.getBook().getISBN() + " does not exist",
                        HttpStatus.BAD_REQUEST
                );
            }
            //check if loan exists
            Loan loan = loanRepository.getById(memberBook.getLoan().getID());
            if (loan == null) {
                return new ResponseEntity<>(
                        "Loan with ID " + memberBook.getLoan().getID() + " does not exist",
                        HttpStatus.BAD_REQUEST
                );
            }
            //check if member exists
            Member member = memberRepository.getById(memberBook.getMember().getMemberId());
            if (member == null) {
                return new ResponseEntity<>(
                        "Member with ID " + memberBook.getMember().getMemberId() + " does not exist",
                        HttpStatus.BAD_REQUEST
                );
            }

            // Set related entities
            memberBook.setBook(book);
            memberBook.setMember(member);
            memberBook.setLoan(loan);

            // Save the member book
            memberBookRepository.save(memberBook);

            return new ResponseEntity<>(
                    "MemberBook object created successfully",
                    HttpStatus.CREATED
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    e.getMessage(),
                    HttpStatus.CONFLICT
            );
        }
    }

}
