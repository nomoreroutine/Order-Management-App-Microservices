package com.elcproject.PaymentService.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDto {

    private String message;
    private int code;
    private HttpStatus status;
    private LocalDateTime timestamp;
    private String uriPath;
}
