package com.app.crud.service.Impl;

import com.app.crud.model.loan.Loan;
import com.app.crud.model.member.Member;
import com.app.crud.repository.LoanRepository;
import com.app.crud.repository.MemberRepository;
import com.app.crud.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {
    private final LoanRepository loanRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public LoanServiceImpl(LoanRepository loanRepository, MemberRepository memberRepository) {
        this.loanRepository = loanRepository;
        this.memberRepository = memberRepository;
    }

    public Loan getById(String Id) {
        return this.loanRepository.getById(Id);
    }

    public List<Loan> getLoans() {
        return this.loanRepository.findAll();
    }

    public List<Loan> getByDateBorrow(LocalDateTime dateBorrow) {
        return this.loanRepository.getByDateBorrow(dateBorrow);
    }

    public List<Loan> getByDateLimit(LocalDateTime dateLimit) {
        return this.loanRepository.getByDateLimit(dateLimit);
    }

    public List<Loan> getByMemberId(String memberId) {
        return this.loanRepository.getByMember_MemberId(memberId);
    }

    public List<Loan> getByMemberIdAndDateBorrow(String memberId, LocalDateTime dateBorrow) {
        return this.loanRepository.getByMember_MemberIdAndDateBorrow(memberId, dateBorrow);
    }

    public List<Loan> getByMemberIdAndDateLimit(String memberId, LocalDateTime dateLimit) {
        return this.loanRepository.getByMember_MemberIdAndDateLimit(memberId, dateLimit);
    }

    public List<Loan> getByDateBorrowAndDateLimit(LocalDateTime dateBorrow, LocalDateTime dateLimit) {
        return this.loanRepository.getByDateBorrowAndDateLimit(dateBorrow, dateLimit);
    }

    public List<Loan> getByMemberIdAndDateBorrowAndDateLimit(String memberId, LocalDateTime dateBorrow, LocalDateTime dateLimit) {
        return this.loanRepository.getByMember_MemberIdAndDateBorrowAndDateLimit(memberId, dateBorrow, dateLimit);
    }

    public ResponseEntity<Object> createLoan(Loan loan) {
        HashMap<String, Object> message = new HashMap<>();

        //verify if member exist
        Member memberExist = memberRepository.getById(loan.getMember().getMemberId());
        if(memberExist == null) {
            message.put("error", "Member with ID" + loan.getMember().getMemberId() + "does not exist");
            return new ResponseEntity<>(
                    message,
                    HttpStatus.CONFLICT
            );
        }

        try {
            Loan loanCreated = this.loanRepository.save(loan);
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
