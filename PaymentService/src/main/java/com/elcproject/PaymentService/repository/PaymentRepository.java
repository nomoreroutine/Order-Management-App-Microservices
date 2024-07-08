package com.elcproject.PaymentService.repository;

import com.elcproject.PaymentService.model.dto.PaymentDto;
import com.elcproject.PaymentService.model.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Payment findByOrderId(long orderId);

}
