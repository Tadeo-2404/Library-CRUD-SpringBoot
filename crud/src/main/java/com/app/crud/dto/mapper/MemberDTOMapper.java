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
                member.getEmail(),
                member.getPassword(),
                member.getUsername(),
                member.getName(),
                member.getLastname(),
                member.getAge(),
                member.getRoles()
        );
    }

    public Member mapToMember(MemberDTO memberDTO) {
        return new Member(
                memberDTO.getMemberId(),
                memberDTO.getEmail(),
                memberDTO.getUsername(),
                memberDTO.getPassword(),
                memberDTO.getName(),
                memberDTO.getLastname(),
                memberDTO.getAge(),
                memberDTO.getRoles()
        );
    }
}
