package com.order.order_management.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "order_details")
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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ref_staff_id", referencedColumnName = "staff_id")
    private StaffDetails staffDetails;
}
