package com.elcproject.CloudGateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/product-fallback")
    public ResponseEntity<String> productServiceFallback() {
        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("PRODUCT SERVICE IS NOT AVAILABLE! PLEASE TRY AGAIN LATER");
    }

    @GetMapping("/payment-fallback")
    public ResponseEntity<String> paymentServiceFallback() {
        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("PAYMENT SERVICE IS NOT AVAILABLE! PLEASE TRY AGAIN LATER");
    }

    @GetMapping("/order-fallback")
    public ResponseEntity<String> orderServiceFallback() {
        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("ORDER SERVICE IS NOT AVAILABLE! PLEASE TRY AGAIN LATER");
    }
}
