package com.app.crud.service;

import com.app.crud.dto.AddressDTO;
import com.app.crud.dto.MemberDTO;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface MemberService {

    //get all members
    public ResponseEntity<Object> getMembers();
    //get member by ID
    public ResponseEntity<Object> getMemberByID(String memberId);
    //get member by name
    public ResponseEntity<Object> getMemberByName(String name);
    //get member by email
    public ResponseEntity<Object> getMemberByEmail(String email);
    //get member by username
    public ResponseEntity<Object> getMemberByUsername(String username);
    //get member by lastname
    public ResponseEntity<Object> getMemberByLastname(String lastname);
    //get member by age
    public ResponseEntity<Object> getMemberByAge(int age);
    //get member by name and lastname
    public ResponseEntity<Object> getMemberByNameAndLastname(String name, String lastname);
    //get member by name and age
    public ResponseEntity<Object> getMemberByNameAndAge(String name, int age);
    //get member by lastname and age
    public ResponseEntity<Object> getMemberByLastnameAndAge(String lastname, int age);
    //get member by lastname and lastname and age
    public ResponseEntity<Object> getMemberByNameAndLastnameAndAge(String name, String lastname, int age);
    //get members by city
    public ResponseEntity<Object> getMembersByCity(String city);

    //get members by street
    public ResponseEntity<Object> getMembersByStreet(String street);

    //get members by state
    public ResponseEntity<Object> getMembersByState(String state);

    //get members by postalCode
    public ResponseEntity<Object> getMembersByPostalCode(String postalCode);
    // Get members by city and street
    public ResponseEntity<Object> getMembersByCityAndStreet(String street, String city);

    // Get members by street and state
    public ResponseEntity<Object> getMembersByStreetAndState(String street, String state);

    // Get members by street and postal code
    public ResponseEntity<Object> getMembersByStreetAndPostalCode(String street, String postalCode);

    // Get members by city and state
    public ResponseEntity<Object> getMembersByCityAndState(String city, String state);
    // Get members by city and postal code
    public ResponseEntity<Object> getMembersByCityAndPostalCode(String city, String postalCode);

    // Get members by state and postal code
    public ResponseEntity<Object> getMembersByStateAndPostalCode(String state, String postalCode);

    // Get members by street, city, and state
    public ResponseEntity<Object> getMembersByStreetAndCityAndState(String street, String city, String state);

    // Get members by street, city, and postal code
    public ResponseEntity<Object> getMembersByStreetAndCityAndPostalCode(String street, String city, String postalCode);

    // Get members by street, state, and postal code
    public ResponseEntity<Object> getMembersByStreetAndStateAndPostalCode(String street, String state, String postalCode);

    // Get members by city, state, and postal code
    public ResponseEntity<Object> getMembersByCityAndStateAndPostalCode(String city, String state, String postalCode);

    // Get members by street, city, state, and postal code
    public ResponseEntity<Object> getMembersByStreetAndCityAndStateAndPostalCode(String street, String city, String state, String postalCode);

    public ResponseEntity<Object> addMember(MemberDTO memberDTO);

    public ResponseEntity<Object> addMember(MemberDTO memberDTO, AddressDTO addressDTO);

    public ResponseEntity<Object> editMember(MemberDTO memberDTO, AddressDTO addressDTO);

    public ResponseEntity<Object> deleteMember(String memberId);
}
