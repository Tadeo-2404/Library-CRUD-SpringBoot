package com.app.crud.repository;

import com.app.crud.model.loan.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, String> {
    @Override
    Loan getById(String Id);
    List<Loan> getByMember_MemberId(String memberId);
    List<Loan> getByDateBorrow(LocalDateTime dateBorrow);
    List<Loan> getByDateLimit(LocalDateTime dateLimit);
    List<Loan> getByMember_MemberIdAndDateBorrow(String memberId, LocalDateTime dateBorrow);
    List<Loan> getByMember_MemberIdAndDateLimit(String memberId, LocalDateTime dateLimit);
    List<Loan> getByDateBorrowAndDateLimit(LocalDateTime dateBorrow, LocalDateTime dateLimit);
    List<Loan> getByMember_MemberIdAndDateBorrowAndDateLimit(String memberId, LocalDateTime dateBorrow, LocalDateTime dateLimit);
}
