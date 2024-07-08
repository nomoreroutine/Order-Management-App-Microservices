package com.elcproject.PaymentService.service.impl;

import com.elcproject.PaymentService.constants.PaymentStatus;
import com.elcproject.PaymentService.exception.PaymentRejectedException;
import com.elcproject.PaymentService.model.dto.PaymentDetailsDto;
import com.elcproject.PaymentService.model.dto.PaymentDto;
import com.elcproject.PaymentService.model.entity.Payment;
import com.elcproject.PaymentService.model.mapper.PaymentMapper;
import com.elcproject.PaymentService.repository.PaymentRepository;
import com.elcproject.PaymentService.service.IPaymentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Log4j2
public class PaymentServiceImpl implements IPaymentService {

    private PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void doPayment(PaymentDto paymentDto) {

       Payment payment =  PaymentMapper.mapPaymentDtoToPayment(paymentDto, new Payment());
       payment.setStatus(PaymentStatus.PAYMENT_SUCCESS);
       payment.setDate(LocalDateTime.now());
       paymentRepository.save(payment);
    }

    @Override
    public PaymentDetailsDto getPaymentByOrderId(String orderId) {

       Payment payment = paymentRepository.findByOrderId(Long.valueOf(orderId));

       return PaymentMapper.mapPaymentToPaymentDetailsDto(payment, new PaymentDetailsDto());
    }
}
