package com.app.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class AddressDTO implements Serializable {
    private final String address_id;
    private final String street;
    private final String city;
    private final String state;
    private final String postalCode;
}
