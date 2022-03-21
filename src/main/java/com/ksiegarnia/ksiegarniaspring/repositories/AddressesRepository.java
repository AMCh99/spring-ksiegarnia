package com.ksiegarnia.ksiegarniaspring.repositories;

import com.ksiegarnia.ksiegarniaspring.entities.Addresses;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AddressesRepository extends CrudRepository<Addresses, Integer>, PagingAndSortingRepository<Addresses, Integer> {


    @Query("select count(*) from Addresses p where p.id = ?1")
    Integer checkIfExist(Integer id);

}
