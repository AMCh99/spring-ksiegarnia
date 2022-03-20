package com.ksiegarnia.ksiegarniaspring.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,
        property="refSelId", scope=Selling.class)
public class Selling {

    @Id
    @GeneratedValue(generator = "gen")
    @SequenceGenerator(name = "gen", sequenceName = "seller_seq")
    private int selling_id;

    @Column
    private int customer_id;

    @Column(length = 12)
    private String shipment_status;

    @Column
    private BigDecimal cost;

    @Column
    private ZonedDateTime sold_date;

    public Selling(){}

    public Selling(int customer_id, String shipment_status, BigDecimal cost, ZonedDateTime sold_date) {
        this.customer_id = customer_id;
        this.shipment_status = shipment_status;
        this.cost = cost;
        this.sold_date = sold_date;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    Set<Customers> customer = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "selling_id", referencedColumnName = "selling_id")
    Set<SoldBooks> soldBooks = new HashSet<>();


    public int getSelling_id() {
        return selling_id;
    }

    public void setSelling_id(int selling_id) {
        this.selling_id = selling_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getShipment_status() {
        return shipment_status;
    }

    public void setShipment_status(String shipment_status) {
        this.shipment_status = shipment_status;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public ZonedDateTime getSold_date() {
        return sold_date;
    }

    public void setSold_date(ZonedDateTime sold_date) {
        this.sold_date = sold_date;
    }
}
