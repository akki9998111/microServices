package com.ankit.order.service;

import com.ankit.order.entity.Order;
import com.ankit.order.exception.CustomException;
import com.ankit.order.external.clients.PaymentService;
import com.ankit.order.external.clients.ProductService;
import com.ankit.order.external.request.PaymentRequest;
import com.ankit.order.model.OrderResponse;
import com.ankit.order.model.OrederRequest;
import com.ankit.order.repository.OrderRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Locale;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService{
   @Autowired
    private OrderRepository orderRepository;
   @Autowired
   private ProductService productService;
   @Autowired
   private PaymentService paymentService;
    @Override
    public long placeOrder(OrederRequest orderRequest) {

        productService.reduceQuantity(orderRequest.getProductId(),orderRequest.getQuantity());
        //
        Order order = Order.builder().productId(orderRequest.getProductId())
                .quantity(orderRequest.getQuantity())
                .amount(orderRequest.getAmount())
                .orderStatus("CREATED")
                .orderDate(Instant.now())
                .build();
        order = orderRepository.save(order);
        log.info("calling Paymet service");
        PaymentRequest paymentRequest = PaymentRequest.builder()
                .orderId(order.getId())
                .mode(orderRequest.getPaymentMode())
                .amount(orderRequest.getAmount())
                .build();
        try {
            paymentService.doPayment(paymentRequest);
            order.setOrderStatus("PaymentSuccess");
            log.info("success Paymet service");
        } catch (Exception e){
            log.info("fail Paymet service");
            order.setOrderStatus("PaymentFailed");
        }
        order = orderRepository.save(order);

        log.info("order Placed" ,order.getId());
        return order.getId();
    }

    @Override
    public OrderResponse getOrder(long orderId) {
        Order order =orderRepository.findById(orderId).orElseThrow(()->new CustomException("order not found ","not found",404));
        OrderResponse orderResponse = OrderResponse.builder()
                .orderId(order.getId())
                .orderDate(order.getOrderDate())
                .orderStatus(order.getOrderStatus())
                .build();
        return orderResponse;
    }
}
