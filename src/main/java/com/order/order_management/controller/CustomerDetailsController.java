package com.order.order_management.controller;

import com.order.order_management.dto.CustomerLogindto;
import com.order.order_management.entity.CustomerDetails;
import com.order.order_management.repository.CustomerRepository;
import com.order.order_management.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1")
public class CustomerDetailsController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/Customer_Details")
    public String newCustomer(CustomerDetails customerDetails){
        return customerService.saveCustomer(customerDetails);
    }

    // UserLogin
    @PostMapping("/login")
    public String login(CustomerLogindto customerLoginDto){
        return customerService.loginAuthentication(customerLoginDto);
    }

//    @RequestMapping("/forgotpassword")
//    public String forgotPass(){
//        return customerService.
//    }
}
