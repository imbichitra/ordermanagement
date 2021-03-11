package com.ordermanagement.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Products extends AuditModel{
    @Column(name = "product_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_name")
    private String productName;
    private int quantity;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "products",optional = true)
    @JsonManagedReference
    private ColorAnSize colorAnSize;
    private String image;
    private int discount;
    private double price;
    private int unitInStock;
    private int weight;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_supplier_id")
    @JsonManagedReference
    private Suppliers suppliers;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_category_id")
    @JsonManagedReference
    private Category category;
}
