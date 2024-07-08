package com.elcproject.PaymentService.model.mapper;

import com.elcproject.PaymentService.model.dto.PaymentDetailsDto;
import com.elcproject.PaymentService.model.dto.PaymentDto;
import com.elcproject.PaymentService.model.dto.PaymentType;
import com.elcproject.PaymentService.model.entity.Payment;

public class PaymentMapper {

    public static PaymentDto mapPaymentToPaymentDto(Payment payment, PaymentDto paymentDto) {

        paymentDto.setOrderId(payment.getOrderId());
        paymentDto.setPaymentType(PaymentType.valueOf(payment.getPaymentType()));
        paymentDto.setStatus(payment.getStatus());
        paymentDto.setTotal(payment.getTotal());
        paymentDto.setDate(payment.getDate());

        return paymentDto;
    }

    public static Payment mapPaymentDtoToPayment(PaymentDto paymentDto, Payment payment) {

        payment.setOrderId(paymentDto.getOrderId());
        payment.setPaymentType(String.valueOf(paymentDto.getPaymentType()));
        payment.setStatus(paymentDto.getStatus());
        payment.setTotal(paymentDto.getTotal());
        payment.setDate(paymentDto.getDate());

        return payment;
    }

    public static PaymentDetailsDto mapPaymentToPaymentDetailsDto(Payment payment, PaymentDetailsDto paymentDetailsDto) {

        paymentDetailsDto.setPaymentId(payment.getPaymentId());
        paymentDetailsDto.setOrderId(payment.getOrderId());
        paymentDetailsDto.setPaymentType(PaymentType.valueOf(payment.getPaymentType()));
        paymentDetailsDto.setStatus(payment.getStatus());
        paymentDetailsDto.setTotal(payment.getTotal());
        paymentDetailsDto.setDate(payment.getDate());

        return paymentDetailsDto;
    }
}
