package com.example.paymentservice.service;

import com.example.paymentservice.model.PaymentRequest;

public interface PaymentService {
    Long doPaymet(PaymentRequest paymentRequest);
}
