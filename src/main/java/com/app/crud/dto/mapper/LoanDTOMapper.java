package com.app.crud.dto.mapper;

import com.app.crud.dto.AddressDTO;
import com.app.crud.dto.LoanDTO;
import com.app.crud.dto.MemberDTO;
import com.app.crud.model.loan.Loan;
import com.app.crud.model.member.Member;
import org.springframework.stereotype.Service;

@Service
public class LoanDTOMapper {
    public LoanDTO mapToLoanDTO(Loan loan) {
        if(loan == null) {
            throw new NullPointerException("Loan is null");
        }
        Member member = loan.getMember();
        if(member == null) {
            throw new NullPointerException("Member is null");
        }
        MemberDTO memberDTO = new MemberDTO(
                member.getMemberId(),
                member.getEmail(),
                member.getUsername(),
                member.getPassword(),
                member.getName(),
                member.getLastname(),
                member.getAge(),
                member.getRoles(),
                member.getPermissions()
        );
        return new LoanDTO(
                loan.getID(),  // Changed from loan.getID() to loan.getId()
                loan.getDateBorrow(),
                loan.getDateLimit(),
                memberDTO
        );
    }

    public Loan mapToLoan(LoanDTO loanDTO) {
        if(loanDTO == null) {
            throw new NullPointerException("LoanDTO is null");
        }
        MemberDTO memberDTO = loanDTO.getMemberDTO();
        if(memberDTO == null) {
            throw new NullPointerException("MemberDTO attribute is null");
        }
        Member member = new Member(
                memberDTO.getMemberId(),
                memberDTO.getEmail(),
                memberDTO.getUsername(),
                memberDTO.getPassword(),
                memberDTO.getName(),
                memberDTO.getLastname(),
                memberDTO.getAge(),
                memberDTO.getRoles(),
                memberDTO.getPermissions()
        );

        return new Loan(
                loanDTO.getID(),
                loanDTO.getDateBorrow(),
                loanDTO.getDateLimit(),
                member
        );
    }
}
