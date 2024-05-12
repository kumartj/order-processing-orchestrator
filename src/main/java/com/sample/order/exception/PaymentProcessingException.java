package com.sample.order.exception;

public class PaymentProcessingException extends RuntimeException {

    private String message;

    public  PaymentProcessingException(String message) {
        super(message);
        this.message = message;
    }
}
