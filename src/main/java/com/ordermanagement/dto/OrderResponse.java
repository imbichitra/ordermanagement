package com.ordermanagement.dto;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.ordermanagement.models.OrderDetail;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderResponse {
    private Long id;
    private String shippingId;
    private Date shippingDate;
    private String orderNo;
    private List<OrderDetailResponse> orderDetail;
}
