package com.ksiegarnia.ksiegarniaspring.services;

import com.ksiegarnia.ksiegarniaspring.entities.SoldBooks;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface SoldBooksServiceInterface {

    Iterable<SoldBooks> listAllSoldBooks();

    Optional<SoldBooks> getSoldBooksById(int id);

    SoldBooks saveSoldBook(SoldBooks soldBooks);

    void deleteSoldBook(int id);

    Boolean checkIfExist(int id);

    Iterable<SoldBooks> listAllSoldBooksPaging(Integer pageNr, Integer howManyOnPage);
}
