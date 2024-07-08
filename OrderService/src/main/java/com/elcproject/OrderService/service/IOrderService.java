package com.elcproject.OrderService.service;

import com.elcproject.OrderService.model.dto.OrderDetailsDto;
import com.elcproject.OrderService.model.dto.OrderDto;

public interface IOrderService {
    long createOrder(OrderDto orderDto);

    //OrderDto getOrderById(Long orderId);

    OrderDetailsDto getOrderDetailsById(Long orderId);
}
