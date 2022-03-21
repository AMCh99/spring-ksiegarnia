package com.ksiegarnia.ksiegarniaspring.services;

import com.ksiegarnia.ksiegarniaspring.entities.Selling;

import java.util.Optional;

public interface SellingsServiceInterface {

    Iterable<Selling> listAllSellings();

    Optional<Selling> getSellingById(int id);

    Selling saveSelling(Selling selling);

    void deleteSelling(int id);

    Boolean checkIfExist(int id);

    Iterable<Selling> listAllSellingPaging(Integer pageNr, Integer howManyOnPage);
}
