package com.ordermanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ordermanagement.models.Address;
import com.ordermanagement.models.User;
import lombok.Data;

import java.util.List;

@Data
public class SupplierRequest{
    private List<AddressReq> address;
    private String name;
    private String city;
    private String state;
    private String country;
    private String phone;
    private String email;
    private String password;
}
