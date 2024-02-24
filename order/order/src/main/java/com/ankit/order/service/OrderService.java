package com.ankit.order.service;

import com.ankit.order.model.OrderResponse;
import com.ankit.order.model.OrederRequest;

public interface OrderService {
    long placeOrder(OrederRequest orederRequest);

    OrderResponse getOrder(long orderId);
}
