package com.order.order_management.service;

import com.order.order_management.entity.OrdersDetails;
import org.springframework.stereotype.Component;

@Component
public interface OrderService {
    void placeOrder(OrdersDetails ordersDetails);
}
