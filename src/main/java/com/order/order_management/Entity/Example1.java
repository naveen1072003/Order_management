package com.order.order_management.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "first")
public class Example1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column
    String fname;

    @Column
    String lname;

}
