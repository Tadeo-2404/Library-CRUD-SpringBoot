package com.app.crud.dto;

import com.app.crud.dto.MemberDTO;
import com.app.crud.dto.mapper.MemberDTOMapper;
import com.app.crud.model.member.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class MemberMapperTest {
    MemberDTOMapper memberDTOMapper;

    @BeforeEach
    public void setup() {
        memberDTOMapper = new MemberDTOMapper();
    }

    @Test
    public void shouldMapMemberToMemberDTO() {
        //set roles
        Set<Role> expectedRoles = new HashSet<Role>();
        //add role
        expectedRoles.add(new Role(ERole.USER.toString()));
        //set permissions
        Set<Permission> expectedPermissions = new HashSet<>();
        //add permission
        expectedPermissions.add(new Permission(EPermission.CREATE_BOOK.toString()));
        //declare expected member object
        Member expected = new Member("memberID", "mail@mail.com", "username", "password", "name", "lastname", 20, expectedRoles, expectedPermissions);
        //declare actual member object
        MemberDTO actual = memberDTOMapper.mapToMemberDTO(expected);

        //check attributes
        Assertions.assertEquals(expected.getMemberId(), actual.getMemberId(), "Attribute memberID does not match");
        Assertions.assertEquals(expected.getName(), actual.getName(), "Attribute name does not match");
        Assertions.assertEquals(expected.getLastname(), actual.getLastname(), "Attribute lastname does not match");
        Assertions.assertEquals(expected.getEmail(), actual.getEmail(), "Attribute email does not match");
        Assertions.assertEquals(expected.getUsername(), actual.getUsername(), "Attribute username does not match");
        Assertions.assertEquals(expected.getPassword(), actual.getPassword(), "Attribute password does not match");
        Assertions.assertEquals(expected.getAge(), actual.getAge(), "Attribute age does not match");
        Assertions.assertEquals(expected.getRoles(), actual.getRoles(), "Attribute roles does not match");
        Assertions.assertEquals(expected.getPermissions(), actual.getPermissions(), "Attribute permissions does not match");
    }

    @Test
    public void shouldMapMemberDTOtoMember() {
        //set roles
        Set<Role> expectedRoles = new HashSet<Role>();
        //add role
        expectedRoles.add(new Role(ERole.USER.toString()));
        //set permissions
        Set<Permission> expectedPermissions = new HashSet<>();
        //add permission
        expectedPermissions.add(new Permission(EPermission.CREATE_BOOK.toString()));
        //declare expected member object
        MemberDTO expected = new MemberDTO("memberID", "mail@mail.com", "username", "password", "name", "lastname", 20, expectedRoles, expectedPermissions);
        //declare actual member object
        Member actual = memberDTOMapper.mapToMember(expected);

        //check attributes
        Assertions.assertEquals(expected.getMemberId(), actual.getMemberId(), "Attribute memberID does not match");
        Assertions.assertEquals(expected.getName(), actual.getName(), "Attribute name does not match");
        Assertions.assertEquals(expected.getLastname(), actual.getLastname(), "Attribute lastname does not match");
        Assertions.assertEquals(expected.getEmail(), actual.getEmail(), "Attribute email does not match");
        Assertions.assertEquals(expected.getUsername(), actual.getUsername(), "Attribute username does not match");
        Assertions.assertEquals(expected.getPassword(), actual.getPassword(), "Attribute password does not match");
        Assertions.assertEquals(expected.getAge(), actual.getAge(), "Attribute age does not match");
        Assertions.assertEquals(expected.getRoles(), actual.getRoles(), "Attribute roles does not match");
        Assertions.assertEquals(expected.getPermissions(), actual.getPermissions(), "Attribute permissions does not match");
    }

    @Test
    public void shouldMapMemberToMemberDTOWhenNull() {
        Assertions.assertThrows(NullPointerException.class, () -> memberDTOMapper.mapToMemberDTO(null));
    }

    @Test
    public void shouldMapMemberDTOtoMemberWhenNull() {
        Assertions.assertThrows(NullPointerException.class, () -> memberDTOMapper.mapToMember(null));
    }
}
