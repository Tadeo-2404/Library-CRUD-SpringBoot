package com.app.crud.controller;

import com.app.crud.dto.BookDTO;
import com.app.crud.dto.LoanDTO;
import com.app.crud.dto.request.loan.LoanRequest;
import com.app.crud.model.loan.Loan;
import com.app.crud.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
    public List<LoanDTO> getLoans(@RequestParam(required = false) String memberId,
                                  @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateBorrow,
                                  @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateLimit) {
        if (memberId != null) {
            // If memberId is provided, return Loans associated with that memberId
            return loanService.getByMemberId(memberId);
        } else if (dateBorrow != null) {
            return loanService.getByDateBorrow(dateBorrow);
        } else if (dateLimit != null) {
            return loanService.getByDateLimit(dateLimit);
        } else if (dateBorrow != null && dateLimit != null) {
            // If both dateBorrow and dateLimit are provided, return Loans within that date range
            return loanService.getByDateBorrowAndDateLimit(dateBorrow, dateLimit);
        } else if (memberId != null && dateLimit != null) {
            return loanService.getByMemberIdAndDateLimit(memberId, dateLimit);
        } else if (memberId != null && dateBorrow != null && dateLimit != null) {
            return loanService.getByMemberIdAndDateBorrowAndDateLimit(memberId, dateBorrow, dateLimit);
        } else {
            // If no specific parameters are provided, return all Loans
            return loanService.getLoans();
        }
    }

    @PostMapping
    public ResponseEntity<Object> createLoan(@RequestBody LoanRequest loanRequest) {
        return loanService.createLoan(loanRequest);
    }

    @PutMapping
    public ResponseEntity<Object> editLoan(@RequestBody Loan loan) {
        return loanService.editLoan(loan);
    }
}
