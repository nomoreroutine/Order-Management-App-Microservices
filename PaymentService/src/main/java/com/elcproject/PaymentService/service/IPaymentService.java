package com.elcproject.PaymentService.service;

import com.elcproject.PaymentService.model.dto.PaymentDetailsDto;
import com.elcproject.PaymentService.model.dto.PaymentDto;

public interface IPaymentService {
    void doPayment(PaymentDto paymentDto);

    PaymentDetailsDto getPaymentByOrderId(String orderId);
}
