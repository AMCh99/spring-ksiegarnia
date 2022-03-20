package com.ksiegarnia.ksiegarniaspring.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,
        property="refId", scope=Customers.class)
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customer_id;

    @Column(length = 20)
    private String name;

    @Column(length = 20)
    private String surname;

    @Column
    @Email
    private String email;

    @Column
    @CreditCardNumber
    private int credit_card;

    @Column(length = 20)
    private String city;

    @Column(length = 20)
    private String street;

    @Column
    private int house_nr;

    @Column(length = 6)
    private String post_code;

    public Customers() {
    }

    public Customers(String name, String surname, String email, int credit_card, String city, String street, int house_nr, String post_code) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.credit_card = credit_card;
        this.city = city;
        this.street = street;
        this.house_nr = house_nr;
        this.post_code = post_code;
    }

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    Set<Refunds> refunds;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    Set<Selling> sellings;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCredit_card() {
        return credit_card;
    }

    public void setCredit_card(int credit_card) {
        this.credit_card = credit_card;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity(){
        return city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    public void setHouse_nr(int house_nr) {
        this.house_nr = house_nr;
    }

    public int getHouse_nr() {
        return house_nr;
    }

    public void setPost_code(String post_code) {
        this.post_code = post_code;
    }

    public String getPost_code() {
        return post_code;
    }
}
