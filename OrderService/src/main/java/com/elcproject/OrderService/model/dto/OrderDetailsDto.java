package com.elcproject.OrderService.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailsDto {
    private long orderId;
    private int quantity;
    private long total;
    private String status;
    private LocalDateTime date;
    private ProductDetailsDto product;
    private PaymentDetailsDto payment;




}
