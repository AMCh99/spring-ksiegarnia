package com.ksiegarnia.ksiegarniaspring.services;


import com.ksiegarnia.ksiegarniaspring.entities.Customers;
import com.ksiegarnia.ksiegarniaspring.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Service
public class CustomersServiceImpl implements CustomersServiceInterface{

    @Autowired
    private CustomersRepository customersRepository;


    @Override
    public Iterable<Customers> listAllCustomers() {
        return customersRepository.findAll();
    }

    @Override
    public Optional<Customers> getCustomerById(int id) {
        return customersRepository.findById(id);
    }

    @Override
    @ResponseBody
    public Customers saveCustomer(Customers customers) {
        return customersRepository.save(customers);
    }

    @Override
    public void deleteCustomer(int id) {
        customersRepository.deleteById(id);

    }

    @Override
    public Boolean checkIfExist(int id) {
        return customersRepository.checkIfExist(id) > 0;
    }

    @Override
    public Iterable<Customers> listAllCustomersPaging(Integer pageNr, Integer howManyOnPage) {
        return customersRepository.findAll(PageRequest.of(pageNr,howManyOnPage));
    }
}
