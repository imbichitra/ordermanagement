package com.ordermanagement.dto;

import lombok.Data;

@Data
public class ProductReq {
    private Long productId;
    private String color;
    private String size;
    private int quantity;
}
