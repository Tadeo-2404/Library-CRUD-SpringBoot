package com.app.crud.service;

import com.app.crud.model.address.Address;
import com.app.crud.repository.AddressRepository;
import com.app.crud.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class AddressService {
    private AddressRepository addressRepository;
    private MemberRepository memberRepository;

    @Autowired
    public AddressService(MemberRepository memberRepository, AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
        this.memberRepository = memberRepository;
    }

    //get all the addresses
    public List<Address> getAddresses() {
        return addressRepository.findAll();
    }

    public Address getByID(String ID) {
        return addressRepository.getById(ID);
    }

    public List<Address> getAddressesByStreet(String street) {
        return addressRepository.findByStreet(street);
    }

    public List<Address> getAddressesByCity(String city) {
        return addressRepository.findByCity(city);
    }

    public List<Address> getAddressesByState(String state) {
        return addressRepository.findByState(state);
    }

    public List<Address> getAddressesByPostalCode(String postalCode) {
        return addressRepository.findByPostalCode(postalCode);
    }

    //add address
    public ResponseEntity<Object>  addAddress(Address address) {
        HashMap<String, Object> message = new HashMap<>();
        Boolean memberExist = this.memberRepository.existsById(address.getMember().getMemberId());

        if(!memberExist) {
            message.put("message", "Member does not exist");
            return new ResponseEntity<>(
                    message,
                    HttpStatus.CONFLICT
            );
        }

        try {
            message.put("success", address);
            message.put("message", "Address created successfully");

            this.addressRepository.save(address);
            return new ResponseEntity<>(
                    message,
                    HttpStatus.CREATED
            );
        } catch (Exception e) {
            message.put("error", true);
            message.put("message", "Something went wrong");
            return new ResponseEntity<>(
                    message,
                    HttpStatus.CONFLICT
            );
        }
    }
}
