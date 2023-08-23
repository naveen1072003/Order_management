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
    public String addProducts(@RequestBody ProductDetailsDTO productDetailsDTO){
        ProductDetails productDetails = new ProductDetails();
        Optional<ProductCategory> productCategory = categoryRepository.findById(productDetailsDTO.getCategoryId());


        productDetails.setCategory(productCategory.get());
        productDetails.setProd_name(productDetailsDTO.getProductName());
        productDetails.setProd_desc(productDetailsDTO.getProd_desc());
        productDetails.setProd_price(productDetailsDTO.getProd_price());
        productDetails.setQuantity(productDetailsDTO.getQuantity());

        return detailsService.saveProduct(productDetails);
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
}
