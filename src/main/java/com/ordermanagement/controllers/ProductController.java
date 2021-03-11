package com.ordermanagement.controllers;

import com.ordermanagement.dto.ProductRequest;
import com.ordermanagement.dto.SupplierRequest;
import com.ordermanagement.models.Products;
import com.ordermanagement.models.Suppliers;
import com.ordermanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    public Products save(@RequestBody ProductRequest productRequest){
        return productService.saveProduct(productRequest);
    }

    @GetMapping("/product/{id}")
    public Products save(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }
}
