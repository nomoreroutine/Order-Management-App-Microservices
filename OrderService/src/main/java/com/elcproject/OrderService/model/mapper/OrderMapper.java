package com.elcproject.OrderService.model.mapper;

import com.elcproject.OrderService.model.dto.OrderDetailsDto;
import com.elcproject.OrderService.model.dto.OrderDto;
import com.elcproject.OrderService.model.dto.PaymentType;
import com.elcproject.OrderService.model.entity.Order;

import java.time.LocalDateTime;

public class OrderMapper {

    public static Order mapOrderDtoToOrder (OrderDto orderDto, Order order) {

        order.setProductId(orderDto.getProductId());
        order.setQuantity(orderDto.getQuantity());
        order.setStatus(orderDto.getStatus());
        order.setDate(orderDto.getDate());
        order.setTotal(orderDto.getTotal());

        return order;
    }


    public static OrderDto mapOrderToOrderDto (Order order, OrderDto orderDto) {

        orderDto.setProductId(order.getProductId());
        orderDto.setQuantity(order.getQuantity());
        orderDto.setStatus(order.getStatus());
        orderDto.setDate(order.getDate());
        orderDto.setTotal(order.getTotal());

        return orderDto;
    }

    public static OrderDetailsDto mapOrderToOrderDetailsDto (Order order, OrderDetailsDto orderDetailsDto) {

        orderDetailsDto.setOrderId(order.getOrderId());
        orderDetailsDto.setQuantity(order.getQuantity());
        orderDetailsDto.setStatus(order.getStatus());
        orderDetailsDto.setDate(LocalDateTime.now());
        orderDetailsDto.setTotal(order.getTotal());

        return orderDetailsDto;

    }

}
