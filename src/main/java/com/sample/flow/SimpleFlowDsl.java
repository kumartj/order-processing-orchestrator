package com.sample.flow;

public interface SimpleFlowDsl<T> {

    default Step.StepBuilder<T> step() {
        return new Step.StepBuilder<>(new FlowDefinition.FlowDefinitionBuilder<>());
    }
}
