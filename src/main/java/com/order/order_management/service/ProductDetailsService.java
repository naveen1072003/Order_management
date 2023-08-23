package com.order.order_management.service;

import com.order.order_management.entity.ProductDetails;
import com.order.order_management.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@Service
public class ProductDetailsService {

    @Autowired
    private ProductRepository productRepository;

    public String saveProduct(ProductDetails productDetails){
        productRepository.save(productDetails);
        return "Product Added Successfully!";
    }

    public String removeProduct(Long id){
        ProductDetails  productDetails = productRepository.findById(id).get();
        if(productDetails != null){
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
        updateDetails.setCategory(productDetails.getCategory());

        productRepository.save(updateDetails);

    }
}
