package com.app.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Setter
@Getter
public class AddressDTO implements Serializable {
    private final String address_id;
    private final String street;
    private final String city;
    private final String state;
    private final String postalCode;
}
