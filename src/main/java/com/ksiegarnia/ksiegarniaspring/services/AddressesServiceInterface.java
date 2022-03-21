package com.ksiegarnia.ksiegarniaspring.services;

import com.ksiegarnia.ksiegarniaspring.entities.Addresses;
import java.util.Optional;

public interface AddressesServiceInterface {

    Iterable<Addresses> listAllAddresses();

    Optional<Addresses> getAddressById(int id);

    Addresses saveAddress(Addresses addresses);

    void deleteAddress(int id);

    Boolean checkIfExist(int id);

    Iterable<Addresses> listAllAddressesPaging(Integer pageNr, Integer howManyOnPage);
}