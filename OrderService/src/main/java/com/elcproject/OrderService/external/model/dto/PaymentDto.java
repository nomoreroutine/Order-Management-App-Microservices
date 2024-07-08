package com.elcproject.OrderService.external.model.dto;

import com.elcproject.OrderService.model.dto.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {

    private long orderId;
    private PaymentType paymentType;
    private String status;
    private long total;
    private LocalDateTime date;
}
