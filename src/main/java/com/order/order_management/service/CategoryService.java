package com.order.order_management.service;

import com.order.order_management.entity.ProductCategory;
import com.order.order_management.repository.CategoryRepository;
import com.order.order_management.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public ResponseEntity<?> addCategory(ProductCategory category){
        categoryRepository.save(category);
        return ResponseEntity.ok("Category Added!");
    }


}
