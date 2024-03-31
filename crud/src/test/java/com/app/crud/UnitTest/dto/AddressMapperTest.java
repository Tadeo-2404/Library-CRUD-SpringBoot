package com.app.crud.UnitTest.dto;

import com.app.crud.dto.AddressDTO;
import com.app.crud.dto.mapper.AddressDTOMapper;
import com.app.crud.model.address.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AddressMapperTest {
    AddressDTOMapper addressDTOMapper;

    @BeforeEach
    public void setup() {
        addressDTOMapper = new AddressDTOMapper();
    }

    protected boolean isNotEmptyString(String str) {
        return (str != null && !str.trim().isEmpty());
    }

    @Test
    public void shouldMapAddressToAddressDTO() {
        //declare expected object
        Address expected = new Address("ID", "street", "city", "state" ,"postalCode");
        //declare mapped object
        AddressDTO actual = addressDTOMapper.mapToAddressDTO(expected);

        Assertions.assertNotNull(actual, "AddressDTO is null");
        //check if attributes are not empty/null
        Assertions.assertTrue(isNotEmptyString(actual.getAddress_id()), "addressId must not be empty");
        Assertions.assertTrue(isNotEmptyString(actual.getStreet()), "street must not be empty");
        Assertions.assertTrue(isNotEmptyString(actual.getCity()), "city must not be empty");
        Assertions.assertTrue(isNotEmptyString(actual.getStreet()), "state must not be empty");
        Assertions.assertTrue(isNotEmptyString(actual.getPostalCode()), "postalCode must not be empty");

        //check if attributes are equal to the expected
        Assertions.assertEquals(expected.getAddress_id(), actual.getAddress_id(), "addressId does not match");
        Assertions.assertEquals(expected.getStreet(), actual.getStreet(), "street does not match");
        Assertions.assertEquals(expected.getCity(), actual.getCity(), "city does not match");
        Assertions.assertEquals(expected.getState(), actual.getState(), "state does not match");
        Assertions.assertEquals(expected.getPostalCode(), actual.getPostalCode(), "addressId does not match");
    }

    @Test
    public void shouldMapAddressDTOtoAddress() {
        //declare expected object
        AddressDTO expected = new AddressDTO("ID", "street", "city", "state" ,"postalCode");
        //declare mapped object
        Address actual = addressDTOMapper.mapToAddress(expected);

        Assertions.assertNotNull(actual, "Address is null");
        //check if attributes are not empty/null
        Assertions.assertTrue(isNotEmptyString(actual.getAddress_id()), "addressId must not be empty");
        Assertions.assertTrue(isNotEmptyString(actual.getStreet()), "street must not be empty");
        Assertions.assertTrue(isNotEmptyString(actual.getCity()), "city must not be empty");
        Assertions.assertTrue(isNotEmptyString(actual.getStreet()), "state must not be empty");
        Assertions.assertTrue(isNotEmptyString(actual.getPostalCode()), "postalCode must not be empty");

        //check if attributes are equal to the expected
        Assertions.assertEquals(expected.getAddress_id(), actual.getAddress_id(), "addressId does not match");
        Assertions.assertEquals(expected.getStreet(), actual.getStreet(), "street does not match");
        Assertions.assertEquals(expected.getCity(), actual.getCity(), "city does not match");
        Assertions.assertEquals(expected.getState(), actual.getState(), "state does not match");
        Assertions.assertEquals(expected.getPostalCode(), actual.getPostalCode(), "addressId does not match");
    }

    @Test
    public void shouldMapAddressToAddressDTOWhenNull() {
        Assertions.assertThrows(NullPointerException.class, () -> addressDTOMapper.mapToAddressDTO(null));
    }

    @Test
    public void shouldMapAddressDTOtoAddressWhenNull() {
        Assertions.assertThrows(NullPointerException.class, () -> addressDTOMapper.mapToAddress(null));
    }
}
