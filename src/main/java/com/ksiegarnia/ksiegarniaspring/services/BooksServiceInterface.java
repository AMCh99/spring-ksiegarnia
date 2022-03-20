package com.ksiegarnia.ksiegarniaspring.services;

import com.ksiegarnia.ksiegarniaspring.entities.Books;
import java.util.Optional;

public interface BooksServiceInterface {

    Iterable<Books> listAllBooks();

    Optional<Books> getBookById(int id);

    Books saveBook(Books books);

    void deleteBook(int id);

    Boolean checkIfExist(int id);

    Iterable<Books> listAllBooksPaging(Integer pageNr, Integer howManyOnPage);
}
