package com.ordermanagement.dto;

import com.ordermanagement.models.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerReq {
    private String name;
    private String city;
    private String state;
    private String country;
    private String phone;
    private String email;
    private String password;
    private List<AddressReq> address;
}
