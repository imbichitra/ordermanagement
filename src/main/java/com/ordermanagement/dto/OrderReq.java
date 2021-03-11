package com.ordermanagement.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderReq {
    private Long customerId;
    private List<ProductReq> productData;
}
