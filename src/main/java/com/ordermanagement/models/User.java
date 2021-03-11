package com.ordermanagement.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class User extends AuditModel{
    private String name;
    private String city;
    private String state;
    private String country;
    private String phone;
    private String email;
    private String password;
}
