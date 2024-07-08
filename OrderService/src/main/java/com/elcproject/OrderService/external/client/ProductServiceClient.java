package com.elcproject.OrderService.external.client;

import com.elcproject.OrderService.config.FeignConfig;
import com.elcproject.OrderService.exception.ServiceNotAvailableException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@CircuitBreaker(name = "external", fallbackMethod = "fallback")
@FeignClient(name = "ProductService/v1/products", configuration = FeignConfig.class)
public interface ProductServiceClient {

    @PutMapping("/reduceStock/{id}")
    ResponseEntity<Void> reduceStockById(@PathVariable("id") long productId,
                                                @RequestParam int quantity);

    default ResponseEntity<Void> fallback(Exception ex) {
        throw new ServiceNotAvailableException("Product");
    }
}
