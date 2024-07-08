package com.elcproject.PaymentService.constants;

import com.elcproject.PaymentService.model.entity.Payment;

public class PaymentStatus {
    public static final String PAYMENT_INITIATED = "PAYMENT_INITIATED";
    public static final String PAYMENT_SUCCESS = "PAYMENT_SUCCESS";
    public static final String PAYMENT_FAILED = "PAYMENT_FAILED";

    private PaymentStatus() {
    }
}


