package com.ordermanagement.controllers;

import com.ordermanagement.dto.OrderReq;
import com.ordermanagement.models.Orders;
import com.ordermanagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/order")
    public Orders save(@RequestBody OrderReq req){
        return orderService.saveOrder(req);
    }
}
