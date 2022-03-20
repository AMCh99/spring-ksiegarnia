package com.ksiegarnia.ksiegarniaspring.services;

import com.ksiegarnia.ksiegarniaspring.entities.Books;
import com.ksiegarnia.ksiegarniaspring.repositories.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

@Service
public class BooksServiceImpl implements BooksServiceInterface{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Iterable<Books> listAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Books> getBookById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public Books saveBook(Books books) {
        return bookRepository.save(books);
    }

    @Override
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Boolean checkIfExist(int id) {
        return bookRepository.checkIfExist(id) > 0;
    }



    @Override
    public Iterable<Books> listAllBooksPaging(Integer pageNr, Integer howManyOnPage) {
        return bookRepository.findAll(PageRequest.of(pageNr,howManyOnPage));
    }
}
