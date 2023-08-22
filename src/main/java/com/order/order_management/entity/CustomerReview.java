package com.order.order_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "review")
@Getter
@Setter
public class CustomerReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private long id;

    @Column(name = "review_description")
    private String r_desc;

    @Column(name = "review_stars")
    private String r_stars;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cust_id" ,referencedColumnName = "cust_id")
    private CustomerDetails customerDetails;

}
