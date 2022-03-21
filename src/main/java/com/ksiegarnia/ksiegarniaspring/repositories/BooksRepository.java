package com.ksiegarnia.ksiegarniaspring.repositories;

import com.ksiegarnia.ksiegarniaspring.entities.Books;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface BooksRepository extends CrudRepository<Books, Integer>, PagingAndSortingRepository<Books, Integer>{


    @Query("select count(*) from Books p where p.id = ?1")
    Integer checkIfExist(Integer id);

}
