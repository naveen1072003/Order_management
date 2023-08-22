package com.order.order_management.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "staff_details")
public class StaffDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private long id;
    @Column
    private String fname;
    @Column
    private String lname;
    @Column
    private String email;
    @Column
    private String phno;
    @Column
    private String password;
    @Column
    private String role;

    @OneToOne(mappedBy = "staffDetails")
    private OrdersDetails ordersDetails;

}
