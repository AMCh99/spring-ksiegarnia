package com.ksiegarnia.ksiegarniaspring.controllers;

import com.ksiegarnia.ksiegarniaspring.entities.Books;
import com.ksiegarnia.ksiegarniaspring.services.*;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;


@RestController
@RequestMapping("/")
public class IndexControler {

    @Autowired
    private BooksServiceInterface booksService;

    @GetMapping(value = "")
    String index() {
        return "witaj na mojej stronie";
    }


    @PostMapping(value = "generateModel", produces = MediaType.TEXT_PLAIN_VALUE)
    public String generateModel(){

        DateTime dateAndTime  = DateTime.now();

        Books b1 = new Books("Lśnienie", "Horror","Stephen King", 200, new BigDecimal(19.90));
        Books b2 = new Books("Uciekinier", "Horror", "Stephen King", 234,new BigDecimal(22.90));
        Books b3 = new Books("Metro 2033", "Przygoda", "Dmitry Glughovsky",500, new BigDecimal(39.99));
        Books b4 = new Books("Oxford Wordpower", "Słownik", "Janet Phillips",100,new BigDecimal(89.90));
        Books b5 = new Books("Pamięć Nieulotna", "Autobiografia","Edward Snowden", 333,new BigDecimal(24.90));

        booksService.saveBook(b1);
        booksService.saveBook(b2);
        booksService.saveBook(b3);
        booksService.saveBook(b4);
        booksService.saveBook(b5);

        return "Model Generated";
    }


}





