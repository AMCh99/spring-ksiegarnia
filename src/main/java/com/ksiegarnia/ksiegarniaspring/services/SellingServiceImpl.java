package com.ksiegarnia.ksiegarniaspring.services;

import com.ksiegarnia.ksiegarniaspring.entities.Selling;
import com.ksiegarnia.ksiegarniaspring.repositories.SellingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SellingServiceImpl implements SellingsServiceInterface{

    @Autowired
    private SellingRepository sellingRepository;

    @Override
    public Iterable<Selling> listAllSellings() {
        return sellingRepository.findAll();
    }

    @Override
    public Optional<Selling> getSellingById(int id) {
        return sellingRepository.findById(id);
    }

    @Override
    public Selling saveSelling(Selling selling) {
        return sellingRepository.save(selling);
    }

    @Override
    public void deleteSelling(int id) {
        sellingRepository.deleteById(id);
    }

    @Override
    public Boolean checkIfExist(int id) {
        return sellingRepository.checkIfExist(id) > 0;
    }

    @Override
    public Iterable<Selling> listAllSellingPaging(Integer pageNr, Integer howManyOnPage) {
        return sellingRepository.findAll(PageRequest.of(pageNr,howManyOnPage));
    }
}
