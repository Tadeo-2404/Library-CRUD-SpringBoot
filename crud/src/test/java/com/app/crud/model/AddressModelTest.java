package com.app.crud.model;

import com.app.crud.model.address.Address;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AddressModelTest {
    Address address;

    @BeforeEach
    public void setup() {
        this.address = new Address("addressId", "street", "city", "state", "postalCode");
    }

    @Test
    public void constructorTest() {
        String addressId = "addressId";
        String street = "street";
        String city = "city";
        String state = "state";
        String postalCode = "postalCode";
        Address actual = new Address(addressId, street, city, state, postalCode);

        Assertions.assertNotNull(actual, "Address object is null");
        Assertions.assertEquals(addressId, actual.getAddress_id(), "Constructor did not initialize addressId correctly");
        Assertions.assertEquals(street, actual.getStreet(), "Constructor did not initialize street correctly");
        Assertions.assertEquals(city, actual.getCity(), "Constructor did not initialize city correctly");
        Assertions.assertEquals(state, actual.getState(), "Constructor did not initialize state correctly");
        Assertions.assertEquals(postalCode, actual.getPostalCode(), "Constructor did not initialize postalCode correctly");
    }

    @Test
    public void getAddressID() {
        String expectedValue = "addressId";
        String actualValue = this.address.getAddress_id();
        Assertions.assertEquals(expectedValue, actualValue, "AddressId does not match");
    }

    @Test
    public void getStreet() {
        String expectedValue = "street";
        String actualValue = this.address.getStreet();
        Assertions.assertEquals(expectedValue, actualValue, "Street does not match");
    }

    @Test
    public void getCity() {
        String expectedValue = "city";
        String actualValue = this.address.getCity();
        Assertions.assertEquals(expectedValue, actualValue, "City does not match");
    }

    @Test
    public void getState() {
        String expectedValue = "state";
        String actualValue = this.address.getState();
        Assertions.assertEquals(expectedValue, actualValue, "State does not match");
    }

    @Test
    public void getPostalCode() {
        String expectedValue = "postalCode";
        String actualValue = this.address.getPostalCode();
        Assertions.assertEquals(expectedValue, actualValue, "PostalCode does not match");
    }

    @Test
    public void setAddressID() {
        String expectedValue = "newAddressId";
        this.address.setAddress_id(expectedValue);
        String actualValue = this.address.getAddress_id();
        Assertions.assertEquals(expectedValue, actualValue, "AddressId does not match after setting");
    }

    @Test
    public void setStreet() {
        String expectedValue = "newStreet";
        this.address.setStreet(expectedValue);
        String actualValue = this.address.getStreet();
        Assertions.assertEquals(expectedValue, actualValue, "Street does not match after setting");
    }

    @Test
    public void setCity() {
        String expectedValue = "newCity";
        this.address.setCity(expectedValue);
        String actualValue = this.address.getCity();
        Assertions.assertEquals(expectedValue, actualValue, "City does not match after setting");
    }

    @Test
    public void setState() {
        String expectedValue = "newState";
        this.address.setState(expectedValue);
        String actualValue = this.address.getState();
        Assertions.assertEquals(expectedValue, actualValue, "State does not match after setting");
    }

    @Test
    public void setPostalCode() {
        String expectedValue = "newPostalCode";
        this.address.setPostalCode(expectedValue);
        String actualValue = this.address.getPostalCode();
        Assertions.assertEquals(expectedValue, actualValue, "PostalCode does not match after setting");
    }

    @AfterEach
    public void teardown() {
        this.address = null;
    }
}
