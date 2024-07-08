package com.elcproject.OrderService.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "ORDERS")
@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @Column(name = "product_id")
    private long productId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "order_date")
    private LocalDateTime date;

    @Column(name = "status")
    private String status;

    @Column(name = "total_price")
    private long total;


}
