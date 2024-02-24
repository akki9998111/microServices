package com.ankit.order.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrederRequest {

    private long productId;
    private long quantity;
    private long amount;
    private PaymentMode paymentMode;
}
