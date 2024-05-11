package com.sample.order.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class PaymentProcessingService {

    private final Logger log = LoggerFactory.getLogger(PaymentProcessingService.class);
    public void processPayment(String customerId, BigDecimal amount){
        log.info("Retrieving payment information for the Customer " + customerId);
        log.info("process payment information for the Customer " + customerId + " for amount " + amount);
    }
}
