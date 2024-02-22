package com.app.crud.service;
import com.app.crud.model.loan.Loan;
import org.springframework.http.ResponseEntity;
import java.time.LocalDateTime;
import java.util.List;

public interface LoanService {

    public Loan getById(String Id);

    public List<Loan> getLoans();

    public List<Loan> getByDateBorrow(LocalDateTime dateBorrow);

    public List<Loan> getByDateLimit(LocalDateTime dateLimit);

    public List<Loan> getByMemberId(String memberId);

    public List<Loan> getByMemberIdAndDateBorrow(String memberId, LocalDateTime dateBorrow);

    public List<Loan> getByMemberIdAndDateLimit(String memberId, LocalDateTime dateLimit);

    public List<Loan> getByDateBorrowAndDateLimit(LocalDateTime dateBorrow, LocalDateTime dateLimit);

    public List<Loan> getByMemberIdAndDateBorrowAndDateLimit(String memberId, LocalDateTime dateBorrow, LocalDateTime dateLimit);

    public ResponseEntity<Object> createLoan(Loan loan);

    public ResponseEntity<Object> editLoan(Loan loan);
}
