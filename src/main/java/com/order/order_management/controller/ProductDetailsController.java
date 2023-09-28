package com.order.order_management.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.order.order_management.dto.ImageDto;
import com.order.order_management.dto.ProductDetailsDTO;
import com.order.order_management.entity.ProductCategory;
import com.order.order_management.entity.ProductDetails;
import com.order.order_management.repository.CategoryRepository;
import com.order.order_management.service.CategoryService;
import com.order.order_management.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/products")
public class ProductDetailsController {

    @Autowired
    private ProductDetailsService detailsService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    CategoryRepository categoryRepository;

    @PostMapping(value = "/addProducts")
    public String addProducts(
            @RequestBody ProductDetails productDetails
    ) throws IOException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        ProductDetails productDetails = objectMapper.readValue(productDetailsJson, ProductDetails.class);

        System.out.println(productDetails);
//        productDetails.setProd_image(Base64.getEncoder().encodeToString(file.getBytes()));
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

    @GetMapping("/getAllCategory")
    public List<ProductCategory> productCategories(){
        List<ProductCategory> productCategories = categoryService.getCategory();
        System.out.println(productCategories);
        return productCategories;
    }
}
