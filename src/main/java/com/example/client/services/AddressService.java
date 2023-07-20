package com.example.client.services;

import com.example.client.entities.Address;
import com.example.client.entities.Group;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    List<Address> getAllAddresses();
    Address saveAddress(Address address);
    void deleteAddress(Long addressId);
    Optional<Address> getAddressById(Long addressId);
}
