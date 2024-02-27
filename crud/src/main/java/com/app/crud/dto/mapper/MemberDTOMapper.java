package com.app.crud.dto.mapper;

import com.app.crud.dto.AddressDTO;
import com.app.crud.dto.MemberDTO;
import com.app.crud.model.address.Address;
import com.app.crud.model.member.Member;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class MemberDTOMapper  {
    public MemberDTO mapToMemberDTO(Member member) {
        return new MemberDTO(
                member.getMemberId(),
                member.getName(),
                member.getLastname(),
                member.getAge()
        );
    }

    public Member mapToMember(MemberDTO memberDTO) {
        return new Member(
                memberDTO.getMemberId(),
                memberDTO.getName(),
                memberDTO.getLastname(),
                memberDTO.getAge()
        );
    }
}
