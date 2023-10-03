package com.order.order_management.repository;

import com.order.order_management.entity.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface ProductRepository extends JpaRepository<ProductDetails, Long> {

    List<ProductDetails> findAllByCategory_CategoryName(String category_categoryName);
}
