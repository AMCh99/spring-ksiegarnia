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
        property="refId", scope=Refunds.class)
public class Refunds {

    @Id
    @GeneratedValue(generator = "gen")
    @SequenceGenerator(name = "gen", sequenceName = "seller_seq")
    private int refund_id;

    @Column
    private int selling_id;

    @Column
    private int customer_id;

    @Column
    private BigDecimal returned_money;

    @Column
    private ZonedDateTime refund_date;

    public Refunds(){}

    public Refunds(int selling_id, int customer_id, BigDecimal returned_money, ZonedDateTime refund_date) {
        this.selling_id = selling_id;
        this.customer_id = customer_id;
        this.returned_money = returned_money;
        this.refund_date = refund_date;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    Set<Customers> customer = new HashSet<>();

    public int getRefund_id() {
        return refund_id;
    }

    public void setRefund_id(int refund_id) {
        this.refund_id = refund_id;
    }

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

    public BigDecimal getReturned_money() {
        return returned_money;
    }

    public void setReturned_money(BigDecimal returned_money) {
        this.returned_money = returned_money;
    }

    public ZonedDateTime getRefund_date() {
        return refund_date;
    }

    public void setRefund_date(ZonedDateTime refund_date) {
        this.refund_date = refund_date;
    }
}
