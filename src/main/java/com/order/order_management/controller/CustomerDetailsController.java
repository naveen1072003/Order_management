package com.order.order_management.controller;

import com.order.order_management.dto.CustomerLogindto;
import com.order.order_management.entity.CustomerDetails;
import com.order.order_management.entity.CustomerReview;
import com.order.order_management.repository.CustomerRepository;
import com.order.order_management.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/api/v1/customer")
public class CustomerDetailsController {

    @Autowired
    private CustomerService customerService;

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
        return customerService.addReview(review);
    }
}
