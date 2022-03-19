package com.ksiegarnia.ksiegarniaspring.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
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

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String city;

    @Column
    private String street;

    @Column
    private int house_nr;

    @Column
    private String post_code;

    public Customers(){}

    public Customers(String name, String surname, String city, String street, int house_nr, String post_code){
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.street = street;
        this.house_nr = house_nr;
        this.post_code = post_code;
    }

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
