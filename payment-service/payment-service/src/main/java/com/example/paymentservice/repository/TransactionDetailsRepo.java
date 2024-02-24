package com.example.paymentservice.repository;

import com.example.paymentservice.entity.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionDetailsRepo extends JpaRepository<TransactionDetails, Long> {
}
