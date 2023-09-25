package com.order.order_management.controller;

import com.order.order_management.dto.CustomerLogindto;
import com.order.order_management.entity.CustomerDetails;
import com.order.order_management.entity.CustomerReview;
import com.order.order_management.entity.OrdersDetails;
import com.order.order_management.repository.CustomerRepository;
import com.order.order_management.service.CustomerService;
import com.order.order_management.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/customer")
public class CustomerDetailsController {

    @Autowired
    private CustomerService
            customerService;

    @Autowired
    private OrderService orderService;

    // Adding New Customer
    @PostMapping("/newcustomer")
    public ResponseEntity<?> newCustomer(@RequestBody CustomerDetails customerDetails){
//        System.out.println(customerDetails.toString());
        return customerService.saveCustomer(customerDetails);
    }

    // UserLogin
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody CustomerLogindto customerLoginDto){
        System.out.println(customerLoginDto.toString());
        return customerService.loginAuthentication(customerLoginDto);
    }

    @PostMapping("/addReview")
    public String addReview(@RequestBody CustomerReview review){
        System.out.println(review);
        return customerService.addReview(review);
    }

    @PostMapping("/newOrder")
    public String orderdetail(@RequestBody OrdersDetails ordersDetails){
        System.out.println(ordersDetails);
        orderService.placeOrder(ordersDetails);
        return "Order Added!!!";
    }

    @GetMapping("/getAllOrders")
    public List<OrdersDetails> ordersDetails(){
        return customerService.getOrders();
    }

    @GetMapping("/getAllCustomers")
    public List<CustomerDetails>  customerDetails(){
        return customerService.getCustomers();
    }

}
