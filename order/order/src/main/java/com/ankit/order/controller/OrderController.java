package com.ankit.order.controller;

import com.ankit.order.model.OrderResponse;
import com.ankit.order.model.OrederRequest;
import com.ankit.order.service.OrderService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@Log4j2
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/placeOrder")
    public ResponseEntity<Long> placeOrder(@RequestBody OrederRequest orederRequest) {

        long orderId = orderService.placeOrder(orederRequest);
        log.info("order placed for orderId::", orderId);

        return new ResponseEntity<>(orderId, HttpStatus.CREATED);
    }

    @GetMapping("/getOrder/{orderId}")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable long orderId) {
        OrderResponse orderResponse = orderService.getOrder(orderId);
        return new ResponseEntity<OrderResponse>(orderResponse, HttpStatus.OK);
    }
}
