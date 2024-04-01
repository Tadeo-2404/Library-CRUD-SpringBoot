package com.app.crud.model;

import com.app.crud.model.member.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class MemberModelTest {
    Member member;

    @BeforeEach
    public void setup() {
        //set roles
        Set<Role> roles = new HashSet<Role>();
        //add role
        roles.add(new Role(ERole.USER.toString()));
        //set permissions
        Set<Permission> permissions = new HashSet<>();
        //add permission
        permissions.add(new Permission(EPermission.CREATE_BOOK.toString()));
        //declare expected member object
        this.member = new Member("memberID", "mail@mail.com", "username", "password", "name", "lastname", 20, roles, permissions);
    }

    @Test
    public void testConstructor() {
        // Set up expected roles
        Set<Role> expectedRoles = new HashSet<>();
        expectedRoles.add(new Role(ERole.USER.toString()));

        // Set up expected permissions
        Set<Permission> expectedPermissions = new HashSet<>();
        expectedPermissions.add(new Permission(EPermission.CREATE_BOOK.toString()));

        // Create the Member object using the constructor
        Member expected = new Member("memberID", "mail@mail.com", "username", "password", "name", "lastname", 20, expectedRoles, expectedPermissions);

        // Assert that the Member object is not null
        Assertions.assertNotNull(expected, "Member object is null");

        // Assert that each field of the Member object is initialized correctly
        Assertions.assertEquals("memberID", expected.getMemberId(), "MemberId does not match");
        Assertions.assertEquals("mail@mail.com", expected.getEmail(), "Email does not match");
        Assertions.assertEquals("username", expected.getUsername(), "Username does not match");
        Assertions.assertEquals("password", expected.getPassword(), "Password does not match");
        Assertions.assertEquals("name", expected.getName(), "Name does not match");
        Assertions.assertEquals("lastname", expected.getLastname(), "Lastname does not match");
        Assertions.assertEquals(20, expected.getAge(), "Age does not match");

        // Assert that roles and permissions are initialized correctly
        Assertions.assertEquals(expectedRoles, expected.getRoles(), "Roles do not match");
        Assertions.assertEquals(expectedPermissions, expected.getPermissions(), "Permissions do not match");
    }

    @Test
    public void getMemberIdTest() {
        String expectedValue = "memberID";
        String actualValue = member.getMemberId();
        Assertions.assertEquals(expectedValue, actualValue, "MemberId does not match");
    }

    @Test
    public void getEmailTest() {
        String expectedValue = "mail@mail.com";
        String actualValue = member.getEmail();
        Assertions.assertEquals(expectedValue, actualValue, "Email does not match");
    }

    @Test
    public void getUsernameTest() {
        String expectedValue = "username";
        String actualValue = member.getUsername();
        Assertions.assertEquals(expectedValue, actualValue, "Username does not match");
    }

    @Test
    public void getPasswordTest() {
        String expectedValue = "password";
        String actualValue = member.getPassword();
        Assertions.assertEquals(expectedValue, actualValue, "Password does not match");
    }

    @Test
    public void getNameTest() {
        String expectedValue = "name";
        String actualValue = member.getName();
        Assertions.assertEquals(expectedValue, actualValue, "Name does not match");
    }

    @Test
    public void getLastnameTest() {
        String expectedValue = "lastname";
        String actualValue = member.getLastname();
        Assertions.assertEquals(expectedValue, actualValue, "Lastname does not match");
    }

    @Test
    public void getAgeTest() {
        int expectedValue = 20;
        int actualValue = member.getAge();
        Assertions.assertEquals(expectedValue, actualValue, "Age does not match");
    }

    @Test
    public void getRolesTest() {
        Set<Role> expectedValue = new HashSet<>();
        expectedValue.add(new Role(ERole.USER.toString()));
        Set<Role> actualValue = member.getRoles();
        Assertions.assertEquals(expectedValue, actualValue, "Roles do not match");
    }

    @Test
    public void getPermissionsTest() {
        Set<Permission> expectedValue = new HashSet<>();
        expectedValue.add(new Permission(EPermission.CREATE_BOOK.toString()));
        Set<Permission> actualValue = member.getPermissions();
        Assertions.assertEquals(expectedValue, actualValue, "Permissions do not match");
    }

    @Test
    public void setMemberIdTest() {
        String expectedValue = "newMemberID";
        member.setMemberId(expectedValue);
        String actualValue = member.getMemberId();
        Assertions.assertEquals(expectedValue, actualValue, "MemberId does not match after setting");
    }

    @Test
    public void setEmailTest() {
        String expectedValue = "newmail@mail.com";
        member.setEmail(expectedValue);
        String actualValue = member.getEmail();
        Assertions.assertEquals(expectedValue, actualValue, "Email does not match after setting");
    }

    @Test
    public void setUsernameTest() {
        String expectedValue = "newUsername";
        member.setUsername(expectedValue);
        String actualValue = member.getUsername();
        Assertions.assertEquals(expectedValue, actualValue, "Username does not match after setting");
    }

    @Test
    public void setPasswordTest() {
        String expectedValue = "newPassword";
        member.setPassword(expectedValue);
        String actualValue = member.getPassword();
        Assertions.assertEquals(expectedValue, actualValue, "Password does not match after setting");
    }

    @Test
    public void setNameTest() {
        String expectedValue = "newName";
        member.setName(expectedValue);
        String actualValue = member.getName();
        Assertions.assertEquals(expectedValue, actualValue, "Name does not match after setting");
    }

    @Test
    public void setLastnameTest() {
        String expectedValue = "newLastname";
        member.setLastname(expectedValue);
        String actualValue = member.getLastname();
        Assertions.assertEquals(expectedValue, actualValue, "Lastname does not match after setting");
    }

    @Test
    public void setAgeTest() {
        int expectedValue = 25;
        member.setAge(expectedValue);
        int actualValue = member.getAge();
        Assertions.assertEquals(expectedValue, actualValue, "Age does not match after setting");
    }

    @Test
    public void setRolesTest() {
        Set<Role> expectedValue = new HashSet<>();
        expectedValue.add(new Role(ERole.ADMIN.toString()));
        member.setRoles(expectedValue);
        Set<Role> actualValue = member.getRoles();
        Assertions.assertEquals(expectedValue, actualValue, "Roles do not match after setting");
    }

    @Test
    public void setPermissionsTest() {
        Set<Permission> expectedValue = new HashSet<>();
        expectedValue.add(new Permission(EPermission.DELETE_BOOK.toString()));
        member.setPermissions(expectedValue);
        Set<Permission> actualValue = member.getPermissions();
        Assertions.assertEquals(expectedValue, actualValue, "Permissions do not match after setting");
    }

    @AfterEach
    public void teardown() {
        this.member = null;
    }
}
