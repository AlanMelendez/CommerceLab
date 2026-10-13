package com.alan.commercelab.orders.exception;


import com.alan.commercelab.orders.dto.ApiErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleOrderNotFound(
            OrderNotFoundException exception,
            HttpServletRequest request
    ){
        ApiErrorResponse error = new ApiErrorResponse(
                "ORDER_NOT_FOUND",
                exception.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                request.getRequestURI(),
                Instant.now()
        );

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(error);
    }

    //Method to handle parameters validation (Jakarta)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> handleValidation(
            MethodArgumentNotValidException exception,
            HttpServletRequest request
    ){
        System.out.println("Exception message: "+ exception.getMessage());        String message = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(
                        error -> error.getField()+": "+ error.getDefaultMessage()
                )
                .collect(Collectors.joining("; "));

        ApiErrorResponse error = new ApiErrorResponse(
                "VALIDATION_ERROR",
                message,
                HttpStatus.BAD_REQUEST.value(),
                request.getRequestURI(),
                Instant.now()
        );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(error);

    }
}
