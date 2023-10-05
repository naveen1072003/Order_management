package com.order.order_management.controller;

import com.order.order_management.dto.CustomerLogindto;
import com.order.order_management.entity.CustomerDetails;
import com.order.order_management.entity.CustomerReview;
import com.order.order_management.entity.OrdersDetails;
import com.order.order_management.service.CustomerService;
import com.order.order_management.service.Impl.CustomerServiceImpl;
import com.order.order_management.service.Impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/customer")
public class CustomerDetailsController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderServiceImpl orderServiceImpl;

    // Adding New Customer
    @PostMapping("/newcustomer")
    public ResponseEntity<?> newCustomer(@RequestBody CustomerDetails customerDetails) {
//        System.out.println(customerDetails.toString());
//        customerDetails.setRoles("ROLE_USER");
        return customerService.saveCustomer(customerDetails);
    }

    // UserLogin
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody CustomerLogindto customerLoginDto) {
        System.out.println(customerLoginDto.toString());
        return customerService.loginAuthentication(customerLoginDto);
    }

    @PostMapping("/addReview")
    @PreAuthorize("hasAuthority('USER')")
    public String addReview(@RequestBody CustomerReview review) {
        return customerService.addReview(review);
    }

    @PostMapping("/newOrder")
    @PreAuthorize("hasAuthority('USER')")
    public String orderdetail(@RequestBody OrdersDetails ordersDetails) {
        System.out.println(ordersDetails);
        orderServiceImpl.placeOrder(ordersDetails);
        return "Order Added!!!";
    }

    @GetMapping("/getCustomerOrders/{custId}")
    @PreAuthorize("hasAuthority('USER')")
    public List<OrdersDetails> ordersDetails(@PathVariable Long custId) {
        return customerService.getOrders(custId);
    }


}
