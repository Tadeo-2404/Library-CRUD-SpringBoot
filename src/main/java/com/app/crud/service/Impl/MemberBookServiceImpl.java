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
import java.util.Map;

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

    public ResponseEntity<Object> getById(String ID) {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            MemberBook memberBook = memberBookRepository.findById(ID).orElse(null);

            if(memberBook != null) {
                dataMap.put("status", 1);
                dataMap.put("data", memberBook);
                return new ResponseEntity<>(dataMap, HttpStatus.OK);
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", "MemberBook Not found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> getMemberBooks() {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            List<MemberBook> list = memberBookRepository.findAll();

            if(list.size() > 0) {
                dataMap.put("status", 1);
                dataMap.put("data", list);
                return new ResponseEntity<>(dataMap, HttpStatus.OK);
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", "No registries found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> getByMember_MemberId(String memberId) {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            List<MemberBook> list = memberBookRepository.getByMember_MemberId(memberId);

            if(list.size() > 0) {
                dataMap.put("status", 1);
                dataMap.put("data", list);
                return new ResponseEntity<>(dataMap, HttpStatus.OK);
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", "No registries found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> getByBookISBN(String ISBN) {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            List<MemberBook> list = memberBookRepository.getByBookISBN(ISBN);

            if(list.size() > 0) {
                dataMap.put("status", 1);
                dataMap.put("data", list);
                return new ResponseEntity<>(dataMap, HttpStatus.OK);
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", "No registries found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> getByLoan_ID(String loan_ID) {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            List<MemberBook> list = memberBookRepository.getByLoan_ID(loan_ID);

            if(list.size() > 0) {
                dataMap.put("status", 1);
                dataMap.put("data", list);
                return new ResponseEntity<>(dataMap, HttpStatus.OK);
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", "No registries found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> getByAmountBorrowed(int amount) {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            List<MemberBook> list = memberBookRepository.getByAmountBorrowed(amount);

            if(list.size() > 0) {
                dataMap.put("status", 1);
                dataMap.put("data", list);
                return new ResponseEntity<>(dataMap, HttpStatus.OK);
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", "No registries found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> createMemberBook(MemberBook memberBook) {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            //check if book exists
            Book book = bookRepository.getById(memberBook.getBook().getISBN());
            if (book == null) {
                dataMap.put("status", 1);
                dataMap.put("data", "Not found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
            //check if loan exists
            Loan loan = loanRepository.getById(memberBook.getLoan().getID());
            if (loan == null) {
                dataMap.put("status", 1);
                dataMap.put("data", "Not found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
            //check if member exists
            Member member = memberRepository.getById(memberBook.getMember().getMemberId());
            if (member == null) {
                dataMap.put("status", 1);
                dataMap.put("data", "Not found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }

            // Set related entities
            memberBook.setBook(book);
            memberBook.setMember(member);
            memberBook.setLoan(loan);

            // Save the member book
            memberBookRepository.save(memberBook);

            dataMap.put("status", 1);
            dataMap.put("data", memberBook);
            return new ResponseEntity<>(dataMap, HttpStatus.OK);
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
