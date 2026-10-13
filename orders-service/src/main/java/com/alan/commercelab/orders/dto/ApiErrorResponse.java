package com.alan.commercelab.orders.dto;

import java.time.Instant;

public record ApiErrorResponse (
        String code,
        String message,
        int status,
        String path,
        Instant timestamp
){}