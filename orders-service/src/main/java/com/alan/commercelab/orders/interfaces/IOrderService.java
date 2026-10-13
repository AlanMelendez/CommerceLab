package com.alan.commercelab.orders.interfaces;

import com.alan.commercelab.orders.dto.CreateOrderRequest;
import com.alan.commercelab.orders.dto.OrderResponse;

import java.util.List;
import java.util.Optional;


public interface IOrderService {
    List<OrderResponse> findAll();

    OrderResponse findById(String orderId);

    OrderResponse create(CreateOrderRequest request);
}
