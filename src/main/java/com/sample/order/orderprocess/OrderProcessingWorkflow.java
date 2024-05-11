package com.sample.order.orderprocess;

import com.sample.order.service.InventoryService;
import com.sample.order.service.NotificationService;
import com.sample.order.service.PaymentProcessingService;
import com.sample.saga.Step;
import com.sample.saga.StepDefinition;


public class OrderProcessingSaga {

    private final InventoryService inventoryService;
    private final PaymentProcessingService paymentProcessingService;

    private final NotificationService notificationService;

    private final StepDefinition.StepDefinitionBuilder<OrderProcessingData> any = new StepDefinition.StepDefinitionBuilder<OrderProcessingData>();

    private final Step<OrderProcessingData> orderProcessingSagaStepDefinition
            =  StepDefinition.StepDefinitionBuilder.step(1).build();



    public OrderProcessingSaga(InventoryService inventoryService, PaymentProcessingService paymentProcessingService, NotificationService notificationService) throws Exception {
        this.inventoryService = inventoryService;
        this.paymentProcessingService = paymentProcessingService;
        this.notificationService = notificationService;
    }

    private void createOrder(OrderProcessingData data) {

    }

    private void holdInventory(OrderProcessingData data)  {
        String inventoryHoldId = inventoryService.holdProduct(data.getCustomerId(), data.getProductId());
       // state.setInventoryHoldId(inventoryHoldId);
    }

    private void clearInventory(OrderProcessingData data, OrderProcessingState state) throws  InterruptedException {
        inventoryService.clearHoldProduct(data.getCustomerId(), data.getProductId(), state.getInventoryHoldId());
    }

    private void processPayment(OrderProcessingData data, OrderProcessingState state) {
        paymentProcessingService.processPayment(data.getCustomerId(), data.getAmount());
    }

    private void sendNotification(OrderProcessingData data, OrderProcessingState state) {
        notificationService.notify(data.getCustomerId());
    }

    public StepDefinition<OrderProcessingSaga> getStepDefinition() {
        return orderProcessingSagaStepDefinition;
    }
}
