package com.ksiegarnia.ksiegarniaspring.entities;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,
        property="refId", scope=Addresses.class)
public class Addresses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addres_id;
    //@GeneratedValue(generator = "gen")
    //@SequenceGenerator(name="gen", sequenceName = "author_seq")
    @Column(length = 20)
    private String city;

    @Column(length = 20)
    private String street;

    @Column
    private int house_nr;

    @Column(length = 6)
    private String post_code;


    public Addresses(){}

    public Addresses(String city, String street, int house_nr, String post_code) {
        this.city = city;
        this.street = street;
        this.house_nr = house_nr;
        this.post_code = post_code;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="Addresses.addres_id", referencedColumnName = "addres_id")
    Customers customers;




    public int getAddres_id() {
        return addres_id;
    }

    public void setAddres_id(int addres_id) {
        this.addres_id = addres_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse_nr() {
        return house_nr;
    }

    public void setHouse_nr(int house_nr) {
        this.house_nr = house_nr;
    }

    public String getPost_code() {
        return post_code;
    }

    public void setPost_code(String post_code) {
        this.post_code = post_code;
    }
}

