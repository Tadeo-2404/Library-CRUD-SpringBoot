package com.app.crud.model;

import com.app.crud.model.loan.Loan;
import com.app.crud.model.member.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class LoanModelTest {
    Loan loan;

    @BeforeEach
    public void setup() {
        //set roles
        Set<Role> expectedRoles = new HashSet<Role>();
        //add role
        expectedRoles.add(new Role(ERole.USER.toString()));
        //set permissions
        Set<Permission> expectedPermissions = new HashSet<>();
        //add permission
        expectedPermissions.add(new Permission(EPermission.CREATE_BOOK.toString()));
        //declare expected member object
        Member expectedMember = new Member("memberID", "mail@mail.com", "username", "password", "name", "lastname", 20, expectedRoles, expectedPermissions);
        //declare expected loan
        loan = new Loan("loanID", LocalDateTime.now(), LocalDateTime.now(), expectedMember);
    }

    @Test
    public void testConstructor() {
        // Get actual values from the loan object
        String actualLoanId = loan.getID();
        LocalDateTime actualStartDate = loan.getDateBorrow();
        LocalDateTime actualEndDate = loan.getDateLimit();
        Member actualMember = loan.getMember();

        // Assert that each field of the Loan object is initialized correctly
        Assertions.assertEquals("loanID", actualLoanId, "LoanId does not match");
        Assertions.assertNotNull(actualStartDate, "StartDate is null");
        Assertions.assertNotNull(actualEndDate, "EndDate is null");
        Assertions.assertEquals("memberID", actualMember.getMemberId(), "MemberId does not match");
        Assertions.assertEquals("mail@mail.com", actualMember.getEmail(), "Email does not match");
        Assertions.assertEquals("username", actualMember.getUsername(), "Username does not match");
        Assertions.assertEquals("password", actualMember.getPassword(), "Password does not match");
        Assertions.assertEquals("name", actualMember.getName(), "Name does not match");
        Assertions.assertEquals("lastname", actualMember.getLastname(), "Lastname does not match");
        Assertions.assertEquals(20, actualMember.getAge(), "Age does not match");
        Assertions.assertEquals(1, actualMember.getRoles().size(), "Number of roles does not match");
        Assertions.assertEquals(1, actualMember.getPermissions().size(), "Number of permissions does not match");
    }

    @Test
    public void getLoanIdTest() {
        String expectedValue = "loanID";
        String actualValue = loan.getID();
        Assertions.assertEquals(expectedValue, actualValue, "LoanId does not match");
    }

    @Test
    public void getDateBorrowTest() {
        LocalDateTime expectedValue = LocalDateTime.now();
        LocalDateTime actualValue = loan.getDateBorrow();
        Assertions.assertEquals(expectedValue, actualValue, "DateBorrow does not match");
    }

    @Test
    public void getDateLimitTest() {
        LocalDateTime expectedValue = LocalDateTime.now();
        LocalDateTime actualValue = loan.getDateLimit();
        Assertions.assertEquals(expectedValue, actualValue, "DateLimit does not match");
    }

    @Test
    public void getMemberTest() {
        //set roles
        Set<Role> expectedRoles = new HashSet<Role>();
        //add role
        expectedRoles.add(new Role(ERole.USER.toString()));
        //set permissions
        Set<Permission> expectedPermissions = new HashSet<>();
        //add permission
        expectedPermissions.add(new Permission(EPermission.CREATE_BOOK.toString()));
        //declare expected member object
        Member actualMember = new Member("memberID", "mail@mail.com", "username", "password", "name", "lastname", 20, expectedRoles, expectedPermissions);
        //declare actual loan
        Loan actualLoan = new Loan("loanID", LocalDateTime.now(), LocalDateTime.now(), actualMember);
        //declare expected loan
        Member expectedMember = loan.getMember();

        //check loan's member attributes
        Assertions.assertEquals(actualLoan.getMember().getMemberId(), expectedMember.getMemberId(), "Attribute memberID does not match");
        Assertions.assertEquals(actualLoan.getMember().getName(), expectedMember.getName(), "Attribute name does not match");
        Assertions.assertEquals(actualLoan.getMember().getLastname(), expectedMember.getLastname(), "Attribute lastname does not match");
        Assertions.assertEquals(actualLoan.getMember().getEmail(), expectedMember.getEmail(), "Attribute email does not match");
        Assertions.assertEquals(actualLoan.getMember().getUsername(), expectedMember.getUsername(), "Attribute username does not match");
        Assertions.assertEquals(actualLoan.getMember().getPassword(), expectedMember.getPassword(), "Attribute password does not match");
        Assertions.assertEquals(actualLoan.getMember().getAge(), expectedMember.getAge(), "Attribute age does not match");
        Assertions.assertEquals(actualLoan.getMember().getRoles(), expectedMember.getRoles(), "Attribute roles does not match");
        Assertions.assertEquals(actualLoan.getMember().getPermissions(), expectedMember.getPermissions(), "Attribute permissions does not match");
    }

    @Test
    public void setLoanIdTest() {
        String expectedValue = "newLoanID";
        loan.setID(expectedValue);
        String actualValue = loan.getID();
        Assertions.assertEquals(expectedValue, actualValue, "LoanId does not match after setting");
    }

    @Test
    public void setDateBorrowTest() {
        LocalDateTime expectedValue = LocalDateTime.now();
        loan.setDateBorrow(expectedValue);
        LocalDateTime actualValue = loan.getDateBorrow();
        Assertions.assertEquals(expectedValue, actualValue, "DateBorrow does not match after setting");
    }

    @Test
    public void setDateLimitTest() {
        LocalDateTime expectedValue = LocalDateTime.now();
        loan.setDateLimit(expectedValue);
        LocalDateTime actualValue = loan.getDateLimit();
        Assertions.assertEquals(expectedValue, actualValue, "DateLimit does not match after setting");
    }

    @Test
    public void setMemberTest() {
        // Set up new expected roles
        Set<Role> newExpectedRoles = new HashSet<>();
        newExpectedRoles.add(new Role(ERole.ADMIN.toString()));

        // Set up new expected permissions
        Set<Permission> newExpectedPermissions = new HashSet<>();
        newExpectedPermissions.add(new Permission(EPermission.DELETE_BOOK.toString()));

        // Create the new expected member object
        Member newExpectedMember = new Member("newMemberID", "newmail@mail.com", "newUsername", "newPassword", "newName", "newLastname", 25, newExpectedRoles, newExpectedPermissions);

        // Set the new member for the loan
        loan.setMember(newExpectedMember);

        // Get the actual member from the loan
        Member actualMember = loan.getMember();

        // Assert that each attribute of the new member object matches the corresponding attribute of the actual member object
        Assertions.assertEquals(newExpectedMember.getMemberId(), actualMember.getMemberId(), "MemberId does not match after setting");
        Assertions.assertEquals(newExpectedMember.getEmail(), actualMember.getEmail(), "Email does not match after setting");
        Assertions.assertEquals(newExpectedMember.getUsername(), actualMember.getUsername(), "Username does not match after setting");
        Assertions.assertEquals(newExpectedMember.getPassword(), actualMember.getPassword(), "Password does not match after setting");
        Assertions.assertEquals(newExpectedMember.getName(), actualMember.getName(), "Name does not match after setting");
        Assertions.assertEquals(newExpectedMember.getLastname(), actualMember.getLastname(), "Lastname does not match after setting");
        Assertions.assertEquals(newExpectedMember.getAge(), actualMember.getAge(), "Age does not match after setting");
        Assertions.assertEquals(newExpectedMember.getRoles(), actualMember.getRoles(), "Roles do not match after setting");
        Assertions.assertEquals(newExpectedMember.getPermissions(), actualMember.getPermissions(), "Permissions do not match after setting");
    }

    @AfterEach
    public void teardown() {
        this.loan = null;
    }
}
