package com.sample.flow;

/**
 * A state Store during the execution of the step definition
 * @param <T>
 */
public interface StepDefinitionStateStore<T> {

    T initialize();
}
