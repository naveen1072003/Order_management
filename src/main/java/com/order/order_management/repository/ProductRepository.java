package com.order.order_management.repository;

import com.order.order_management.entity.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductDetails, Long> {
}
