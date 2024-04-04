package com.app.crud.dto.request.loan;

import com.app.crud.model.loan.Loan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoanRequest {
    private Loan loan;
    private List<BookLoanDetails> bookLoanDetailsList;
}

