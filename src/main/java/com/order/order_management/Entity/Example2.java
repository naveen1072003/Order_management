package com.order.order_management.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "second")
public class Example2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long s_id;
    @Column
    String age;

    @Column
    String dob;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fkey_id")
    private Example1 example1;
}
