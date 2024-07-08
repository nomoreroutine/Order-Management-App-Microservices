package com.elcproject.OrderService.exception;

import com.elcproject.OrderService.model.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(InsufficientStockException.class)
    public ResponseEntity<ErrorDto> handleInsufficientStockException(InsufficientStockException ex, WebRequest webRequest){

        ErrorDto errorDto = new ErrorDto(
                ex.getMessage(),
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                HttpStatus.UNPROCESSABLE_ENTITY,
                LocalDateTime.now(),
                webRequest.getDescription(false)

        );
        return new ResponseEntity<>(errorDto,HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDto> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest webRequest) {

        ErrorDto errorDto = new ErrorDto(
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND,
                LocalDateTime.now(),
                webRequest.getDescription(false)
        );

        return new ResponseEntity<>(errorDto,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(UnknownException.class)
    public ResponseEntity<ErrorDto> handleUnknownException(UnknownException ex, WebRequest webRequest){

        ErrorDto errorDto = new ErrorDto(
                ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                LocalDateTime.now(),
                webRequest.getDescription(false)

        );
        return new ResponseEntity<>(errorDto,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ServiceNotAvailableException.class)
    public ResponseEntity<ErrorDto> handleServiceNotAvailableException(ServiceNotAvailableException ex, WebRequest webRequest){

        ErrorDto errorDto = new ErrorDto(
                ex.getMessage(),
                HttpStatus.SERVICE_UNAVAILABLE.value(),
                HttpStatus.SERVICE_UNAVAILABLE,
                LocalDateTime.now(),
                webRequest.getDescription(false)

        );
        return new ResponseEntity<>(errorDto,HttpStatus.SERVICE_UNAVAILABLE);
    }
}
