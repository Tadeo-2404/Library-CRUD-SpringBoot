package com.app.crud.repository;

import com.app.crud.model.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, String> {
    List<Address> findByStreet(String street);
    List<Address> findByCity(String city);
    List<Address> findByState(String state);
    List<Address> findByPostalCode(String postalCode);
}
