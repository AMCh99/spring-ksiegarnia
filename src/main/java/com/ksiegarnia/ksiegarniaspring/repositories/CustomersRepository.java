package com.ksiegarnia.ksiegarniaspring.repositories;



import com.ksiegarnia.ksiegarniaspring.entities.Customers;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends CrudRepository<Customers, Integer>, PagingAndSortingRepository<Customers, Integer>{


    @Query("select count(*) from Books p where p.id = ?1")
    Integer checkIfExist(Integer id);

}