package com.ordermanagement.service;

import com.ordermanagement.dto.AddressReq;
import com.ordermanagement.dto.SupplierRequest;
import com.ordermanagement.models.Address;
import com.ordermanagement.models.Suppliers;
import com.ordermanagement.repository.SuppliersRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class SupplierService {

    @Autowired
    private SuppliersRepo suppliersRepo;

    public Suppliers save(SupplierRequest supplierRequest){
        Suppliers suppliers = new Suppliers();
        List<Address> address = supplierRequest.getAddress().stream().map(this::getAddress).collect(Collectors.toList());

        BeanUtils.copyProperties(supplierRequest,suppliers);
        suppliers.setAddress(address);
        return suppliersRepo.save(suppliers);
    }

    private Address getAddress(AddressReq addressReq){
        Address address = new Address();
        BeanUtils.copyProperties(addressReq,address);
        return address;
    }
}
