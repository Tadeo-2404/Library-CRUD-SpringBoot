package com.app.crud.controller;

import com.app.crud.model.loan.Loan;
import com.app.crud.service.BookService;
import com.app.crud.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/loans")
public class LoanController {
    private final LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping
    public List<Loan> getLoans() {
        return this.loanService.getLoans();
    }

    @PostMapping
    public ResponseEntity<Object> createLoan(@RequestBody Loan loan) {
        return loanService.createLoan(loan);
    }
}
