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

    public List<Member> getMembersByCity(String city) {
        return addressRepository.findByCity(city)
                .stream()
                .map(address -> address.getMember())
                .collect(Collectors.toList());
    }

    public ResponseEntity<Object> addMember(Member member, Address address) {
        HashMap<String, Object> message = new HashMap<>();
        try {
            // Save the member
            Member memberSaved = this.memberRepository.save(member);

            //add member to address
            address.setMember(memberSaved);

            // Save the address
            Address addressSaved = this.addressRepository.save(address);

            // Update the member with the address
            memberSaved.setAddress(addressSaved);

            //save the member changes
            memberRepository.save(memberSaved);

            message.put("message", "Member created successfully");
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        } catch (Exception e) {
            message.put("message", e.getMessage());
            return new ResponseEntity<>(message, HttpStatus.CONFLICT);
        }
    }
}
