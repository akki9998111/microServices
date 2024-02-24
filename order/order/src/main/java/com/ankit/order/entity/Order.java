package com.ankit.order.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.Instant;

@Entity
@Table(name = "orderDetails")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "PRODUCT_Id")
    private long productId;
    @Column(name = "Quantity")
    private long quantity;
    @Column(name = "Order_Date")
    private Instant orderDate;
    @Column(name = "Order_Status")
    private String orderStatus;
    @Column(name = "Amount")
    private long amount;

}
