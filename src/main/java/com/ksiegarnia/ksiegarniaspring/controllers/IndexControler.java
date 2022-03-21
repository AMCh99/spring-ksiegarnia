package com.ksiegarnia.ksiegarniaspring.controllers;

import com.ksiegarnia.ksiegarniaspring.entities.*;
import com.ksiegarnia.ksiegarniaspring.services.*;
import org.hibernate.type.ZonedDateTimeType;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.ZonedDateTime;


@RestController
@RequestMapping("/")
public class IndexControler {

    @Autowired
    private BooksServiceInterface booksService;
    private AddressesServiceInterface addressesService;
    private CustomersServiceInterface customersService;
    private SellingsServiceInterface sellingsService;
    private SoldBooksServiceInterface soldBooksService;



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

        Customers c1 = new Customers("Arkadiusz", "Charliński",1);
        Customers c2 = new Customers("Jakub","Sierociński",2);

        Addresses a1 = new Addresses("Poznań", "Strzelecka",42,"21-037");
        Addresses a2 = new Addresses("Białystok","Szkolna",17,"61-278");

        Selling s1 = new Selling(1,"Dostarczona",new BigDecimal(200),null);
        Selling s2 = new Selling(2,"Dostarczona",new BigDecimal(350),null);

        SoldBooks sb1 = new SoldBooks(1,1,1);
        SoldBooks sb2 = new SoldBooks(1,2,1);
        SoldBooks sb3 = new SoldBooks(2,5,2);
        SoldBooks sb4 = new SoldBooks(2,4,3);


        booksService.saveBook(b1);
        booksService.saveBook(b2);
        booksService.saveBook(b3);
        booksService.saveBook(b4);
        booksService.saveBook(b5);

        customersService.saveCustomer(c1);
        customersService.saveCustomer(c2);

        addressesService.saveAddress(a1);
        addressesService.saveAddress(a2);

        sellingsService.saveSelling(s1);
        sellingsService.saveSelling(s2);

        soldBooksService.saveSoldBook(sb1);
        soldBooksService.saveSoldBook(sb2);
        soldBooksService.saveSoldBook(sb3);
        soldBooksService.saveSoldBook(sb4);


        return "Model Generated";
    }


}





