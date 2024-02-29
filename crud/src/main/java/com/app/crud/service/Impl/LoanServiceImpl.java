package com.app.crud.service.Impl;

import com.app.crud.dto.LoanDTO;
import com.app.crud.dto.mapper.BookDTOMapper;
import com.app.crud.dto.mapper.LoanDTOMapper;
import com.app.crud.dto.request.loan.BookLoanDetails;
import com.app.crud.dto.request.loan.LoanRequest;
import com.app.crud.model.loan.Loan;
import com.app.crud.model.member.Member;
import com.app.crud.model.memberBook.MemberBook;
import com.app.crud.repository.LoanRepository;
import com.app.crud.repository.MemberBookRepository;
import com.app.crud.repository.MemberRepository;
import com.app.crud.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanServiceImpl implements LoanService {
    private final LoanRepository loanRepository;
    private final MemberRepository memberRepository;
    private final LoanDTOMapper loanDTOMapper;
    private final MemberBookRepository memberBookRepository;
    private final BookDTOMapper bookDTOMapper;

    @Autowired
    public LoanServiceImpl(LoanRepository loanRepository,
                           MemberRepository memberRepository,
                           LoanDTOMapper loanDTOMapper,
                           MemberBookRepository memberBookRepository,
                           BookDTOMapper bookDTOMapper) {
        this.loanRepository = loanRepository;
        this.memberRepository = memberRepository;
        this.loanDTOMapper = loanDTOMapper;
        this.memberBookRepository = memberBookRepository;
        this.bookDTOMapper = bookDTOMapper;
    }

    public LoanDTO getById(String Id) {
        Loan loan = this.loanRepository.getById(Id);
        if (loan != null) {
            return loanDTOMapper.mapToLoanDTO(loan);
        } else {
            return null; // or throw an exception indicating the loan was not found
        }
    }

    public List<LoanDTO> getLoans() {
        return this.loanRepository.findAll()
                .stream()
                .map(loanDTOMapper::mapToLoanDTO)
                .collect(Collectors.toList());
    }

    public List<LoanDTO> getByDateBorrow(LocalDateTime dateBorrow) {
        return this.loanRepository.getByDateBorrow(dateBorrow)
                .stream()
                .map(loanDTOMapper::mapToLoanDTO)
                .collect(Collectors.toList());
    }

    public List<LoanDTO> getByDateLimit(LocalDateTime dateLimit) {
        return this.loanRepository.getByDateLimit(dateLimit)
                .stream()
                .map(loanDTOMapper::mapToLoanDTO)
                .collect(Collectors.toList());
    }

    public List<LoanDTO> getByMemberId(String memberId) {
        return this.loanRepository.getByMember_MemberId(memberId)
                .stream()
                .map(loanDTOMapper::mapToLoanDTO)
                .collect(Collectors.toList());
    }

    public List<LoanDTO> getByMemberIdAndDateBorrow(String memberId, LocalDateTime dateBorrow) {
        return this.loanRepository.getByMember_MemberIdAndDateBorrow(memberId, dateBorrow)
                .stream()
                .map(loanDTOMapper::mapToLoanDTO)
                .collect(Collectors.toList());
    }

    public List<LoanDTO> getByMemberIdAndDateLimit(String memberId, LocalDateTime dateLimit) {
        return this.loanRepository.getByMember_MemberIdAndDateLimit(memberId, dateLimit)
                .stream()
                .map(loanDTOMapper::mapToLoanDTO)
                .collect(Collectors.toList());
    }

    public List<LoanDTO> getByDateBorrowAndDateLimit(LocalDateTime dateBorrow, LocalDateTime dateLimit) {
        return this.loanRepository.getByDateBorrowAndDateLimit(dateBorrow, dateLimit)
                .stream()
                .map(loanDTOMapper::mapToLoanDTO)
                .collect(Collectors.toList());
    }

    public List<LoanDTO> getByMemberIdAndDateBorrowAndDateLimit(String memberId, LocalDateTime dateBorrow, LocalDateTime dateLimit) {
        return this.loanRepository.getByMember_MemberIdAndDateBorrowAndDateLimit(memberId, dateBorrow, dateLimit)
                .stream()
                .map(loanDTOMapper::mapToLoanDTO)
                .collect(Collectors.toList());
    }

    public ResponseEntity<Object> createLoan(LoanRequest loanRequest) {
        HashMap<String, Object> message = new HashMap<>();

        System.out.println("loan: " + loanRequest.getLoan());
        for (BookLoanDetails bookLoanDetails: loanRequest.getBookLoanDetailsList()) {
            System.out.println("book: " + bookLoanDetails.getBook());
        }

        //verify if member exist
        Member memberExist = memberRepository.getById(loanRequest.getLoan().getMember().getMemberId());
        if(memberExist == null) {
            message.put("error", "Member with ID" + loanRequest.getLoan().getMember().getMemberId() + "does not exist");
            return new ResponseEntity<>(
                    message,
                    HttpStatus.CONFLICT
            );
        }

        try {
            Loan loanCreated = this.loanRepository.save(loanRequest.getLoan());
            for (BookLoanDetails bookLoanDetails: loanRequest.getBookLoanDetailsList()) {
                MemberBook memberBook = new MemberBook(
                        loanRequest.getLoan().getMember(),
                        loanCreated,
                        bookDTOMapper.mapToBook(bookLoanDetails.getBook()),
                        bookLoanDetails.getAmountBorrowed()
                );
                message.put("msg", "MemberBook with ID " +  memberBook.getID() + " created");
            }
            message.put("success", loanCreated);

            return new ResponseEntity<>(
                    message,
                    HttpStatus.CREATED
            );
        } catch (Exception e) {
            message.put("error", e.getMessage());

            return new ResponseEntity<>(
                    message,
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    public ResponseEntity<Object> editLoan(Loan loan) {
        HashMap<String, Object> message = new HashMap<>();

        if(loan.getID() == null) {
            message.put("error", "ID must not be null");
            return new ResponseEntity<>(
                    message,
                    HttpStatus.BAD_REQUEST
            );
        }

        //check date limit data type
        if(!(loan.getDateLimit() instanceof LocalDateTime)) {
            message.put("error", "Date limit wrong format");
            return new ResponseEntity<>(
                    message,
                    HttpStatus.BAD_REQUEST
            );
        }

        //check date borrow data type
        if(!(loan.getDateBorrow() instanceof LocalDateTime)) {
            message.put("error", "Date borrow wrong format");
            return new ResponseEntity<>(
                    message,
                    HttpStatus.BAD_REQUEST
            );
        }

        //verify if member exist
        Member memberExist = memberRepository.getById(loan.getMember().getMemberId());
        if(memberExist == null) {
            message.put("error", "Member with ID" + loan.getMember().getMemberId() + "does not exist");
            return new ResponseEntity<>(
                    message,
                    HttpStatus.NOT_FOUND
            );
        }

        //verify if loan exist
        Loan loanExist = loanRepository.getById(loan.getID());
        if(loanExist == null) {
            message.put("error", "Loan with ID" + loan.getID()+ "does not exist");
            return new ResponseEntity<>(
                    message,
                    HttpStatus.NOT_FOUND
            );
        }

        //verify dates
        if(loan.getDateBorrow().isAfter(loan.getDateLimit()) || loan.getDateBorrow().isEqual(loan.getDateLimit())) {
            message.put("error", "Date Borrow must not be later than Date limit");
            return new ResponseEntity<>(
                    message,
                    HttpStatus.BAD_REQUEST
            );
        }

        try {
            Loan loanEdited = this.loanRepository.save(loan);
            message.put("success", loanEdited);

            return new ResponseEntity<>(
                    message,
                    HttpStatus.CREATED
            );
        } catch (Exception e) {
            message.put("error", e.getMessage());

            return new ResponseEntity<>(
                    message,
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
}
