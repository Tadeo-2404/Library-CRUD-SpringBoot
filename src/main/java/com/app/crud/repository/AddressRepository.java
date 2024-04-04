package com.app.crud.repository;

import com.app.crud.model.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, String> {
    List<Address> findByStreet(String street);
    List<Address> findByCity(String city);
    List<Address> findByState(String state);
    List<Address> findByPostalCode(String postalCode);
    //two params
    List<Address> findByStreetAndCity(String street, String city);
    List<Address> findByStreetAndState(String street, String state);
    List<Address> findByStreetAndPostalCode(String street, String postalCode);
    List<Address> findByCityAndState(String city, String state);
    List<Address> findByCityAndPostalCode(String city, String postalCode);
    List<Address> findByStateAndPostalCode(String state, String postalCode);
    //three params
    List<Address> findByStreetAndCityAndState(String street, String city, String state);
    List<Address> findByStreetAndCityAndPostalCode(String street, String city, String postalCode);
    List<Address> findByStreetAndStateAndPostalCode(String street, String state, String postalCode);
    List<Address> findByCityAndStateAndPostalCode(String city, String state, String postalCode);
    //four params
    List<Address> findByStreetAndCityAndStateAndPostalCode(String street, String city, String state, String postalCode);

}
