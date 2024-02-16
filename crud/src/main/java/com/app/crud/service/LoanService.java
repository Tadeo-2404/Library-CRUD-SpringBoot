package com.app.crud.service;

import com.app.crud.model.loan.Loan;
import com.app.crud.model.member.Member;
import com.app.crud.repository.BookRepository;
import com.app.crud.repository.LoanRepository;
import com.app.crud.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class LoanService {
    private final LoanRepository loanRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public LoanService(LoanRepository loanRepository, MemberRepository memberRepository) {
        this.loanRepository = loanRepository;
        this.memberRepository = memberRepository;
    }

    public List<Loan> getLoans() {
        return this.loanRepository.findAll();
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
}
