package com.app.crud.dto.mapper;

import com.app.crud.dto.AddressDTO;
import com.app.crud.model.address.Address;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class AddressDTOMapper implements Function<Address, AddressDTO> {
    @Override
    public AddressDTO apply(Address address) {
        return new AddressDTO(
                address.getAddress_id(),
                address.getStreet(),
                address.getCity(),
                address.getState(),
                address.getPostalCode()
        );
    }
}
