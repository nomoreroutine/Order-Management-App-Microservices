package com.elcproject.ProductService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class InsufficientStockException extends RuntimeException{

    public InsufficientStockException() {
        super("Insufficient Stock! Requested quantity exceeds available stock.");
    }
}

