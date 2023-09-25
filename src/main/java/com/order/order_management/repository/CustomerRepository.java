package com.order.order_management.repository;

import com.order.order_management.entity.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerDetails,Long> {

       Optional<CustomerDetails> findByEmail(String email);
}
