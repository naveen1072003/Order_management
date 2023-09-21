package com.order.order_management.controller;

import com.order.order_management.dto.ProductDetailsDTO;
import com.order.order_management.entity.ProductCategory;
import com.order.order_management.entity.ProductDetails;
import com.order.order_management.repository.CategoryRepository;
import com.order.order_management.service.CategoryService;
import com.order.order_management.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
public class ProductDetailsController {

    @Autowired
    private ProductDetailsService detailsService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    CategoryRepository categoryRepository;

    @PostMapping("/addProducts")
    public String addProducts(@RequestBody ProductDetails productDetails){
        System.out.println(productDetails);
        return detailsService.saveProduct(productDetails);
    }

    @GetMapping("/getAllProducts")
    public List<ProductDetails> productDetails(){
        return detailsService.getAllProducts();
    }

    @DeleteMapping("/deleteProduct/{pid}")
    public String deleteProduct(@PathVariable Long pid){
        return detailsService.removeProduct(pid);
    }
    @PutMapping("/updateProducts/{pid}")
    public String updateProduct(@RequestBody ProductDetails productDetails,
                                @PathVariable Long pid){
        detailsService.updateProductById(pid,productDetails);
        return "Updated!";
    }

    @PostMapping("/addCategory")
    public ResponseEntity<?> newCategory(@RequestBody ProductCategory category){
        return categoryService.addCategory(category);
    }

    @GetMapping("/getCategory")
    public List<ProductCategory> productCategories(){
        List<ProductCategory> productCategories = categoryService.getCategory();
        System.out.println(productCategories);
        return productCategories;
    }
}
