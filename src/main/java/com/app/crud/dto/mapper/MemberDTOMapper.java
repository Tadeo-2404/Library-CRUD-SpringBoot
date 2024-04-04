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
        if(member == null) {
            throw new NullPointerException("Member is null");
        }
        return new MemberDTO(
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
    }

    public Member mapToMember(MemberDTO memberDTO) {
        if(memberDTO == null) {
            throw new NullPointerException("MemberDTO is null");
        }
        return new Member(
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
    }
}
