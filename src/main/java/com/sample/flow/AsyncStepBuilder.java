package com.sample.flow;

import java.util.function.Consumer;

public class AsyncStepBuilder<T> {
    private final FlowDefinition.FlowDefinitionBuilder<T> parent;
    private final Consumer<T> localFunction;


    public AsyncStepBuilder(FlowDefinition.FlowDefinitionBuilder<T> parent, Consumer<T> localFunction) {
        this.parent = parent;
        this.localFunction = localFunction;
    }

    public FlowDefinition<T> build() {
        parent.addStep(makeAsyncStep(parent, localFunction));
        return parent.build();
    }

    public StepBuilder<T> step() {
        parent.addStep(makeAsyncStep(parent, localFunction));
        return new StepBuilder<>(parent);
    }

    private AsyncStep<T> makeAsyncStep(FlowDefinition.FlowDefinitionBuilder<T> parent, Consumer<T> localFunction) {
        return new AsyncStep<>(parent, localFunction);
    }
}