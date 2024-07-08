package com.elcproject.OrderService.service.impl;

import com.elcproject.OrderService.constants.OrderStatus;
import com.elcproject.OrderService.exception.ResourceNotFoundException;
import com.elcproject.OrderService.external.client.PaymentServiceClient;
import com.elcproject.OrderService.external.client.ProductServiceClient;
import com.elcproject.OrderService.external.model.dto.PaymentDto;
import com.elcproject.OrderService.model.dto.OrderDetailsDto;
import com.elcproject.OrderService.model.dto.OrderDto;
import com.elcproject.OrderService.model.dto.PaymentDetailsDto;
import com.elcproject.OrderService.model.dto.ProductDetailsDto;
import com.elcproject.OrderService.model.entity.Order;
import com.elcproject.OrderService.model.mapper.OrderMapper;
import com.elcproject.OrderService.repository.OrderRepository;
import com.elcproject.OrderService.service.IOrderService;

import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
@Log4j2
public class OrderServiceImpl implements IOrderService {

    private final OrderRepository orderRepository;

    @Autowired
    private ProductServiceClient productService;

    @Autowired
    private PaymentServiceClient paymentService;

    @Autowired
    private RestTemplate restTemplate;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public long createOrder(OrderDto orderDto) {

        log.info("Calling the Product-Service to check the stock.");
        productService.reduceStockById(orderDto.getProductId(), orderDto.getQuantity());
        orderDto.setStatus(OrderStatus.ORDER_REQUESTED);

        Order order = OrderMapper.mapOrderDtoToOrder(orderDto, new Order());
        order.setDate(LocalDateTime.now());
        orderRepository.save(order);
        log.info(OrderStatus.ORDER_REQUESTED);

        log.info("Calling the Payment-Service to check the payment status.");
        PaymentDto paymentDto = PaymentDto.builder()
                .orderId(order.getOrderId())
                .paymentType(orderDto.getPaymentType())
                .total(orderDto.getTotal())
                .build();

        String status = null;
        try{
            paymentService.doPayment(paymentDto);
            status = OrderStatus.ORDER_CONFIRMED;
            log.info("Order Status : " + status);
        }catch (Exception e){
            status = OrderStatus.PAYMENT_FAILED;
            log.error("Order Status : " + status);
        }

        order.setStatus(status);
        order.setDate(LocalDateTime.now());
        orderRepository.save(order);

        return order.getOrderId();
    }

    @Override
    public OrderDetailsDto getOrderDetailsById(Long orderId) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order","Order Id", orderId.toString())
        );

        ProductDetailsDto productDetailsDto = restTemplate.getForObject("http://ProductService/v1/products/" + order.getProductId(), ProductDetailsDto.class);
        PaymentDetailsDto paymentDetailsDto = restTemplate.getForObject("http://PaymentService/v1/payments/order/" + order.getOrderId(), PaymentDetailsDto.class);

        OrderDetailsDto orderDetailsDto = OrderMapper.mapOrderToOrderDetailsDto(order, new OrderDetailsDto());
        orderDetailsDto.setProduct(productDetailsDto);
        orderDetailsDto.setPayment(paymentDetailsDto);

        log.info(orderDetailsDto);

        return orderDetailsDto;
    }
}
