package com.ksiegarnia.ksiegarniaspring.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.Set;


@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,
        property="refId", scope=Customers.class)
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customer_id;

    @Column(length = 20)
    private String name;

    @Column(length = 20)
    private String surname;

    @Column
    @Email
    private String email;

    @Column
    private int credit_card;

    @Column
    private int addres_id;


    public Customers() {
    }

    public Customers(String name, String surname, int addres_id) {
        this.name = name;
        this.surname = surname;
        this.email = name + surname + "@spring.com";
        this.credit_card = ((int)Math.floor(Math.random()*(1000000000-900000000+1)+900000000));
        this.addres_id = addres_id;

    }

    @OneToMany(mappedBy = "customers", cascade = CascadeType.ALL, fetch =FetchType.EAGER)
    Set<Selling> sellings = new HashSet<>();

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="Customers.addres_id", referencedColumnName = "addres_id")
    Addresses addresses;




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

    public int getAddres_id() {
        return addres_id;
    }

    public void setAddres_id(int addres_id) {
        this.addres_id = addres_id;
    }
}
