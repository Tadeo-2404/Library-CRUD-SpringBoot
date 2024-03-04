package com.app.crud.service.Impl;

import com.app.crud.dto.AddressDTO;
import com.app.crud.dto.MemberDTO;
import com.app.crud.dto.mapper.MemberDTOMapper;
import com.app.crud.model.address.Address;
import com.app.crud.model.member.Member;
import com.app.crud.repository.AddressRepository;
import com.app.crud.repository.MemberRepository;
import com.app.crud.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public ResponseEntity<Object> getMembers() {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            List<MemberDTO> list = this.memberRepository.findAll()
                    .stream()
                    .map(memberDTOMapper::mapToMemberDTO)
                    .collect(Collectors.toList());

            if(list.size() > 0) {
                dataMap.put("status", 1);
                dataMap.put("data", list);
                return new ResponseEntity<>(dataMap, HttpStatus.OK);
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", "No registries found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //get member by ID
    public ResponseEntity<Object> getMemberByID(String memberId) {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            Member member = this.memberRepository.getById(memberId);
            MemberDTO memberDTO = this.memberDTOMapper.mapToMemberDTO(member);

            if(memberDTO != null) {
                dataMap.put("status", 1);
                dataMap.put("data", memberDTO);
                return new ResponseEntity<>(dataMap, HttpStatus.OK);
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", "No registries found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //get member by name
    public ResponseEntity<Object> getMemberByName(String name) {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            List<MemberDTO> list = this.memberRepository.getByName(name)
                    .stream()
                    .map(memberDTOMapper::mapToMemberDTO)
                    .collect(Collectors.toList());

            if(list.size() > 0) {
                dataMap.put("status", 1);
                dataMap.put("data", list);
                return new ResponseEntity<>(dataMap, HttpStatus.OK);
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", "No registries found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //get member by lastname
    public ResponseEntity<Object> getMemberByLastname(String lastname) {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            List<MemberDTO> list = this.memberRepository.getByLastname(lastname)
                    .stream()
                    .map(memberDTOMapper::mapToMemberDTO)
                    .collect(Collectors.toList());

            if(list.size() > 0) {
                dataMap.put("status", 1);
                dataMap.put("data", list);
                return new ResponseEntity<>(dataMap, HttpStatus.OK);
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", "No registries found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //get member by age
    public ResponseEntity<Object> getMemberByAge(int age) {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            List<MemberDTO> list = this.memberRepository.getByAge(age)
                    .stream()
                    .map(memberDTOMapper::mapToMemberDTO)
                    .collect(Collectors.toList());

            if(list.size() > 0) {
                dataMap.put("status", 1);
                dataMap.put("data", list);
                return new ResponseEntity<>(dataMap, HttpStatus.OK);
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", "No registries found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //get member by name and lastname
    public ResponseEntity<Object> getMemberByNameAndLastname(String name, String lastname) {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            List<MemberDTO> list = this.memberRepository.getByNameAndLastname(name, lastname)
                    .stream()
                    .map(memberDTOMapper::mapToMemberDTO)
                    .collect(Collectors.toList());

            if(list.size() > 0) {
                dataMap.put("status", 1);
                dataMap.put("data", list);
                return new ResponseEntity<>(dataMap, HttpStatus.OK);
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", "No registries found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //get member by name and age
    public ResponseEntity<Object> getMemberByNameAndAge(String name, int age) {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            List<MemberDTO> list = this.memberRepository.getByNameAndAge(name, age)
                    .stream()
                    .map(memberDTOMapper::mapToMemberDTO)
                    .collect(Collectors.toList());

            if(list.size() > 0) {
                dataMap.put("status", 1);
                dataMap.put("data", list);
                return new ResponseEntity<>(dataMap, HttpStatus.OK);
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", "No registries found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //get member by lastname and age
    public ResponseEntity<Object> getMemberByLastnameAndAge(String lastname, int age) {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            List<MemberDTO> list = this.memberRepository.getByLastnameAndAge(lastname, age)
                    .stream()
                    .map(memberDTOMapper::mapToMemberDTO)
                    .collect(Collectors.toList());

            if(list.size() > 0) {
                dataMap.put("status", 1);
                dataMap.put("data", list);
                return new ResponseEntity<>(dataMap, HttpStatus.OK);
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", "No registries found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //get member by lastname and lastname and age
    public ResponseEntity<Object> getMemberByNameAndLastnameAndAge(String name, String lastname, int age) {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            List<MemberDTO> list = this.memberRepository.getByLastnameAndAge(lastname, age)
                    .stream()
                    .map(memberDTOMapper::mapToMemberDTO)
                    .collect(Collectors.toList());

            if(list.size() > 0) {
                dataMap.put("status", 1);
                dataMap.put("data", list);
                return new ResponseEntity<>(dataMap, HttpStatus.OK);
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", "No registries found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //get members by city
    public ResponseEntity<Object> getMembersByCity(String city) {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            List<MemberDTO> list = this.addressRepository.findByCity(city)
                    .stream()
                    .map(Address::getMember)  // Map addresses to members
                    .map(memberDTOMapper::mapToMemberDTO)
                    .collect(Collectors.toList());

            if(list.size() > 0) {
                dataMap.put("status", 1);
                dataMap.put("data", list);
                return new ResponseEntity<>(dataMap, HttpStatus.OK);
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", "No registries found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //get members by street
    public ResponseEntity<Object> getMembersByStreet(String street) {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            List<MemberDTO> list = this.addressRepository.findByStreet(street)
                    .stream()
                    .map(Address::getMember)  // Map addresses to members
                    .map(memberDTOMapper::mapToMemberDTO)
                    .collect(Collectors.toList());

            if(list.size() > 0) {
                dataMap.put("status", 1);
                dataMap.put("data", list);
                return new ResponseEntity<>(dataMap, HttpStatus.OK);
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", "No registries found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //get members by state
    public ResponseEntity<Object> getMembersByState(String state) {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            List<MemberDTO> list = this.addressRepository.findByState(state)
                    .stream()
                    .map(Address::getMember)  // Map addresses to members
                    .map(memberDTOMapper::mapToMemberDTO)
                    .collect(Collectors.toList());

            if(list.size() > 0) {
                dataMap.put("status", 1);
                dataMap.put("data", list);
                return new ResponseEntity<>(dataMap, HttpStatus.OK);
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", "No registries found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //get members by postalCode
    public ResponseEntity<Object> getMembersByPostalCode(String postalCode) {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            List<MemberDTO> list = this.addressRepository.findByPostalCode(postalCode)
                    .stream()
                    .map(Address::getMember)  // Map addresses to members
                    .map(memberDTOMapper::mapToMemberDTO)
                    .collect(Collectors.toList());

            if(list.size() > 0) {
                dataMap.put("status", 1);
                dataMap.put("data", list);
                return new ResponseEntity<>(dataMap, HttpStatus.OK);
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", "No registries found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get members by city and street
    public ResponseEntity<Object> getMembersByCityAndStreet(String street, String city) {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            List<MemberDTO> list = this.addressRepository.findByStreetAndCity(street, city)
                    .stream()
                    .map(Address::getMember)  // Map addresses to members
                    .map(memberDTOMapper::mapToMemberDTO)
                    .collect(Collectors.toList());

            if(list.size() > 0) {
                dataMap.put("status", 1);
                dataMap.put("data", list);
                return new ResponseEntity<>(dataMap, HttpStatus.OK);
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", "No registries found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get members by street and state
    public ResponseEntity<Object> getMembersByStreetAndState(String street, String state) {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            List<MemberDTO> list = this.addressRepository.findByStreetAndState(street, state)
                    .stream()
                    .map(Address::getMember)  // Map addresses to members
                    .map(memberDTOMapper::mapToMemberDTO)
                    .collect(Collectors.toList());

            if(list.size() > 0) {
                dataMap.put("status", 1);
                dataMap.put("data", list);
                return new ResponseEntity<>(dataMap, HttpStatus.OK);
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", "No registries found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get members by street and postal code
    public ResponseEntity<Object> getMembersByStreetAndPostalCode(String street, String postalCode) {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            List<MemberDTO> list = this.addressRepository.findByStreetAndPostalCode(street, postalCode)
                    .stream()
                    .map(Address::getMember)  // Map addresses to members
                    .map(memberDTOMapper::mapToMemberDTO)
                    .collect(Collectors.toList());

            if(list.size() > 0) {
                dataMap.put("status", 1);
                dataMap.put("data", list);
                return new ResponseEntity<>(dataMap, HttpStatus.OK);
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", "No registries found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get members by city and state
    public ResponseEntity<Object> getMembersByCityAndState(String city, String state) {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            List<MemberDTO> list = this.addressRepository.findByCityAndState(city, state)
                    .stream()
                    .map(Address::getMember)  // Map addresses to members
                    .map(memberDTOMapper::mapToMemberDTO)
                    .collect(Collectors.toList());

            if(list.size() > 0) {
                dataMap.put("status", 1);
                dataMap.put("data", list);
                return new ResponseEntity<>(dataMap, HttpStatus.OK);
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", "No registries found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get members by city and postal code
    public ResponseEntity<Object> getMembersByCityAndPostalCode(String city, String postalCode) {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            List<MemberDTO> list = this.addressRepository.findByCityAndPostalCode(city, postalCode)
                    .stream()
                    .map(Address::getMember)  // Map addresses to members
                    .map(memberDTOMapper::mapToMemberDTO)
                    .collect(Collectors.toList());

            if(list.size() > 0) {
                dataMap.put("status", 1);
                dataMap.put("data", list);
                return new ResponseEntity<>(dataMap, HttpStatus.OK);
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", "No registries found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get members by state and postal code
    public ResponseEntity<Object> getMembersByStateAndPostalCode(String state, String postalCode) {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            List<MemberDTO> list = this.addressRepository.findByStateAndPostalCode(state, postalCode)
                    .stream()
                    .map(Address::getMember)  // Map addresses to members
                    .map(memberDTOMapper::mapToMemberDTO)
                    .collect(Collectors.toList());

            if(list.size() > 0) {
                dataMap.put("status", 1);
                dataMap.put("data", list);
                return new ResponseEntity<>(dataMap, HttpStatus.OK);
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", "No registries found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get members by street, city, and state
    public ResponseEntity<Object> getMembersByStreetAndCityAndState(String street, String city, String state) {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            List<MemberDTO> list = this.addressRepository.findByStreetAndCityAndState(street, city, state)
                    .stream()
                    .map(Address::getMember)  // Map addresses to members
                    .map(memberDTOMapper::mapToMemberDTO)
                    .collect(Collectors.toList());

            if(list.size() > 0) {
                dataMap.put("status", 1);
                dataMap.put("data", list);
                return new ResponseEntity<>(dataMap, HttpStatus.OK);
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", "No registries found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get members by street, city, and postal code
    public ResponseEntity<Object> getMembersByStreetAndCityAndPostalCode(String street, String city, String postalCode) {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            List<MemberDTO> list = this.addressRepository.findByStreetAndCityAndPostalCode(street, city, postalCode)
                    .stream()
                    .map(Address::getMember)  // Map addresses to members
                    .map(memberDTOMapper::mapToMemberDTO)
                    .collect(Collectors.toList());

            if(list.size() > 0) {
                dataMap.put("status", 1);
                dataMap.put("data", list);
                return new ResponseEntity<>(dataMap, HttpStatus.OK);
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", "No registries found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get members by street, state, and postal code
    public ResponseEntity<Object> getMembersByStreetAndStateAndPostalCode(String street, String state, String postalCode) {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            List<MemberDTO> list = this.addressRepository.findByStreetAndStateAndPostalCode(street, state, postalCode)
                    .stream()
                    .map(Address::getMember)  // Map addresses to members
                    .map(memberDTOMapper::mapToMemberDTO)
                    .collect(Collectors.toList());

            if(list.size() > 0) {
                dataMap.put("status", 1);
                dataMap.put("data", list);
                return new ResponseEntity<>(dataMap, HttpStatus.OK);
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", "No registries found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get members by city, state, and postal code
    public ResponseEntity<Object> getMembersByCityAndStateAndPostalCode(String city, String state, String postalCode) {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            List<MemberDTO> list = this.addressRepository.findByCityAndStateAndPostalCode(city, state, postalCode)
                    .stream()
                    .map(Address::getMember)  // Map addresses to members
                    .map(memberDTOMapper::mapToMemberDTO)
                    .collect(Collectors.toList());

            if(list.size() > 0) {
                dataMap.put("status", 1);
                dataMap.put("data", list);
                return new ResponseEntity<>(dataMap, HttpStatus.OK);
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", "No registries found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get members by street, city, state, and postal code
    public ResponseEntity<Object> getMembersByStreetAndCityAndStateAndPostalCode(String street, String city, String state, String postalCode) {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        try {
            List<MemberDTO> list = this.addressRepository.findByStreetAndCityAndStateAndPostalCode(street, city, state, postalCode)
                    .stream()
                    .map(Address::getMember)  // Map addresses to members
                    .map(memberDTOMapper::mapToMemberDTO)
                    .collect(Collectors.toList());

            if(list.size() > 0) {
                dataMap.put("status", 1);
                dataMap.put("data", list);
                return new ResponseEntity<>(dataMap, HttpStatus.OK);
            } else {
                dataMap.put("status", 1);
                dataMap.put("data", "No registries found");
                return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> addMember(MemberDTO memberDTO, AddressDTO addressDTO) {
        Map<String, Object> dataMap = new HashMap<String, Object>();
        try {
            // Convert DTOs to entities
            Member member = new Member(
                    memberDTO.getMemberId(),
                    memberDTO.getUsername(),
                    memberDTO.getPassword(),
                    memberDTO.getName(),
                    memberDTO.getLastname(),
                    memberDTO.getAge(),
                    memberDTO.getRole()
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

            // Save the updated member
            this.memberRepository.save(memberSaved);

            dataMap.put("status", 1);
            dataMap.put("message", "Member created successfully");
            return new ResponseEntity<>(dataMap, HttpStatus.CREATED);
        } catch (Exception e) {
            dataMap.put("message", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> editMember(MemberDTO memberDTO, AddressDTO addressDTO) {
        Map<String, Object> dataMap = new HashMap<String, Object>();
        //valid if member already exist
        if (memberDTO.getMemberId() == null) {
            dataMap.put("status", 1);
            dataMap.put("data", "Member must contain an ID");
            return new ResponseEntity<>(dataMap, HttpStatus.BAD_REQUEST);
        }

        //valid if address already exist
        if (addressDTO.getAddress_id() == null) {
            dataMap.put("status", 1);
            dataMap.put("data", "Address must contain an ID");
            return new ResponseEntity<>(dataMap, HttpStatus.BAD_REQUEST);
        }

        Member memberExist = memberRepository.getById(memberDTO.getMemberId());
        Address addressExist = addressRepository.getById(addressDTO.getAddress_id());

        //valid if member exist
        if (memberExist == null) {
            dataMap.put("status", 1);
            dataMap.put("data", "Member does not exist");
            return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
        }

        //valid if address exist
        if (addressExist == null) {
            dataMap.put("status", 1);
            dataMap.put("data", "Address does not exist");
            return new ResponseEntity<>(dataMap, HttpStatus.NOT_FOUND);
        }

        //valid if member and address have the same ID
        if (!memberDTO.getMemberId().equals(addressExist.getMember().getMemberId())) {
            dataMap.put("status", 1);
            dataMap.put("data", "The ID's does not match");
            return new ResponseEntity<>(dataMap, HttpStatus.BAD_REQUEST);
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

            dataMap.put("status", 1);
            dataMap.put("data", "Member edited successfully");
            return new ResponseEntity<>(dataMap, HttpStatus.OK);
        } catch (Exception e) {
            dataMap.put("status", 0);
            dataMap.put("data", e.getMessage());
            return new ResponseEntity<>(dataMap, HttpStatus.BAD_REQUEST);
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
