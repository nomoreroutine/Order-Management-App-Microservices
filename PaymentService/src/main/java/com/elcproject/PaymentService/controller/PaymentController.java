package com.elcproject.PaymentService.controller;

import com.elcproject.PaymentService.model.dto.PaymentDetailsDto;
import com.elcproject.PaymentService.model.dto.PaymentDto;
import com.elcproject.PaymentService.model.dto.ResponseDto;
import com.elcproject.PaymentService.service.IPaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/payments")
public class PaymentController {
    private IPaymentService iPaymentService;

    public PaymentController(IPaymentService iPaymentService) {
        this.iPaymentService = iPaymentService;
    }

    @PostMapping("/do")
    public ResponseEntity<ResponseDto> doPayment(@RequestBody PaymentDto paymentDto) {

        iPaymentService.doPayment(paymentDto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto("Payment created successfully", 200));
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<PaymentDetailsDto> getPaymentByOrderId(@PathVariable String orderId) {

        PaymentDetailsDto paymentDetailsDto = iPaymentService.getPaymentByOrderId(orderId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(paymentDetailsDto);
    }
}
