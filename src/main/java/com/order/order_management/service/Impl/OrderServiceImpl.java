package com.order.order_management.service.Impl;

import com.order.order_management.entity.OrdersDetails;
import com.order.order_management.repository.OrderRepository;
import com.order.order_management.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    public void placeOrder(OrdersDetails ordersDetails) {
        Date date = new Date();
        ordersDetails.setOrd_date(date);
        orderRepository.save(ordersDetails);
    }
}
