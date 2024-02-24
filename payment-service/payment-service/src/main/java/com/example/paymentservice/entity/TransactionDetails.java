package com.example.paymentservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.Instant;
@Entity
@Table(name = "TRANCATION_Details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "orderId")
    private long orderId;
    @Column(name = "mode")
    private String mode;
    @Column(name = "paymentDate")
    private Instant paymentDate;
    @Column(name = "referenceNo")
    private String referenceNo;
    @Column(name = "amount")
    private long amount;
    @Column(name = "paymentStatus")
    private String paymentStatus;
}
