package com.ksiegarnia.ksiegarniaspring.repositories;

import com.ksiegarnia.ksiegarniaspring.entities.SoldBooks;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoldBooksRepository extends CrudRepository<SoldBooks, Integer>, PagingAndSortingRepository<SoldBooks, Integer> {


    @Query("select count(*) from SoldBooks p where p.id = ?1")
    Integer checkIfExist(Integer id);

}
