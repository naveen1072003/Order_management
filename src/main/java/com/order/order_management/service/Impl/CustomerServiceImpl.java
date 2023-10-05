package com.order.order_management.service.Impl;

import com.order.order_management.dto.CustomerLogindto;
import com.order.order_management.entity.CustomerDetails;
import com.order.order_management.entity.CustomerReview;
import com.order.order_management.entity.OrdersDetails;
import com.order.order_management.repository.CustomerRepository;
import com.order.order_management.repository.OrderRepository;
import com.order.order_management.repository.ReviewRepository;
import com.order.order_management.service.CustomerService;
import com.order.order_management.service.JwtService;
import com.order.order_management.service.UserInfoDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements UserDetailsService, CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JwtService jwtService;

    public ResponseEntity<?> saveCustomer(CustomerDetails customerDetails){
        Optional<CustomerDetails> details = customerRepository.findByEmail(customerDetails.getEmail());

        if(details.isPresent()){
            return new ResponseEntity<>("User Already Exist!!", HttpStatus.BAD_REQUEST);
        }
        customerDetails.setPassword(encoder.encode(customerDetails.getPassword()));
        customerRepository.save(customerDetails);
        System.out.println(customerDetails);
        return ResponseEntity.ok("Added successfully.");
    }

    public ResponseEntity<?> loginAuthentication(CustomerLogindto customerLoginDto){
        Optional<CustomerDetails> customerDetails = customerRepository.findByEmail(customerLoginDto.getEmail());

        if(customerDetails.isEmpty()){
            return ResponseEntity.ok("User does not exist!");
        }
        else {
            if (encoder.matches(customerLoginDto.getPassword(), customerDetails.get().getPassword())) {
                return new ResponseEntity<>(jwtService.generateToken(customerLoginDto.getEmail()),HttpStatus.OK);
            }
            return new ResponseEntity<>("You have entered wrong password",HttpStatus.NO_CONTENT);
        }
    }

    public String addReview(CustomerReview review) {
        CustomerReview customerReview = reviewRepository.findByCustomerDetails_IdAndAndProductDetails_Id(review.getCustomerDetails().getId(),review.getProductDetails().getId());
        System.out.println(customerReview);
        if(customerReview != null){
            return customerReview.getR_desc();
        }
        reviewRepository.save(review);
        return "Added";
    }

    public List<CustomerDetails> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public List<OrdersDetails> getOrders(Long id) {
        return orderRepository.findAllByCustomerDetails_Id(id);
    }

    public List<OrdersDetails> getOrders() {
        return orderRepository.findAll();
    }
   @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<CustomerDetails> userDetail = customerRepository.findByEmail(username);

        // Converting userDetail to UserDetails
        return userDetail.map(UserInfoDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
    }
}
