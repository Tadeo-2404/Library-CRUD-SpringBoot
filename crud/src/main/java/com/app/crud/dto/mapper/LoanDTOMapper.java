package com.app.crud.dto.mapper;

import com.app.crud.dto.AddressDTO;
import com.app.crud.dto.LoanDTO;
import com.app.crud.dto.MemberDTO;
import com.app.crud.model.address.Address;
import com.app.crud.model.loan.Loan;
import com.app.crud.model.member.Member;
import org.springframework.stereotype.Service;

@Service
public class LoanDTOMapper {
    public LoanDTO mapToLoanDTO(Loan loan) {
        Member member = loan.getMember();


        MemberDTO memberDTO = new MemberDTO(
                member.getMemberId(),
                member.getEmail(),
                member.getPassword(),
                member.getUsername(),
                member.getName(),
                member.getLastname(),
                member.getAge(),
                member.getRoles()
        );

        return new LoanDTO(
                loan.getID(),  // Changed from loan.getID() to loan.getId()
                loan.getDateLimit(),
                loan.getDateBorrow(),
                memberDTO
        );
    }

    public Loan mapToLoan(LoanDTO loanDTO) {
        MemberDTO memberDTO = loanDTO.getMemberDTO();
        Member member = new Member(
                memberDTO.getMemberId(),
                memberDTO.getEmail(),
                memberDTO.getPassword(),
                memberDTO.getUsername(),
                memberDTO.getName(),
                memberDTO.getLastname(),
                memberDTO.getAge(),
                memberDTO.getRoles()
        );

        return new Loan(
                loanDTO.getID(),  // Changed from loanDTO.getID() to loanDTO.getId()
                loanDTO.getDateLimit(),
                loanDTO.getDateBorrow(),
                member
        );
    }
}
