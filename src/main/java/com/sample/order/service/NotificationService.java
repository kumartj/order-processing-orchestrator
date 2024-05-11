package com.sample.order.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotificationService {

    private final Logger log = LoggerFactory.getLogger(NotificationService.class);
    private final CustomerPreferenceService customerPreferenceService;

    public NotificationService(CustomerPreferenceService customerPreferenceService) {
        this.customerPreferenceService = customerPreferenceService;
    }

    public void notify(String customerId) {
        customerPreferenceService.retrievePreference(customerId);
        log.info("Notify Customer : " + customerId);
    }
}
