package com.alan.commercelab.orders.service;


import com.alan.commercelab.orders.dto.CreateOrderRequest;
import com.alan.commercelab.orders.dto.OrderResponse;
import com.alan.commercelab.orders.exception.OrderNotFoundException;
import com.alan.commercelab.orders.interfaces.IOrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderServiceImpl implements IOrderService {
    private final List<OrderResponse> orders = new ArrayList<>( List.of(
            new OrderResponse(
                    "ORD-1001",
                    "CUS-001",
                    "PROD-001",
                    2,
                    "PENDING"
            ),
            new OrderResponse(
                    "ORD-1002",
                    "CUS-002",
                    "PROD-002",
                    1,
                    "CONFIRMED"
            )

    ));

    @Override
    public List<OrderResponse> findAll(){
        return orders;
    }

    @Override
    public OrderResponse findById(String orderId) {
        return orders.stream()
                .filter(orderResponse -> orderResponse.id().equals(orderId))
                .findFirst()
                .orElseThrow(()-> new OrderNotFoundException(orderId));
    }

    @Override
    public OrderResponse create(CreateOrderRequest request) {
        String orderId = "ORD-" + UUID.randomUUID().toString().substring(0,0).toUpperCase();

        OrderResponse newOrder = new OrderResponse(
                orderId,
                request.customerId(),
                request.productId(),
                request.quantity(),
                "PENDING"
        );

        orders.add(newOrder);

        return newOrder;
    }
}
