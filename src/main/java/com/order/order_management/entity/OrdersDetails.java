package com.order.order_management.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "order_details")
public class OrdersDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ord_id")
    private String ord_id;

    @Column(name = "prod_quantity")
    private Long prod_quantity;

    @Column
    private String ord_date;

    @Column
    private String ord_status;
}
