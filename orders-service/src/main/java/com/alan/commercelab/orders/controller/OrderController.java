package com.alan.commercelab.orders.controller;

import com.alan.commercelab.orders.dto.OrderResponse;
import com.alan.commercelab.orders.service.OrderServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderServiceImpl orderServiceImpl;

    public OrderController(OrderServiceImpl orderServiceImpl){
        this.orderServiceImpl = orderServiceImpl;
    }

    @GetMapping
    public List<OrderResponse> getOrders(){
        return orderServiceImpl.findAll();
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable String orderId){

        OrderResponse order = orderServiceImpl.findById(orderId);

        return ResponseEntity.ok(order);

    }
}
