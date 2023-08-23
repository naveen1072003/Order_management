package com.order.order_management.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.InputStream;

@Entity
@Table(name = "prouct_details")
@Getter
@Setter
@ToString
public class ProductDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "prod_id")
    private Long id;

    @Column(name = "prod_name")
    private String prod_name;

//    @Column(name="thumbnail")
//    private String prod_img;

    @Column(name = "prod_desc")
    private String prod_desc;

    @Column(name = "price")
    private String prod_price;

    @Column(name = "quantity")
    private int quantity;

    //Relation btwn Product and their Category

    @ManyToOne(targetEntity = ProductCategory.class ,cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private ProductCategory category;
}
