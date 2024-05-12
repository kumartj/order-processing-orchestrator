package com.sample.order.service;

import com.sample.flow.FlowManager;
import com.sample.order.model.OrderRequest;
import com.sample.order.orderprocess.OrderProcessingData;
import com.sample.order.orderprocess.CreateOrderProcessingFlow;

import static com.sample.flow.FlowManager.execute;

public class CreateOrderService {

    private final CreateOrderProcessingFlow createOrderProcessFlow;

    public CreateOrderService(CreateOrderProcessingFlow createOrderProcessFlow) {
        this.createOrderProcessFlow = createOrderProcessFlow;
    }


    public void createOrder(OrderRequest request) {

        validateRequest(request);

        execute(createOrderProcessFlow.getFlowDefinition(), map(request));

    }

    private void validateRequest(OrderRequest request) {
        //preform any validation

    }

    public OrderProcessingData map(OrderRequest request) {
        return new OrderProcessingData(request.getCustomerId(), request.getProductId(), request.getOrderAmount());
    }
}
