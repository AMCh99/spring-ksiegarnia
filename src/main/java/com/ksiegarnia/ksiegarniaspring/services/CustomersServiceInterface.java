package com.ksiegarnia.ksiegarniaspring.services;


import com.ksiegarnia.ksiegarniaspring.entities.Customers;

import java.util.Optional;


public interface CustomersServiceInterface {

    Iterable<Customers> listAllCustomers();

    Optional<Customers> getCustomerById(int id);

    Customers saveCustomer(Customers customers);

    void deleteCustomer(int id);

    Boolean checkIfExist(int id);

    Iterable<Customers> listAllCustomersPaging(Integer pageNr, Integer howManyOnPage);
}
