package com.app.crud.dto.mapper;

import com.app.crud.dto.AddressDTO;
import com.app.crud.model.address.Address;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class AddressDTOMapper {
    public AddressDTO mapToAddressDTO(Address address) {
        if(address == null) {
            throw new NullPointerException("Address param is null");
        }
        return new AddressDTO(
                address.getAddress_id(),
                address.getStreet(),
                address.getCity(),
                address.getState(),
                address.getPostalCode()
        );
    }

    public Address mapToAddress(AddressDTO addressDTO) {
        if(addressDTO == null) {
            throw new NullPointerException("AddressDTO param is null");
        }
        return new Address(
                addressDTO.getAddress_id(),
                addressDTO.getStreet(),
                addressDTO.getCity(),
                addressDTO.getState(),
                addressDTO.getPostalCode()
        );
    }
}
