package com.alan.commercelab.orders.interfaces;

import com.alan.commercelab.orders.dto.OrderResponse;

import java.util.List;
import java.util.Optional;


public interface IOrderService {
    List<OrderResponse> findAll();

    Optional<OrderResponse> findById(String orderId);
}
