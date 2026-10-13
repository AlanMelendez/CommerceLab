package com.alan.commercelab.orders.service;


import com.alan.commercelab.orders.dto.OrderResponse;
import com.alan.commercelab.orders.interfaces.IOrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {
    private final List<OrderResponse> orders = List.of(
            new OrderResponse("ORD-001","PENDING"),
            new OrderResponse("ORD-002","CONFIRMED")

    );

    @Override
    public List<OrderResponse> findAll(){
        return orders;
    }

    @Override
    public Optional<OrderResponse> findById(String orderId) {
        return orders.stream()
                .filter(orderResponse -> orderResponse.id().equals(orderId))
                .findFirst();
    }
}
