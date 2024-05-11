package com.sample.order.orderprocess;

import java.math.BigDecimal;

public class OrderProcessingData {

    private final String customerId;

    private final String productId;

    private final BigDecimal amount;

    public OrderProcessingData(String customerId, String productId, BigDecimal amount) {
        this.customerId = customerId;
        this.productId = productId;
        this.amount = amount;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getProductId() {
        return productId;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
