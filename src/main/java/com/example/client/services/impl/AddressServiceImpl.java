package com.example.client.services.impl;

import com.example.client.entities.Address;
import com.example.client.entities.Group;
import com.example.client.repositories.AddressRepository;
import com.example.client.repositories.GroupRepository;
import com.example.client.services.AddressService;
import com.example.client.services.GroupService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    public void deleteAddress(Long addressId) {
        Address address= addressRepository.findById(addressId).orElseThrow(RuntimeException::new);
        addressRepository.delete(address);
    }

    public Optional<Address> getAddressById(Long addressId) {
        return addressRepository.findById(addressId);
    }
}
