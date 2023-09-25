package com.order.order_management.service;

import com.order.order_management.entity.OrdersDetails;
import com.order.order_management.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    public OrdersDetails placeOrder(OrdersDetails ordersDetails) {
        Date date = new Date();
        ordersDetails.setOrd_date(date);
        return orderRepository.save(ordersDetails);
    }
}
