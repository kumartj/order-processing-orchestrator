package com.sample.order.orderprocess;

import com.sample.flow.FlowDefinition;
import com.sample.flow.SimpleFlowDsl;
import com.sample.order.exception.InventoryHoldException;
import com.sample.order.exception.PaymentProcessingException;
import com.sample.order.service.InventoryService;
import com.sample.order.service.NotificationService;
import com.sample.order.service.PaymentProcessingService;


public class OrderProcessingWorkflow  implements  SimpleFlowDsl<OrderProcessingData> {

    private final InventoryService inventoryService;
    private final PaymentProcessingService paymentProcessingService;

    private final NotificationService notificationService;

    private final FlowDefinition<OrderProcessingData> orderProcessingDataFlowDefinition =
            step()
                    .invokeFunction(this::holdInventory)
                    .onreply(InventoryHoldException.class, this::clearInventory)
            .step()
                    .invokeFunction(this::processPayment)
                    .onreply(PaymentProcessingException.class, this::clearInventory)
            .step()
                    .invokeFunction(this::sendNotification)
            .build();



    public OrderProcessingWorkflow(InventoryService inventoryService, PaymentProcessingService paymentProcessingService, NotificationService notificationService)  {
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

    private void clearInventory(OrderProcessingData data)  {
        inventoryService.clearHoldProduct(data.getCustomerId(), data.getProductId()," state.getInventoryHoldId()");
    }

    private void processPayment(OrderProcessingData data) {
        paymentProcessingService.processPayment(data.getCustomerId(), data.getAmount());
    }

    private void sendNotification(OrderProcessingData data) {
        notificationService.notify(data.getCustomerId());
    }

    public FlowDefinition<OrderProcessingData> getFlowDefinition() {
        return orderProcessingDataFlowDefinition;
    }
}
