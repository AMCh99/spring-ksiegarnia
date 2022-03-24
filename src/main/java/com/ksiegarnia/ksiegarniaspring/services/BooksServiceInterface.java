package com.ksiegarnia.ksiegarniaspring.services;

import com.ksiegarnia.ksiegarniaspring.entities.Books;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface BooksServiceInterface {


    Iterable<Books> listAllBooks();

    Optional<Books> getBookById(int id);

    Books saveBook(Books books);

    void deleteBook(int id);

    Boolean checkIfExist(int id);

    Iterable<Books> listAllBooksPaging(Integer pageNr, Integer howManyOnPage);
}
