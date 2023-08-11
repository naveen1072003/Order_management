package com.order.order_management.service;

import com.order.order_management.dto.CustomerLogin_dto;
import com.order.order_management.entity.CustomerDetails;
import com.order.order_management.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public String saveCustomer(CustomerDetails customerDetails){
        customerRepository.save(customerDetails);
        return "Added successfully!";
    }

    public String loginAuthentication(CustomerLogin_dto customerLoginDto){
        CustomerDetails customerDetails = customerRepository.findByEmail(customerLoginDto.getEmail());

        if(customerDetails == null){
            return "User does not exist!";
        }
        else if(!customerDetails.getPassword().equals(customerLoginDto.getPassword())){
            return "You have entered wrong password";
        }
        return "Logged in successsful!";
    }
}
