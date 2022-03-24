package com.ksiegarnia.ksiegarniaspring.services;

import com.ksiegarnia.ksiegarniaspring.entities.Addresses;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface AddressesServiceInterface {

    Iterable<Addresses> listAllAddresses();

    Optional<Addresses> getAddressById(int id);

    Addresses saveAddress(Addresses addresses);

    void deleteAddress(int id);

    Boolean checkIfExist(int id);

    Iterable<Addresses> listAllAddressesPaging(Integer pageNr, Integer howManyOnPage);
}