package com.order.order_management.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class CustomerReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private long id;

    @Column(name = "product_id")
    private long p_id;

    @Column(name = "customer_id")
    private long c_id;

    @Column(name = "review_description")
    private String r_desc;

    @Column(name = "review_stars")
    private String r_stars;

}
