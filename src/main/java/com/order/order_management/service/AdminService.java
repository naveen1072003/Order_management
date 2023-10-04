package com.order.order_management.service;

import com.order.order_management.entity.ProductCategory;
import com.order.order_management.entity.ProductDetails;
import com.order.order_management.entity.StaffDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Component
public interface AdminService {
    String saveStaffDetails(StaffDetails staffDetails);
    String deleteStaff(long id);
    String saveProduct(ProductDetails productDetails);
    String removeProduct(Long id);
    void updateProductById(Long pid, ProductDetails productDetails);
    List<ProductDetails> getAllProducts(String category);
    List<ProductDetails> productDetailsList();
    ResponseEntity<?> addCategory(ProductCategory category);
    Long isCategory(String categoryName);
    List<ProductCategory> getCategory();
}
