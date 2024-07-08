package com.elcproject.ProductService.model.dto;

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

    private String message; //detail
    private int code; //status
    private HttpStatus status;  //title
    private LocalDateTime timestamp;
    private String uriPath;
}
