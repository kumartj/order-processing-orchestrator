package com.sample.flow;

public interface SimpleFlowDsl<T> {

    default StepBuilder<T> step() {
        return new StepBuilder<>(new FlowDefinition.FlowDefinitionBuilder<>());
    }

    FlowDefinition<T> getFlowDefinition();
}
