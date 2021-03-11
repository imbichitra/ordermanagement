package com.ordermanagement.dto;


import lombok.Data;

@Data
public class ProductRequest {
    private Long supplierId;
    private Long categoryId;
    private String productName;
    private int quantity;
    private ColorsAndSize colorAnSizes;
    private String image;
    private int discount;
    private int unitInStock;
    private int weight;
    private double price;
}
