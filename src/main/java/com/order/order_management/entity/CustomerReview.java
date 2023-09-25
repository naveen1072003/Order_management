package com.order.order_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "review")
@Getter
@Setter
@ToString
public class CustomerReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private long id;

    @Column(name = "review_description")
    private String r_desc;

    @Column(name = "review_stars")
    private String r_stars;

    @ManyToOne
    @JoinColumn(name = "prod_id")
    private ProductDetails productDetails;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerDetails customerDetails;


}
