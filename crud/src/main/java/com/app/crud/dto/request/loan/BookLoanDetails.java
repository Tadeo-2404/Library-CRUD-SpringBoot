package com.app.crud.dto.request.loan;

import com.app.crud.dto.BookDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookLoanDetails {
    private BookDTO book;
    private int amountBorrowed;
}