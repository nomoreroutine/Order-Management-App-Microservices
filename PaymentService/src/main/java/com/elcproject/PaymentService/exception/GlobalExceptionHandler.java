package com.elcproject.PaymentService.exception;

import com.elcproject.PaymentService.model.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PaymentRejectedException.class)
    public ResponseEntity<ErrorDto> handlePaymentRejectedException(PaymentRejectedException ex, WebRequest webRequest) {

        ErrorDto errorDto = new ErrorDto(
                ex.getMessage(),
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                HttpStatus.UNPROCESSABLE_ENTITY,
                LocalDateTime.now(),
                webRequest.getDescription(false)

        );

        return new ResponseEntity<>(errorDto,HttpStatus.UNPROCESSABLE_ENTITY);
    }

}
