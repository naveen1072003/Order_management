package com.order.order_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

import java.util.List;

@Entity
@Table(name = "staff_details")
@Getter
@Setter
@ToString
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

    @OneToMany(mappedBy = "staffDetails")
    private List<OrdersDetails> ordersDetails;
}
