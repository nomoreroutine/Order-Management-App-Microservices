package com.elcproject.OrderService.controller;

import com.elcproject.OrderService.model.dto.OrderDetailsDto;
import com.elcproject.OrderService.model.dto.OrderDto;
import com.elcproject.OrderService.service.IOrderService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/orders")
public class OrderController {

    private IOrderService iOrderService;

    public OrderController(IOrderService iOrderService) {
        this.iOrderService = iOrderService;
    }

    @PostMapping("/createOrder")
    public ResponseEntity<Long> createOrder(@RequestBody OrderDto orderDto) {

        long orderId = iOrderService.createOrder(orderDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(orderId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDetailsDto> getOrderDetailsById(@PathVariable("id") Long orderId) {

        OrderDetailsDto orderDetailsDto = iOrderService.getOrderDetailsById(orderId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(orderDetailsDto);
    }
}
