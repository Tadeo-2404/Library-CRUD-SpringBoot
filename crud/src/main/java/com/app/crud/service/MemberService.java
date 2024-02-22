package com.app.crud.service;

import com.app.crud.dto.AddressDTO;
import com.app.crud.dto.MemberDTO;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface MemberService {

    //get all members
    public List<MemberDTO> getMembers();
    //get member by ID
    public MemberDTO getMemberByID(String memberId);
    //get member by name
    public List<MemberDTO> getMemberByName(String name);
    //get member by lastname
    public List<MemberDTO> getMemberByLastname(String lastname);
    //get member by age
    public List<MemberDTO> getMemberByAge(int age);
    //get member by name and lastname
    public List<MemberDTO> getMemberByNameAndLastname(String name, String lastname);
    //get member by name and age
    public List<MemberDTO> getMemberByNameAndAge(String name, int age);
    //get member by lastname and age
    public List<MemberDTO> getMemberByLastnameAndAge(String lastname, int age);
    //get member by lastname and lastname and age
    public List<MemberDTO> getMemberByNameAndLastnameAndAge(String name, String lastname, int age);
    //get members by city
    public List<MemberDTO> getMembersByCity(String city);

    //get members by street
    public List<MemberDTO> getMembersByStreet(String street);

    //get members by state
    public List<MemberDTO> getMembersByState(String state);

    //get members by postalCode
    public List<MemberDTO> getMembersByPostalCode(String postalCode);
    // Get members by city and street
    public List<MemberDTO> getMembersByCityAndStreet(String street, String city);

    // Get members by street and state
    public List<MemberDTO> getMembersByStreetAndState(String street, String state);

    // Get members by street and postal code
    public List<MemberDTO> getMembersByStreetAndPostalCode(String street, String postalCode);

    // Get members by city and state
    public List<MemberDTO> getMembersByCityAndState(String city, String state);
    // Get members by city and postal code
    public List<MemberDTO> getMembersByCityAndPostalCode(String city, String postalCode);

    // Get members by state and postal code
    public List<MemberDTO> getMembersByStateAndPostalCode(String state, String postalCode);

    // Get members by street, city, and state
    public List<MemberDTO> getMembersByStreetAndCityAndState(String street, String city, String state);

    // Get members by street, city, and postal code
    public List<MemberDTO> getMembersByStreetAndCityAndPostalCode(String street, String city, String postalCode);

    // Get members by street, state, and postal code
    public List<MemberDTO> getMembersByStreetAndStateAndPostalCode(String street, String state, String postalCode);

    // Get members by city, state, and postal code
    public List<MemberDTO> getMembersByCityAndStateAndPostalCode(String city, String state, String postalCode);

    // Get members by street, city, state, and postal code
    public List<MemberDTO> getMembersByStreetAndCityAndStateAndPostalCode(String street, String city, String state, String postalCode);

    public ResponseEntity<Object> addMember(MemberDTO memberDTO, AddressDTO addressDTO);

    public ResponseEntity<Object> editMember(MemberDTO memberDTO, AddressDTO addressDTO);

    public ResponseEntity<Object> deleteMember(String memberId);
}
