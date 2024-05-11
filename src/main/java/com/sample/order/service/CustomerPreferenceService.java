package com.sample.order.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerPreferenceService {

    private final Logger log = LoggerFactory.getLogger(CustomerPreferenceService.class);
    public void retrievePreference(String customerId) {
        log.info("Retrieving Customer Preferences for customer " + customerId);
    }
}
