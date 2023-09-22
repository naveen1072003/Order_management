package com.order.order_management.repository;

import com.order.order_management.entity.CustomerReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<CustomerReview,Long> {
    @Query("SELECT r FROM CustomerReview r WHERE r.productDetails.id = :productId AND r.customers.id = :customerId")
    CustomerReview findByProductIdAndCustomerId(Long productId, Long customerId);
}
