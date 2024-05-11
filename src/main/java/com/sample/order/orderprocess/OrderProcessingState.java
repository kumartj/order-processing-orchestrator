package com.sample.order.orderprocess;

import com.sample.flow.StepDefinitionStateStore;


public class OrderProcessingState implements StepDefinitionStateStore<OrderProcessingState> {

    private   String inventoryHoldId;

    public String getInventoryHoldId() {
        return inventoryHoldId;
    }

    public void setInventoryHoldId(String inventoryHoldId) {
        this.inventoryHoldId = inventoryHoldId;
    }

    @Override
    public OrderProcessingState initialize() {
        return new OrderProcessingState();
    }
}
