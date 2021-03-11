package com.ordermanagement.dto;

import lombok.Data;

@Data
public class OrderDetailResponse {
    private String productName;
    private double price;
    private Long quantity;
    private String size;
    private String color;
}
