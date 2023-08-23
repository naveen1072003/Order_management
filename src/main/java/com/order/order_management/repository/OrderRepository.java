package com.order.order_management.repository;

import com.order.order_management.entity.OrdersDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrdersDetails,Long> {
}
