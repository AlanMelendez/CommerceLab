package com.alan.commercelab.orders.exception;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(String orderId){
        super("OrderNotFound "+ orderId);
    }
}
