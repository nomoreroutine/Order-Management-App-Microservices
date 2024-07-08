package com.elcproject.PaymentService.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "PAYMENTS")
@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payment extends Base{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long paymentId;

    @Column(name = "order_id")
    private long orderId;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "status")
    private String status;

    @Column(name = "total")
    private long total;

    @Column(name = "date")
    private LocalDateTime date;
}
