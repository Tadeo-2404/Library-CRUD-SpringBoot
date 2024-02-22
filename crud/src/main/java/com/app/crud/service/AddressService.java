package com.app.crud.service;
import com.app.crud.model.address.Address;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface AddressService {
    public List<Address> getAddresses();
    public Address getByID(String ID);
    public List<Address> getAddressesByStreet(String street);
    public List<Address> getAddressesByCity(String city);
    public List<Address> getAddressesByState(String state);
    public List<Address> getAddressesByPostalCode(String postalCode);

    //add address
    public ResponseEntity<Object>  addAddress(Address address);
}
