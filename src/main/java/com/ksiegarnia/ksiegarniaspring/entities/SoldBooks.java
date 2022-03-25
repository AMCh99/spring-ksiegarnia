package com.ksiegarnia.ksiegarniaspring.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "soldBooks", schema = "schema_name")
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,
        property="refSelId", scope=SoldBooks.class)
public class SoldBooks {

    @Id
    private int selling_id;

    @Column
    private int book_id;

    @Column
    private int books_amount;

    public SoldBooks(){
    }

    public SoldBooks(int selling_id, int book_id, int books_amount) {
        this.selling_id = selling_id;
        this.book_id = book_id;
        this.books_amount = books_amount;
    }


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    Set<Selling> sellings = new HashSet<>();


    @ManyToMany(mappedBy = "soldBooks")
    Set<Books> books = new HashSet<>();




    public int getSelling_id() {
        return selling_id;
    }

    public void setSelling_id(int selling_id) {
        this.selling_id = selling_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getBooks_amount() {
        return books_amount;
    }

    public void setBooks_amount(int books_amount) {
        this.books_amount = books_amount;
    }
}
