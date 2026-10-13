package com.alan.commercelab.orders.controller;

import com.alan.commercelab.orders.dto.OrderResponse;
import com.alan.commercelab.orders.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderResponse> getOrders(){
        return orderService.findAll();
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable String orderId){

        return orderService.findById(orderId)
                .map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());

    }
}
