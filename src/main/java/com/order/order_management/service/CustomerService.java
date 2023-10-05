package com.order.order_management.service;

import com.order.order_management.dto.CustomerLogindto;
import com.order.order_management.entity.CustomerDetails;
import com.order.order_management.entity.CustomerReview;
import com.order.order_management.entity.OrdersDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CustomerService {
    ResponseEntity<?> saveCustomer(CustomerDetails customerDetails);
    ResponseEntity<?> loginAuthentication(CustomerLogindto customerLoginDto);
    String addReview(CustomerReview review);
    List<CustomerDetails> getCustomers();
    List<OrdersDetails> getOrders(Long id);
}
