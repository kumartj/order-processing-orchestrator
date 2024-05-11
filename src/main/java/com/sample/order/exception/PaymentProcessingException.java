package com.sample.order.exception;

public class PaymentProcessingException extends Exception {

    private String message;

    public  PaymentProcessingException(String message) {
        super(message);
        this.message = message;
    }
}
