package com.ksiegarnia.ksiegarniaspring.services;

import com.ksiegarnia.ksiegarniaspring.entities.Books;
import com.ksiegarnia.ksiegarniaspring.repositories.BooksRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

@Service
public class BooksServiceImpl implements BooksServiceInterface{

    @Autowired
    private BooksRepository booksRepository;

    @Override
    public Iterable<Books> listAllBooks() {
        return booksRepository.findAll();
    }

    @Override
    public Optional<Books> getBookById(int id) {
        return booksRepository.findById(id);
    }

    @Override
    public Books saveBook(Books books) {
        return booksRepository.save(books);
    }

    @Override
    public void deleteBook(int id) {
        booksRepository.deleteById(id);
    }

    @Override
    public Boolean checkIfExist(int id) {
        return booksRepository.checkIfExist(id) > 0;
    }


    @Override
    public Iterable<Books> listAllBooksPaging(Integer pageNr, Integer howManyOnPage) {
        return booksRepository.findAll(PageRequest.of(pageNr,howManyOnPage));
    }
}
