package com.app.crud.service.Impl;

import com.app.crud.dto.AddressDTO;
import com.app.crud.dto.MemberDTO;
import com.app.crud.dto.mapper.MemberDTOMapper;
import com.app.crud.model.address.Address;
import com.app.crud.model.member.Member;
import com.app.crud.repository.AddressRepository;
import com.app.crud.repository.MemberRepository;
import com.app.crud.service.MemberService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberServiceImpl implements MemberService {
    private MemberRepository memberRepository;
    private AddressRepository addressRepository;
    private MemberDTOMapper memberDTOMapper;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository,
                         AddressRepository addressRepository,
                         MemberDTOMapper memberDTOMapper) {
        this.memberRepository = memberRepository;
        this.addressRepository = addressRepository;
        this.memberDTOMapper = memberDTOMapper;
    }

    //get all members
    public List<MemberDTO> getMembers() {
        return memberRepository.findAll()
                .stream().map(memberDTOMapper).collect(Collectors.toList());
    }
    //get member by ID
    public MemberDTO getMemberByID(String memberId) {
        return memberRepository.findById(memberId)
                .map(memberDTOMapper)
                .orElseThrow(() -> new EntityNotFoundException("Member not found with ID: " + memberId));
    }
    //get member by name
    public List<MemberDTO> getMemberByName(String name) {
        return memberRepository.getByName(name)
                .stream().map(memberDTOMapper).collect(Collectors.toList());
    }
    //get member by lastname
    public List<MemberDTO> getMemberByLastname(String lastname) {
        return memberRepository.getByLastname(lastname)
                .stream().map(memberDTOMapper).collect(Collectors.toList());
    }
    //get member by age
    public List<MemberDTO> getMemberByAge(int age) {
        return memberRepository.getByAge(age)
                .stream().map(memberDTOMapper).collect(Collectors.toList());
    }
    //get member by name and lastname
    public List<MemberDTO> getMemberByNameAndLastname(String name, String lastname) {
        return memberRepository.getByNameAndLastname(name, lastname)
                .stream().map(memberDTOMapper).collect(Collectors.toList());
    }
    //get member by name and age
    public List<MemberDTO> getMemberByNameAndAge(String name, int age) {
        return memberRepository.getByNameAndAge(name, age)
                .stream().map(memberDTOMapper).collect(Collectors.toList());
    }
    //get member by lastname and age
    public List<MemberDTO> getMemberByLastnameAndAge(String lastname, int age) {
        return memberRepository.getByLastnameAndAge(lastname, age)
                .stream().map(memberDTOMapper).collect(Collectors.toList());
    }
    //get member by lastname and lastname and age
    public List<MemberDTO> getMemberByNameAndLastnameAndAge(String name, String lastname, int age) {
        return memberRepository.getByNameAndLastnameAndAge(name, lastname, age)
                .stream().map(memberDTOMapper).collect(Collectors.toList());
    }
    //get members by city
    public List<MemberDTO> getMembersByCity(String city) {
        return addressRepository.findByCity(city)
                .stream()
                .map(Address::getMember)  // Map addresses to members
                .map(memberDTOMapper)      // Map members to DTOs
                .collect(Collectors.toList());
    }

    //get members by street
    public List<MemberDTO> getMembersByStreet(String street) {
        return addressRepository.findByStreet(street)
                .stream()
                .map(Address::getMember)  // Map addresses to members
                .map(memberDTOMapper)      // Map members to DTOs
                .collect(Collectors.toList());
    }

    //get members by state
    public List<MemberDTO> getMembersByState(String state) {
        return addressRepository.findByState(state)
                .stream()
                .map(Address::getMember)  // Map addresses to members
                .map(memberDTOMapper)      // Map members to DTOs
                .collect(Collectors.toList());
    }

    //get members by postalCode
    public List<MemberDTO> getMembersByPostalCode(String postalCode) {
        return addressRepository.findByPostalCode(postalCode)
                .stream()
                .map(Address::getMember)  // Map addresses to members
                .map(memberDTOMapper)      // Map members to DTOs
                .collect(Collectors.toList());
    }

    // Get members by city and street
    public List<MemberDTO> getMembersByCityAndStreet(String street, String city) {
        return addressRepository.findByStreetAndCity(street, city)
                .stream()
                .map(Address::getMember)  // Map addresses to members
                .map(memberDTOMapper)      // Map members to DTOs
                .collect(Collectors.toList());
    }

    // Get members by street and state
    public List<MemberDTO> getMembersByStreetAndState(String street, String state) {
        return addressRepository.findByStreetAndState(street, state)
                .stream()
                .map(Address::getMember)  // Map addresses to members
                .map(memberDTOMapper)      // Map members to DTOs
                .collect(Collectors.toList());
    }

    // Get members by street and postal code
    public List<MemberDTO> getMembersByStreetAndPostalCode(String street, String postalCode) {
        return addressRepository.findByStreetAndPostalCode(street, postalCode)
                .stream()
                .map(Address::getMember)  // Map addresses to members
                .map(memberDTOMapper)      // Map members to DTOs
                .collect(Collectors.toList());
    }

    // Get members by city and state
    public List<MemberDTO> getMembersByCityAndState(String city, String state) {
        return addressRepository.findByCityAndState(city, state)
                .stream()
                .map(Address::getMember)  // Map addresses to members
                .map(memberDTOMapper)      // Map members to DTOs
                .collect(Collectors.toList());
    }

    // Get members by city and postal code
    public List<MemberDTO> getMembersByCityAndPostalCode(String city, String postalCode) {
        return addressRepository.findByCityAndPostalCode(city, postalCode)
                .stream()
                .map(Address::getMember)  // Map addresses to members
                .map(memberDTOMapper)      // Map members to DTOs
                .collect(Collectors.toList());
    }

    // Get members by state and postal code
    public List<MemberDTO> getMembersByStateAndPostalCode(String state, String postalCode) {
        return addressRepository.findByStateAndPostalCode(state, postalCode)
                .stream()
                .map(Address::getMember)  // Map addresses to members
                .map(memberDTOMapper)      // Map members to DTOs
                .collect(Collectors.toList());
    }

    // Get members by street, city, and state
    public List<MemberDTO> getMembersByStreetAndCityAndState(String street, String city, String state) {
        return addressRepository.findByStreetAndCityAndState(street, city, state)
                .stream()
                .map(Address::getMember)  // Map addresses to members
                .map(memberDTOMapper)      // Map members to DTOs
                .collect(Collectors.toList());
    }

    // Get members by street, city, and postal code
    public List<MemberDTO> getMembersByStreetAndCityAndPostalCode(String street, String city, String postalCode) {
        return addressRepository.findByStreetAndCityAndPostalCode(street, city, postalCode)
                .stream()
                .map(Address::getMember)  // Map addresses to members
                .map(memberDTOMapper)      // Map members to DTOs
                .collect(Collectors.toList());
    }

    // Get members by street, state, and postal code
    public List<MemberDTO> getMembersByStreetAndStateAndPostalCode(String street, String state, String postalCode) {
        return addressRepository.findByStreetAndStateAndPostalCode(street, state, postalCode)
                .stream()
                .map(Address::getMember)  // Map addresses to members
                .map(memberDTOMapper)      // Map members to DTOs
                .collect(Collectors.toList());
    }

    // Get members by city, state, and postal code
    public List<MemberDTO> getMembersByCityAndStateAndPostalCode(String city, String state, String postalCode) {
        return addressRepository.findByCityAndStateAndPostalCode(city, state, postalCode)
                .stream()
                .map(Address::getMember)  // Map addresses to members
                .map(memberDTOMapper)      // Map members to DTOs
                .collect(Collectors.toList());
    }

    // Get members by street, city, state, and postal code
    public List<MemberDTO> getMembersByStreetAndCityAndStateAndPostalCode(String street, String city, String state, String postalCode) {
        return addressRepository.findByStreetAndCityAndStateAndPostalCode(street, city, state, postalCode)
                .stream()
                .map(Address::getMember)  // Map addresses to members
                .map(memberDTOMapper)      // Map members to DTOs
                .collect(Collectors.toList());
    }

    public ResponseEntity<Object> addMember(MemberDTO memberDTO, AddressDTO addressDTO) {
        HashMap<String, Object> message = new HashMap<>();
        try {
            // Convert DTOs to entities
            Member member = new Member(
                    memberDTO.getMemberId(),
                    memberDTO.getName(),
                    memberDTO.getLastname(),
                    memberDTO.getAge(),
                    null // Address will be set later
            );
            Address address = new Address(
                    member, // Member should be passed as the first parameter
                    addressDTO.getStreet(),
                    addressDTO.getCity(),
                    addressDTO.getState(),
                    addressDTO.getPostalCode()
            );

            // Save the member
            Member memberSaved = this.memberRepository.save(member);

            // Set the member ID in address
            address.setMember(memberSaved);

            // Save the address
            Address addressSaved = this.addressRepository.save(address);

            // Update the member with the address
            memberSaved.setAddress(addressSaved);

            // Save the updated member
            this.memberRepository.save(memberSaved);

            message.put("message", "Member created successfully");
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        } catch (Exception e) {
            message.put("message", e.getMessage());
            return new ResponseEntity<>(message, HttpStatus.CONFLICT);
        }
    }

    public ResponseEntity<Object> editMember(MemberDTO memberDTO, AddressDTO addressDTO) {
        HashMap<String, Object> message = new HashMap<>();
        //valid if member already exist
        if (memberDTO.getMemberId() == null) {
            message.put("message", "Member must contain an ID");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }

        //valid if address already exist
        if (addressDTO.getAddress_id() == null) {
            message.put("message", "Address must contain an ID");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }

        Member memberExist = memberRepository.getById(memberDTO.getMemberId());
        Address addressExist = addressRepository.getById(addressDTO.getAddress_id());

        //valid if member exist
        if (memberExist == null) {
            message.put("message", "Member does not exist");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }

        //valid if address exist
        if (addressExist == null) {
            message.put("message", "Address does not exist");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }

        //valid if member and address have the same ID
        if (!memberDTO.getMemberId().equals(addressExist.getMember().getMemberId())) {
            message.put("message", "The ID's do not match");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }

        try {
            // Update member fields
            memberExist.setName(memberDTO.getName());
            memberExist.setLastname(memberDTO.getLastname());
            memberExist.setAge(memberDTO.getAge());

            // Update address fields
            addressExist.setStreet(addressDTO.getStreet());
            addressExist.setCity(addressDTO.getCity());
            addressExist.setState(addressDTO.getState());
            addressExist.setPostalCode(addressDTO.getPostalCode());

            // Save the updated member and address
            this.memberRepository.save(memberExist);
            this.addressRepository.save(addressExist);

            message.put("message", "Member edited successfully");
            return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            message.put("message", e.getMessage());
            return new ResponseEntity<>(message, HttpStatus.CONFLICT);
        }
    }

    public ResponseEntity<Object> deleteMember(String memberId) {
        HashMap<String, Object> message = new HashMap<>();

        // Check if ID was passed and if member exists
        Member memberExist = memberRepository.findById(memberId).orElse(null);
        if (memberExist == null) {
            message.put("message", "Member does not exist");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }

        try {
            // Delete the member
            this.memberRepository.delete(memberExist);

            message.put("message", "Member deleted successfully");
            return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            message.put("message", e.getMessage());
            return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
