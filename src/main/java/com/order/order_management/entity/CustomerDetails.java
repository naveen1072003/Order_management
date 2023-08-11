package com.order.order_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "cust_details")
@Getter
@Setter
@ToString
public class CustomerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private Long id;

    @Column
    private String cust_name;

    @Column
    private String cust_area;

    @Column
    private String cust_street;

    @Column
    private String cust_city;

    @Column
    private Long cust_pin;

    @Column
    private Long cust_phone;

    @Column
    private String cust_dob;

    @Column
    private String cust_email;

    @Column
    private String password;

    @Column
    private Double cust_wallet_balance;



}
