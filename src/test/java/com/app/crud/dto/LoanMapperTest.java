package com.app.crud.dto;

import com.app.crud.dto.LoanDTO;
import com.app.crud.dto.MemberDTO;
import com.app.crud.dto.mapper.LoanDTOMapper;
import com.app.crud.model.loan.Loan;
import com.app.crud.model.member.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class LoanMapperTest {
    private LoanDTOMapper loanDTOMapper;

    @BeforeEach
    public void setup() {
        loanDTOMapper = new LoanDTOMapper();
    }

    @Test
    public void shouldMapLoanToLoanDTO() {
        //set roles
        Set<Role> expectedRoles = new HashSet<Role>();
        //add role
        expectedRoles.add(new Role(ERole.USER.toString()));

        //set permissions
        Set<Permission> expectedPermissions = new HashSet<>();
        //add permission
        expectedPermissions.add(new Permission(EPermission.CREATE_BOOK.toString()));

        //declare expected member object
        MemberDTO expectedMember = new MemberDTO("memberID", "mail@mail.com", "username", "password", "name", "lastname", 20, expectedRoles, expectedPermissions);

        LocalDateTime fixedDate = LocalDateTime.of(2024, 4, 3, 17, 51, 49);

        //declare expected loan
        LoanDTO expected = new LoanDTO("loanID", fixedDate, fixedDate.plusHours(1), expectedMember);

        //obtain actual loan
        Loan actual = loanDTOMapper.mapToLoan(expected);

        //check loan attributes
        Assertions.assertNotNull(actual, "Loan object is null");
        Assertions.assertNotNull(actual.getMember(), "Member is null");
        Assertions.assertNotNull(actual.getID(), "ID is null");
        Assertions.assertNotNull(actual.getDateLimit(), "DateLimit is null");
        Assertions.assertNotNull(actual.getDateBorrow(), "DateBorrow is null");
        Assertions.assertEquals(expected.getDateBorrow(), actual.getDateBorrow(), "DateBorrow does not match");
        Assertions.assertEquals(expected.getDateLimit(), actual.getDateLimit(), "DateBorrow does not match");

        //check loan's member attributes
        Assertions.assertEquals(expected.getMemberDTO().getMemberId(), actual.getMember().getMemberId(), "Attribute memberID does not match");
        Assertions.assertEquals(expected.getMemberDTO().getName(), actual.getMember().getName(), "Attribute name does not match");
        Assertions.assertEquals(expected.getMemberDTO().getLastname(), actual.getMember().getLastname(), "Attribute lastname does not match");
        Assertions.assertEquals(expected.getMemberDTO().getEmail(), actual.getMember().getEmail(), "Attribute email does not match");
        Assertions.assertEquals(expected.getMemberDTO().getUsername(), actual.getMember().getUsername(), "Attribute username does not match");
        Assertions.assertEquals(expected.getMemberDTO().getPassword(), actual.getMember().getPassword(), "Attribute password does not match");
        Assertions.assertEquals(expected.getMemberDTO().getAge(), actual.getMember().getAge(), "Attribute age does not match");
        Assertions.assertEquals(expected.getMemberDTO().getRoles(), actual.getMember().getRoles(), "Attribute roles does not match");
        Assertions.assertEquals(expected.getMemberDTO().getPermissions(), actual.getMember().getPermissions(), "Attribute permissions does not match");
    }

    @Test
    public void shouldMapLoanToLoanDTOWhenNull() {
        Assertions.assertThrows(NullPointerException.class, () -> loanDTOMapper.mapToLoan(null));
    }

    @Test
    public void shouldMapLoanToLoanDTOWhenMemberNull() {
        LoanDTO expected = new LoanDTO("loanID", LocalDateTime.now(), LocalDateTime.now(), null);
        Assertions.assertThrows(NullPointerException.class, () -> loanDTOMapper.mapToLoan(expected));
    }

    @Test
    public void shouldMapLoanDTOToLoanWhenMemberNull() {
        Loan expected = new Loan("loanID", LocalDateTime.now(), LocalDateTime.now(), null);
        Assertions.assertThrows(NullPointerException.class, () -> loanDTOMapper.mapToLoanDTO(expected));
    }

    @Test
    public void shouldMapLoanDTOtoLoanWhenNull() {
        Assertions.assertThrows(NullPointerException.class, () -> loanDTOMapper.mapToLoanDTO(null));
    }

    @Test
    public void shouldMapLoanDTOtoLoan() {
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

        LocalDateTime fixedDate = LocalDateTime.of(2024, 4, 3, 17, 51, 49);

        //declare expected loan
        Loan expected = new Loan("loanID", fixedDate, fixedDate.plusHours(1), expectedMember);

        //obtain actual loan
        LoanDTO actual = loanDTOMapper.mapToLoanDTO(expected);

        //check loan attributes
        Assertions.assertNotNull(actual, "Loan object is null");
        Assertions.assertNotNull(actual.getMemberDTO(), "Member is null");
        Assertions.assertNotNull(actual.getID(), "ID is null");
        Assertions.assertNotNull(actual.getDateLimit(), "DateLimit is null");
        Assertions.assertNotNull(actual.getDateBorrow(), "DateBorrow is null");
        Assertions.assertEquals(expected.getDateBorrow(), actual.getDateBorrow(), "DateBorrow does not match");
        Assertions.assertEquals(expected.getDateLimit(), actual.getDateLimit(), "DateLimit does not match");

        //check loan's member attributes
        Assertions.assertEquals(expected.getMember().getMemberId(), actual.getMemberDTO().getMemberId(), "Attribute memberID does not match");
        Assertions.assertEquals(expected.getMember().getName(), actual.getMemberDTO().getName(), "Attribute name does not match");
        Assertions.assertEquals(expected.getMember().getLastname(), actual.getMemberDTO().getLastname(), "Attribute lastname does not match");
        Assertions.assertEquals(expected.getMember().getEmail(), actual.getMemberDTO().getEmail(), "Attribute email does not match");
        Assertions.assertEquals(expected.getMember().getUsername(), actual.getMemberDTO().getUsername(), "Attribute username does not match");
        Assertions.assertEquals(expected.getMember().getPassword(), actual.getMemberDTO().getPassword(), "Attribute password does not match");
        Assertions.assertEquals(expected.getMember().getAge(), actual.getMemberDTO().getAge(), "Attribute age does not match");
        Assertions.assertEquals(expected.getMember().getRoles(), actual.getMemberDTO().getRoles(), "Attribute roles does not match");
        Assertions.assertEquals(expected.getMember().getPermissions(), actual.getMemberDTO().getPermissions(), "Attribute permissions does not match");
    }
}
