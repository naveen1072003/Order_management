package com.order.order_management.service;

import com.order.order_management.entity.OrdersDetails;
import com.order.order_management.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    public OrdersDetails placeOrder(OrdersDetails ordersDetails) {
        return orderRepository.save(ordersDetails);
    }
}
