package com.sample.saga;

import com.sample.order.orderprocess.OrderProcessingState;

/**
 * A state Store during the execution of the step definition
 * @param <T>
 */
public interface StepDefinitionStateStore<T> {

    T initialize();
}
