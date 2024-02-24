package com.ankit.order.external.request;

import com.ankit.order.model.PaymentMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentRequest {

    private  long orderId;
    private long amount;
    private String referenceNo;
    private PaymentMode mode;
}
