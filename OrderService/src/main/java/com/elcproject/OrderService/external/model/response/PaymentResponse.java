package com.elcproject.OrderService.external.model.response;

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
public class PaymentResponse {

    private long paymentId;
    private PaymentType paymentType;
    private String status;
    private long total;
    private LocalDateTime date;
}
