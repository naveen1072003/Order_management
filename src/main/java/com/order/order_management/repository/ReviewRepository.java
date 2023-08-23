package com.order.order_management.repository;

import com.order.order_management.entity.CustomerReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<CustomerReview,Long> {
}
