package com.elcproject.OrderService.model.dto;

import com.elcproject.OrderService.external.model.response.PaymentResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {

    private long productId;

    private int quantity;

    private String status;

    private LocalDateTime date;

    private PaymentType paymentType;

    private long total;

}
