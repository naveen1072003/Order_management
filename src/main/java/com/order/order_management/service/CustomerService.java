package com.order.order_management.service;

import com.order.order_management.dto.CustomerLogindto;
import com.order.order_management.entity.CustomerDetails;
import com.order.order_management.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public ResponseEntity<?> saveCustomer(CustomerDetails customerDetails){
        customerRepository.save(customerDetails);
        System.out.println(customerDetails);
        return ResponseEntity.ok("Added successfullly.");
//        return "Added successfully!";
    }

    public ResponseEntity<?> loginAuthentication(CustomerLogindto customerLoginDto){
        CustomerDetails customerDetails = customerRepository.findByEmail(customerLoginDto.getEmail());

        if(customerDetails == null){
            return ResponseEntity.ok("User does not exist!");
        }
        else if(!customerDetails.getPassword().equals(customerLoginDto.getPassword())){
//            System.out.println("Login unsuccess");
            return ResponseEntity.ok("You have entered wrong password");
        }
//        System.out.println("Login success");
        return ResponseEntity.ok("Logged in successsful!");
    }
}
