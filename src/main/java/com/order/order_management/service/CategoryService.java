package com.order.order_management.service;

import com.order.order_management.entity.ProductCategory;
import com.order.order_management.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public ResponseEntity<?> addCategory(ProductCategory category){
        categoryRepository.save(category);
        return ResponseEntity.ok("Category Added!");
    }

    public Long isCategory(String categoryName){
      return categoryRepository.findByCategoryName(categoryName).getId();

    }

    public List<ProductCategory> getCategory() {
        return categoryRepository.findAll();
    }

}

