package com.ksiegarnia.ksiegarniaspring.repositories;

import com.ksiegarnia.ksiegarniaspring.entities.Selling;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SellingRepository extends CrudRepository<Selling, Integer>, PagingAndSortingRepository<Selling, Integer> {


    @Query("select count(*) from Selling p where p.id = ?1")
    Integer checkIfExist(Integer id);

}
