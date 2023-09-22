package com.order.order_management.entity;


import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "order_details")
@Getter
@Setter
@ToString
public class OrdersDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ord_id")
    private Long ord_id;

//    @Column(name = "prod_quantity")
//    private Long prod_quantity;

    @Column
    private String ord_date;

    @Column
    private String ord_status;

    //Relation btwn order and staff handled the order
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staff_id")
    private StaffDetails staffDetails;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "prod_id")
    private ProductDetails productDetails;

}
