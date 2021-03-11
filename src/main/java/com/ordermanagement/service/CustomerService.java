package com.ordermanagement.service;

import com.ordermanagement.dto.AddressReq;
import com.ordermanagement.dto.CustomerReq;
import com.ordermanagement.dto.OrderDetailResponse;
import com.ordermanagement.dto.OrderResponse;
import com.ordermanagement.models.Address;
import com.ordermanagement.models.Customers;
import com.ordermanagement.models.OrderDetail;
import com.ordermanagement.models.Orders;
import com.ordermanagement.repository.CustomerRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public Customers saveCustomer(CustomerReq customerReq){
        Customers customers = new Customers();
        List<Address> addresses = customerReq.getAddress().stream().map(this::getAddress).collect(Collectors.toList());
        BeanUtils.copyProperties(customerReq,customers);
        customers.setAddress(addresses);
        return customerRepo.save(customers);
    }

    private Address getAddress(AddressReq addressReq){
        Address address = new Address();
        BeanUtils.copyProperties(addressReq,address);
        return address;
    }

    public List<OrderResponse> getAllOrder(Long customerId){
        List<Orders> orders = customerRepo.findById(customerId).get().getOrders();
        List<OrderResponse> orderResponses = orders.stream().map(this::getOrderDetail).collect(Collectors.toList());
        return orderResponses;
    }

    private OrderResponse getOrderDetail(Orders orders){
        OrderResponse orderResponse = new OrderResponse();
        BeanUtils.copyProperties(orders,orderResponse);
        List<OrderDetailResponse> orderDetailResponses = orders.getOrderDetail().stream().map(this::getOrderDetailResponse).collect(Collectors.toList());
        orderResponse.setOrderDetail(orderDetailResponses);
        return orderResponse;
    }

    private OrderDetailResponse getOrderDetailResponse(OrderDetail orderDetail){
        OrderDetailResponse orderDetailResponse = new OrderDetailResponse();
        BeanUtils.copyProperties(orderDetail,orderDetailResponse);
        orderDetailResponse.setProductName(orderDetail.getProducts().getProductName());
        return orderDetailResponse;
    }
}
