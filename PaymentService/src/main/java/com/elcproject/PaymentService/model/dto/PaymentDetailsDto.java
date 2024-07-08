package com.elcproject.PaymentService.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDetailsDto {

    private long paymentId;
    private long orderId;
    private PaymentType paymentType;
    private String status;
    private long total;
    private LocalDateTime date;
}