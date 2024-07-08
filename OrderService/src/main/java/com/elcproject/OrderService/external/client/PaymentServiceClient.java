package com.elcproject.OrderService.external.client;

import com.elcproject.OrderService.config.FeignConfig;
import com.elcproject.OrderService.exception.ServiceNotAvailableException;
import com.elcproject.OrderService.external.model.dto.PaymentDto;
//import com.elcproject.OrderService.external.model.dto.ResponseDto;
import com.elcproject.OrderService.model.dto.ResponseDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CircuitBreaker(name = "external", fallbackMethod = "fallback")
@FeignClient(name = "PaymentService/v1/payments", configuration = FeignConfig.class)
public interface PaymentServiceClient {
    @PostMapping("/do")
    ResponseEntity<ResponseDto> doPayment(@RequestBody PaymentDto paymentDto);

    default ResponseEntity<ResponseDto> fallback(Exception ex) {
        throw new ServiceNotAvailableException("Payment");
    }
}
