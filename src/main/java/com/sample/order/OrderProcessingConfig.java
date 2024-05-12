package com.sample.order;

import com.sample.order.orderprocess.CreateOrderProcessingFlow;
import com.sample.order.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderProcessingConfig {

    @Bean
    public InventoryService inventoryService() {
        return new InventoryService();
    }

    @Bean
    public NotificationService notificationService(CustomerPreferenceService customerPreferenceService) {
        return new NotificationService(customerPreferenceService);
    }

    @Bean
    public CustomerPreferenceService customerPreferenceService() {
        return new CustomerPreferenceService();
    }

    @Bean
    public PaymentProcessingService paymentProcessingService() {
        return new PaymentProcessingService();
    }


    @Bean("OrderProcessingWorkflow")
    public CreateOrderProcessingFlow orderProcessingWorkflow(InventoryService inventoryService, PaymentProcessingService paymentProcessingService,
                                                             NotificationService notificationService) {
        return new CreateOrderProcessingFlow(inventoryService, paymentProcessingService, notificationService );
    }

    @Bean
    public CreateOrderService createOrderService(CreateOrderProcessingFlow processingWorkflow) {
        return new CreateOrderService(processingWorkflow);
    }
}
