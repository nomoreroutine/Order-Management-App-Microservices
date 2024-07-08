package com.elcproject.PaymentService.exception;

public class PaymentRejectedException extends RuntimeException {

    public PaymentRejectedException(String message) {
        super("Payment was rejected. Please check your account or contact your bank for more details.");
    }
}
