package com.app.crud.dto.mapper;

import com.app.crud.dto.AddressDTO;
import com.app.crud.dto.MemberDTO;
import com.app.crud.model.address.Address;
import com.app.crud.model.member.Member;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class MemberDTOMapper implements Function<Member, MemberDTO> {
    @Override
    public MemberDTO apply(Member member) {
        Address address = member.getAddress();
        AddressDTO addressDTO = new AddressDTO(
                address.getAddress_id(),
                address.getStreet(),
                address.getCity(),
                address.getState(),
                address.getPostalCode()
        );

        return new MemberDTO(
                member.getMemberId(),
                member.getName(),
                member.getLastname(),
                member.getAge(),
                addressDTO
        );
    }
}
