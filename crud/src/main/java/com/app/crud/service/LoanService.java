package com.app.crud.service;
import com.app.crud.dto.LoanDTO;
import com.app.crud.dto.request.loan.LoanRequest;
import com.app.crud.model.loan.Loan;
import org.springframework.http.ResponseEntity;
import java.time.LocalDateTime;
import java.util.List;

public interface LoanService {

    public LoanDTO getById(String Id);

    public List<LoanDTO> getLoans();

    public List<LoanDTO> getByDateBorrow(LocalDateTime dateBorrow);

    public List<LoanDTO> getByDateLimit(LocalDateTime dateLimit);

    public List<LoanDTO> getByMemberId(String memberId);

    public List<LoanDTO> getByMemberIdAndDateBorrow(String memberId, LocalDateTime dateBorrow);

    public List<LoanDTO> getByMemberIdAndDateLimit(String memberId, LocalDateTime dateLimit);

    public List<LoanDTO> getByDateBorrowAndDateLimit(LocalDateTime dateBorrow, LocalDateTime dateLimit);

    public List<LoanDTO> getByMemberIdAndDateBorrowAndDateLimit(String memberId, LocalDateTime dateBorrow, LocalDateTime dateLimit);

    public ResponseEntity<Object> createLoan(LoanRequest loanRequest);

    public ResponseEntity<Object> editLoan(Loan loan);
}
