package com.alan.commercelab.orders.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 *
 * @param customerId
 * @param productId
 * @param quantity
 *
 * Jakarta it's pretty similar to DataAnnotation in .NET
 */

public record CreateOrderRequest(
        @NotBlank(message = "customerId is required")
        String customerId,

        @NotBlank(message = "productId is required")
        String productId,

        @NotNull(message = "quantity is required")
        @Positive(message = "quantity must be greater than zero")
        Integer quantity
) {
}
