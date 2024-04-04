package com.app.crud.dto.request.member;
import com.app.crud.model.address.Address;
import com.app.crud.model.member.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberRequest {
    private Member member;
    private Address address;
}
