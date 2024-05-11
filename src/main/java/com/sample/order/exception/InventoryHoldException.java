package com.sample.order.exception;

public class InventoryHoldException extends  RuntimeException{

    public InventoryHoldException(String message) {
        super(message);
    }
}
