package com.app.crud.service;

import com.app.crud.model.address.Address;
import com.app.crud.repository.AddressRepository;
import com.app.crud.model.member.Member;
import com.app.crud.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MemberService {
    private MemberRepository memberRepository;
    private AddressRepository addressRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository, AddressRepository addressRepository) {
        this.memberRepository = memberRepository;
        this.addressRepository = addressRepository;
    }

    //get all members
    public List<Member> getMembers() {
        return memberRepository.findAll();
    }
    //get member by ID
    public Member getMemberByID(String memberId) {
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        return optionalMember.orElse(null);
    }
    //get member by name
    public List<Member> getMemberByName(String name) {
        return memberRepository.getByName(name);
    }
    //get member by lastname
    public List<Member> getMemberByLastname(String lastname) {
        return memberRepository.getByLastname(lastname);
    }
    //get member by age
    public List<Member> getMemberByAge(int age) {
        return memberRepository.getByAge(age);
    }
    //get member by name and lastname
    public List<Member> getMemberByNameAndLastname(String name, String lastname) {
        return memberRepository.getByNameAndLastname(name, lastname);
    }
    //get member by name and age
    public List<Member> getMemberByNameAndAge(String name, int age) {
        return memberRepository.getByNameAndAge(name, age);
    }
    //get member by lastname and age
    public List<Member> getMemberByLastnameAndAge(String lastname, int age) {
        return memberRepository.getByLastnameAndAge(lastname, age);
    }
    //get member by lastname and lastname and age
    public List<Member> getMemberByNameAndLastnameAndAge(String name, String lastname, int age) {
        return memberRepository.getByNameAndLastnameAndAge(name, lastname, age);
    }
    //get member by city
    public List<Member> getMembersByCity(String city) {
        return addressRepository.findByCity(city)
                .stream()
                .map(address -> address.getMember())
                .collect(Collectors.toList());
    }
    //get member by street
    public List<Member> getMembersByStreet(String street) {
        return addressRepository.findByStreet(street)
                .stream()
                .map(address -> address.getMember())
                .collect(Collectors.toList());
    }
    //get member by state
    public List<Member> getMembersByState(String state) {
        return addressRepository.findByState(state)
                .stream()
                .map(address -> address.getMember())
                .collect(Collectors.toList());
    }
    //get member by postalCode
    public List<Member> getMembersByPostalCode(String postalCode) {
        return addressRepository.findByPostalCode(postalCode)
                .stream()
                .map(address -> address.getMember())
                .collect(Collectors.toList());
    }
    // Get members by city and street
    public List<Member> getMembersByCityAndStreet(String street, String city) {
        return addressRepository.findByStreetAndCity(street, city)
                .stream()
                .map(address -> address.getMember())
                .collect(Collectors.toList());
    }
    // Get members by street and state
    public List<Member> getMembersByStreetAndState(String street, String state) {
        return addressRepository.findByStreetAndState(street, state)
                .stream()
                .map(address -> address.getMember())
                .collect(Collectors.toList());
    }
    // Get members by street and postal code
    public List<Member> getMembersByStreetAndPostalCode(String street, String postalCode) {
        return addressRepository.findByStreetAndPostalCode(street, postalCode)
                .stream()
                .map(address -> address.getMember())
                .collect(Collectors.toList());
    }
    // Get members by city and state
    public List<Member> getMembersByCityAndState(String city, String state) {
        return addressRepository.findByCityAndState(city, state)
                .stream()
                .map(address -> address.getMember())
                .collect(Collectors.toList());
    }
    // Get members by city and postal code
    public List<Member> getMembersByCityAndPostalCode(String city, String postalCode) {
        return addressRepository.findByCityAndPostalCode(city, postalCode)
                .stream()
                .map(address -> address.getMember())
                .collect(Collectors.toList());
    }
    // Get members by state and postal code
    public List<Member> getMembersByStateAndPostalCode(String state, String postalCode) {
        return addressRepository.findByStateAndPostalCode(state, postalCode)
                .stream()
                .map(address -> address.getMember())
                .collect(Collectors.toList());
    }
    // Get members by street, city, and state
    public List<Member> getMembersByStreetAndCityAndState(String street, String city, String state) {
        return addressRepository.findByStreetAndCityAndState(street, city, state)
                .stream()
                .map(address -> address.getMember())
                .collect(Collectors.toList());
    }
    // Get members by street, city, and postal code
    public List<Member> getMembersByStreetAndCityAndPostalCode(String street, String city, String postalCode) {
        return addressRepository.findByStreetAndCityAndPostalCode(street, city, postalCode)
                .stream()
                .map(address -> address.getMember())
                .collect(Collectors.toList());
    }

    // Get members by street, state, and postal code
    public List<Member> getMembersByStreetAndStateAndPostalCode(String street, String state, String postalCode) {
        return addressRepository.findByStreetAndStateAndPostalCode(street, state, postalCode)
                .stream()
                .map(address -> address.getMember())
                .collect(Collectors.toList());
    }
    // Get members by city, state, and postal code
    public List<Member> getMembersByCityAndStateAndPostalCode(String city, String state, String postalCode) {
        return addressRepository.findByCityAndStateAndPostalCode(city, state, postalCode)
                .stream()
                .map(address -> address.getMember())
                .collect(Collectors.toList());
    }
    // Get members by street, city, state, and postal code
    public List<Member> getMembersByStreetAndCityAndStateAndPostalCode(String street, String city, String state, String postalCode) {
        return addressRepository.findByStreetAndCityAndStateAndPostalCode(street, city, state, postalCode)
                .stream()
                .map(address -> address.getMember())
                .collect(Collectors.toList());
    }

    public ResponseEntity<Object> addMember(Member member, Address address) {
        HashMap<String, Object> message = new HashMap<>();
        try {
            // Save the member
            Member memberSaved = this.memberRepository.save(member);

            // Save the address
            Address addressSaved = this.addressRepository.save(address);

            // Update the member with the address
            memberSaved.setAddress(addressSaved);

            //add member to address
            address.setMember(memberSaved);

            //save the member changes
            memberRepository.save(memberSaved);

            //save the member changes
            addressRepository.save(addressSaved);

            message.put("message", "Member created successfully");
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        } catch (Exception e) {
            message.put("message", e.getMessage());
            return new ResponseEntity<>(message, HttpStatus.CONFLICT);
        }
    }

    public ResponseEntity<Object> editMember(Member member, Address address) {
        HashMap<String, Object> message = new HashMap<>();
        //valid if member already exist
        if(member.getMemberId() == null) {
            message.put("message", "Member must contain an ID");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }

        //valid if member already exist
        if(address.getAddress_id() == null) {
            message.put("message", "Address must contain an ID");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }

        Member memberExist = memberRepository.getById(member.getMemberId());
        Address addressExist = addressRepository.getById(address.getAddress_id());

        //valid if member exist
        if(memberExist == null) {
            message.put("message", "Member does not exist");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }

        //valid if address exist
        if(addressExist == null) {
            message.put("message", "Address does not exist");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }

        //valid if member and address have same ID
        if(!member.getMemberId().equals(addressExist.getMember().getMemberId())) {
            message.put("message", "The ID's does not match");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }

        try {
            // Save the member
            this.memberRepository.save(member);
            // Set the member to address
            address.setMember(member);
            // Save the address
            this.addressRepository.save(address);

            message.put("message", "Member edited successfully");
            return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            message.put("message", e.getMessage());
            return new ResponseEntity<>(message, HttpStatus.CONFLICT);
        }
    }
}
