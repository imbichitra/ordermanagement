package com.ordermanagement.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customers extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_address",referencedColumnName = "customer_id")
    private List<Address> address;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "customers")
    @JsonManagedReference
    private List<Orders> orders;
}
