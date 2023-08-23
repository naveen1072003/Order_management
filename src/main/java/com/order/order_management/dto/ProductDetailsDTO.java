package com.order.order_management.dto;

import lombok.Data;

@Data
public class ProductDetailsDTO {

    private String productName;

    private String prod_desc;

    private String prod_price;

    private int quantity;

    private Long categoryId;

}
