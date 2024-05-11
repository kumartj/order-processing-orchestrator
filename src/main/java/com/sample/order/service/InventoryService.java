package com.sample.order.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class InventoryService {

    private final Logger log = LoggerFactory.getLogger(InventoryService.class);

    public String holdProduct(String customerId, String productId)   {
        log.info("putting an hold on product :"+ productId);
        return UUID.randomUUID().toString();
    }

    public void clearHoldProduct(String customerId, String productId, String inventoryId) {
        log.info("clearing an hold on product :"+ productId + " for inventory : " + inventoryId );
    }
}
