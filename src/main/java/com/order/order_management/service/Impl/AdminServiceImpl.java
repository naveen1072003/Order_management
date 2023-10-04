package com.order.order_management.service.Impl;

import com.order.order_management.entity.ProductCategory;
import com.order.order_management.entity.ProductDetails;
import com.order.order_management.entity.StaffDetails;
import com.order.order_management.repository.CategoryRepository;
import com.order.order_management.repository.ProductRepository;
import com.order.order_management.repository.StaffRepository;
import com.order.order_management.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {


    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    public String saveStaffDetails(StaffDetails staffDetails) {
        staffRepository.save(staffDetails);
        return "Staff Details Saved!";
    }

    public String deleteStaff(long id) {
        staffRepository.deleteById(id);
        return "Staff Deleted!";
    }


    public String saveProduct(ProductDetails productDetails) {
        productRepository.save(productDetails);
        return "Product Added Successfully!";
    }

    public String removeProduct(Long id) {
        ProductDetails productDetails = productRepository.findById(id).get();
        if (productDetails != null) {
            productRepository.deleteById(id);
            return "Product Removed Successfully";
        }
        return "Product Not Found";
    }

    public void updateProductById(Long pid, ProductDetails productDetails) {
        ProductDetails updateDetails = productRepository.getReferenceById(pid);
        updateDetails.setProd_desc(productDetails.getProd_desc());
        updateDetails.setProd_name(productDetails.getProd_name());
        updateDetails.setQuantity(productDetails.getQuantity());
        updateDetails.setProd_price(productDetails.getProd_price());
//        updateDetails.setCategory(productDetails.getCategory());
        productRepository.save(updateDetails);

    }


    public List<ProductDetails> getAllProducts(String category) {
        return productRepository.findAllByCategory_CategoryName(category);
    }

    public List<ProductDetails> productDetailsList() {
        return productRepository.findAll();
    }

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

