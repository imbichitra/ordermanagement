package com.ordermanagement.service;

import com.ordermanagement.dto.OrderReq;
import com.ordermanagement.dto.ProductReq;
import com.ordermanagement.models.Customers;
import com.ordermanagement.models.OrderDetail;
import com.ordermanagement.models.Orders;
import com.ordermanagement.models.Products;
import com.ordermanagement.repository.CustomerRepo;
import com.ordermanagement.repository.OrdersRepo;
import com.ordermanagement.repository.ProductRepo;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrdersRepo ordersRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ProductRepo productRepo;

    public Orders saveOrder(OrderReq orderReq){
        Orders orders = new Orders();
        orders.setOrderNo(generateRandomNumber());
        orders.setShippingId(generateRandomNumber());
        orders.setShippingDate(getShippingDate());

        Customers customers = customerRepo.findById(orderReq.getCustomerId()).get();
        orders.setCustomers(customers);


        List<OrderDetail> orderDetails = orderReq.getProductData().stream().map(this::generateOrderList).collect(Collectors.toList());
        orders.setOrderDetail(orderDetails);
        List<Products> products = orderReq.getProductData().stream().map(this::getProducts).collect(Collectors.toList());
        productRepo.saveAll(products);
        return ordersRepo.save(orders);
    }

    private Products getProducts(ProductReq productReq){
        Products products= productRepo.findById(productReq.getProductId()).get();
        products.setQuantity(products.getQuantity()-productReq.getQuantity());
        return products;
    }
    private OrderDetail generateOrderList(ProductReq productReq){
        Products products = productRepo.findById(productReq.getProductId()).get();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProducts(products);
        orderDetail.setColor(productReq.getColor());
        orderDetail.setPrice(products.getPrice());
        orderDetail.setQuantity((long) productReq.getQuantity());
        orderDetail.setSize(productReq.getSize());
        return orderDetail;
    }

    private String generateRandomNumber(){
        return new SecureRandom().ints(0,36)
                .mapToObj(i -> Integer.toString(i, 36))
                .map(String::toUpperCase).distinct().limit(16).collect(Collectors.joining())
                .replaceAll("([A-Z0-9]{4})", "$1-").substring(0,19);
    }

    private Date getShippingDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentDate = new Date();

        // convert date to calendar
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.DATE, 7);
        Date currentDatePlusOne = c.getTime();
        return currentDatePlusOne;
    }
}
