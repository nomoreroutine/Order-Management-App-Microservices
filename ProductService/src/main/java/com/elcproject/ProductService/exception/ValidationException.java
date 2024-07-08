package com.elcproject.ProductService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidationException extends RuntimeException{
    public ValidationException(String resource, String field1, String field2) {
        super(String.format("%s Validation Error! Please check the %s  %s values.", resource, field1, field2));
    }
}
