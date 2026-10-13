package com.alan.commercelab.orders.dto;

public record OrderResponse(
        String id,
        String customerId,
        String productId,
        Integer quantity,
        String status
){}
