package com.ksiegarnia.ksiegarniaspring.controllers;

import com.ksiegarnia.ksiegarniaspring.entities.*;
import com.ksiegarnia.ksiegarniaspring.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/")
public class IndexControler {

    @Autowired
    private BooksServiceInterface booksService;

    @GetMapping(value = "")
    String index(){return "witaj na mojej stronie";}

}
