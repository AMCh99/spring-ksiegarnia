package com.ksiegarnia.ksiegarniaspring.services;

import com.ksiegarnia.ksiegarniaspring.entities.Addresses;
import com.ksiegarnia.ksiegarniaspring.repositories.AddressesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressesServiceImpl implements AddressesServiceInterface{

    @Autowired
    private AddressesRepository addressesRepository;

    @Override
    public Iterable<Addresses> listAllAddresses() {
        return addressesRepository.findAll();
    }

    @Override
    public Optional<Addresses> getAddressById(int id) {
        return addressesRepository.findById(id);
    }

    @Override
    public Addresses saveAddress(Addresses addresses) {
        return addressesRepository.save(addresses);
    }

    @Override
    public void deleteAddress(int id) {
        addressesRepository.deleteById(id);

    }

    @Override
    public Boolean checkIfExist(int id)  {
        return addressesRepository.checkIfExist(id) > 0;
    }

    @Override
    public Iterable<Addresses> listAllAddressesPaging(Integer pageNr, Integer howManyOnPage) {
        return addressesRepository.findAll(PageRequest.of(pageNr,howManyOnPage));
    }
}
