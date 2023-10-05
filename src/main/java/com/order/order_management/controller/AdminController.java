package com.order.order_management.controller;

import com.order.order_management.entity.*;
import com.order.order_management.repository.CategoryRepository;
import com.order.order_management.service.AdminService;
import com.order.order_management.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    private AdminService adminService;

    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/addProducts", consumes = {"multipart/form-data"})
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addProducts(@RequestParam MultipartFile file, @RequestParam String prod_name, @RequestParam String prod_desc, @RequestParam String prod_price, @RequestParam String modelNo, @RequestParam String frameColor, @RequestParam String frameWidth, @RequestParam String prod_category, @RequestParam String quantity) throws IOException {
        ProductDetails productDetails = new ProductDetails();
        productDetails.setProd_name(prod_name);
        productDetails.setProd_image(Base64.getEncoder().encodeToString(file.getBytes()));
        productDetails.setProd_desc(prod_desc);
        productDetails.setProd_price(prod_price);
        productDetails.setFrameColor(frameColor);
        productDetails.setFrameWidth(frameWidth);
        productDetails.setModelNo(modelNo);
        productDetails.setCategory(new ProductCategory(adminService.isCategory(prod_category)));
        productDetails.setQuantity(quantity);
        return adminService.saveProduct(productDetails);
    }


    @GetMapping("/getAllProducts/{category}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<ProductDetails> productDetails(@PathVariable String category) {
        System.out.println(category);
        return adminService.getAllProducts(category);
    }

    @GetMapping("/getProducts")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<ProductDetails> getAllProducts() {
        return adminService.productDetailsList();
    }

    @DeleteMapping("/deleteProduct/{pid}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteProduct(@PathVariable Long pid) {
        return adminService.removeProduct(pid);
    }

    @PutMapping("/updateProducts/{pid}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String updateProduct(@RequestBody ProductDetails productDetails, @PathVariable Long pid) {
        adminService.updateProductById(pid, productDetails);
        return "Updated!";
    }
    @GetMapping("/getAllCustomers")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<CustomerDetails> customerDetails() {
        return customerService.getCustomers();
    }

//    @GetMapping("/getAllOrders")
//    @PreAuthorize("hasAuthority('ADMIN')")
//    public List<OrdersDetails> ordersDetails() {
//        return customerService.getOrders();
//    }


    @PostMapping("/addCategory")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> newCategory(@RequestBody ProductCategory category) {
        System.out.println(category);
        return adminService.addCategory(category);
    }

    @GetMapping("/getAllCategory")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<ProductCategory> productCategories() {
        List<ProductCategory> productCategories = adminService.getCategory();
        System.out.println(productCategories);
        return productCategories;
    }

    @PostMapping("/addStaff")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String saveStaff(@RequestBody StaffDetails staffDetails) {
        return adminService.saveStaffDetails(staffDetails);
    }

    @PostMapping("/removeStaff")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String removeStaff(Long id) {

        return adminService.deleteStaff(id);
    }

}
