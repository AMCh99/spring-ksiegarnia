package com.ksiegarnia.ksiegarniaspring.services;

import com.ksiegarnia.ksiegarniaspring.entities.SoldBooks;
import com.ksiegarnia.ksiegarniaspring.repositories.SoldBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

public class SoldBooksServiceImpl implements SoldBooksServiceInterface{

    @Autowired
    SoldBooksRepository soldBooksRepository;


    @Override
    public Iterable<SoldBooks> listAllSoldBooks() {
        return soldBooksRepository.findAll();
    }

    @Override
    public Optional<SoldBooks> getSoldBooksById(int id) {
        return soldBooksRepository.findById(id);
    }

    @Override
    public SoldBooks saveSoldBook(SoldBooks soldBooks) {
        return soldBooksRepository.save(soldBooks);
    }

    @Override
    public void deleteSoldBook(int id) {
        soldBooksRepository.deleteById(id);

    }

    @Override
    public Boolean checkIfExist(int id) {
        return soldBooksRepository.checkIfExist(id) > 0;
    }

    @Override
    public Iterable<SoldBooks> listAllSoldBooksPaging(Integer pageNr, Integer howManyOnPage) {
        return soldBooksRepository.findAll(PageRequest.of(pageNr,howManyOnPage));
    }
}
