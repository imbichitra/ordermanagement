package com.ordermanagement.controllers;

import com.ordermanagement.dto.CustomerReq;
import com.ordermanagement.dto.OrderResponse;
import com.ordermanagement.models.Customers;
import com.ordermanagement.models.Orders;
import com.ordermanagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public Customers save(@RequestBody CustomerReq customerReq){
        return customerService.saveCustomer(customerReq);
    }

    @GetMapping("/getAllOrders/{customerId}")
    public List<OrderResponse> getAllOrder(@PathVariable("customerId") Long id){
        return customerService.getAllOrder(id);
    }
}
