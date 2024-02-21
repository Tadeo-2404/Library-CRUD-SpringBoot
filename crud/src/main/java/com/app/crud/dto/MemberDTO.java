package com.app.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Setter
@Getter
public class MemberDTO implements Serializable {
    final String memberId;
    final String name;
    final String lastname;
    final int age;
    final AddressDTO address;
}
