package com.ksiegarnia.ksiegarniaspring.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "books", schema = "schema_name")
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,
        property="refSelId", scope=Books.class)
public class Books {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @GenericGenerator(name = "native",strategy = "native")
    private int book_id;

    //@GeneratedValue(generator = "gen")
    //@SequenceGenerator(name="gen", sequenceName = "author_seq")
    //@GeneratedValue(strategy = GenerationType.AUTO)

    @Column(length = 30)
    private String title;

    @Column(length = 30)
    private String genre;

    @Column(length = 30)
    private String author;

    @Column
    private int amount;

    @Column
    @Max(value = 100)
    private BigDecimal price;

    public Books(){}

    public Books(String title, String genre, String author, int amount, BigDecimal price){
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.amount = amount;
        this.price = price;

    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    /*@JoinTable(name = "SoldBooks",
    joinColumns = {@JoinColumn(name = "Books.book_id")},
    inverseJoinColumns = {@JoinColumn(name = "SoldBooks.book_id")})
    Set<SoldBooks> soldBooks = new HashSet<>();*/
    @JoinColumns({@JoinColumn(name = "Books.book_id", referencedColumnName = "SoldBooks.book_id"),
    @JoinColumn(name = "Books.book_id", referencedColumnName = "SoldBooks.book_id")})
    Set<SoldBooks> soldBooks = new HashSet<>();




    //@ManyToMany(fetch = FetchType.LAZY)
    //List<SoldBooks> soldBooks;



    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
