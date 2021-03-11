package com.ordermanagement.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
public class Address extends AuditModel{
    @Column(name = "address_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String landmark;
    //address
    private String address;
}
