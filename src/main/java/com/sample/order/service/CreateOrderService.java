package com.sample.order.service;

import com.sample.flow.FlowManager;
import com.sample.order.model.OrderRequest;
import com.sample.order.orderprocess.OrderProcessingData;
import com.sample.order.orderprocess.OrderProcessingWorkflow;

public class CreateOrderService {

    private final OrderProcessingWorkflow orderProcessingWorkflow;

    public CreateOrderService(OrderProcessingWorkflow orderProcessingWorkflow) {
        this.orderProcessingWorkflow = orderProcessingWorkflow;
    }


    public void createOrder(OrderRequest request) {

        validateRequest(request);

        FlowManager.processDefinition(map(request), orderProcessingWorkflow.getFlowDefinition());

    }

    private void validateRequest(OrderRequest request) {
        //preform any validation
        //ideally validation should be performed as early as possible
    }

    public OrderProcessingData map(OrderRequest request) {
        return new OrderProcessingData(request.getCustomerId(), request.getProductId(), request.getOrderAmount());
    }
}
