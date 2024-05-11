package com.sample.order.model;

import java.math.BigDecimal;

public class OrderRequest {

    private   BigDecimal orderAmount;

    private   String customerId;

    private   String productId;

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getProductId() {
        return productId;
    }
}
