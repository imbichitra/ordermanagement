package com.ordermanagement.controllers;

import com.ordermanagement.dto.SupplierRequest;
import com.ordermanagement.models.Suppliers;
import com.ordermanagement.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/supplier")
public class SuppliersController {
    @Autowired
    private SupplierService supplierService;

    @PostMapping("/register-suppliers")
    public Suppliers save(@RequestBody SupplierRequest supplierRequest){
        return supplierService.save(supplierRequest);
    }


}
