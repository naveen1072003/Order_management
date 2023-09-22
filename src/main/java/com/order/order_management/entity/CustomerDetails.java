package com.order.order_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "cust_details")
@Getter
@Setter
@ToString
public class CustomerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private String email;

    @Column
    private String password;

    @Column
    private Double cust_wallet_balance;

    @OneToMany(targetEntity = CustomerReview.class,mappedBy = "customers")
    private List<CustomerReview> reviewList;

}
