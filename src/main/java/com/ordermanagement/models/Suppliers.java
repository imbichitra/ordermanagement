package com.ordermanagement.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "suppliers")
public class Suppliers extends User{
    @Column(name = "suppliers_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_address",referencedColumnName = "suppliers_id")
    private List<Address> address;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "suppliers")
    @JsonBackReference
    private List<Products> products;

}
