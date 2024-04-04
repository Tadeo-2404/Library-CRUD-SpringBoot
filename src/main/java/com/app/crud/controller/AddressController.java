package com.app.crud.controller;

import com.app.crud.model.address.Address;
import com.app.crud.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/addresses")
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public List<Address> getBooks(@RequestParam(required = false) String street, @RequestParam(required = false) String city,
                                  @RequestParam(required = false) String state,
                                  @RequestParam(required = false) String postalCode) {
        if (street != null) {
            return addressService.getAddressesByStreet(street);
        } else if (city != null) {
            return addressService.getAddressesByCity(city);
        } else if (state != null) {
            return addressService.getAddressesByState(state);
        } else if (postalCode != null) {
            return addressService.getAddressesByPostalCode(postalCode);
        } else {
            return addressService.getAddresses();
        }
    }

    @PostMapping
    public ResponseEntity<Object> registerAddress(@RequestBody Address address) {
        return this.addressService.addAddress(address);
    }

}
