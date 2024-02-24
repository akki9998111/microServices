package com.example.paymentservice.service;

import com.example.paymentservice.entity.TransactionDetails;
import com.example.paymentservice.model.PaymentRequest;
import com.example.paymentservice.repository.TransactionDetailsRepo;
import lombok.Builder;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private TransactionDetailsRepo transactionDetailsRepo;
    @Override
    public Long doPaymet(PaymentRequest paymentRequest) {
        log.info("Recording payment details ");
        TransactionDetails transactionDetails = TransactionDetails.builder()
                .amount(paymentRequest.getAmount())
                .mode(String.valueOf(paymentRequest.getMode()))
                .paymentStatus("Success")
                .paymentDate(Instant.now())
                .referenceNo(paymentRequest.getReferenceNo())
                .build();
        TransactionDetails transactionDetail =  transactionDetailsRepo.save(transactionDetails);
        log.info("Success payment details ");
        return transactionDetail.getId();
    }
}
