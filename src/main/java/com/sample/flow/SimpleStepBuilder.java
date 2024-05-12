package com.sample.flow;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

public class SimpleStepBuilder<T> {
    private final FlowDefinition.FlowDefinitionBuilder<T> parent;
    private final Consumer<T> localFunction;
    private Optional<Map<Class<? extends Exception>, Consumer<T>>> replyHandler;

    public SimpleStepBuilder(FlowDefinition.FlowDefinitionBuilder<T> parent, Consumer<T> localFunction) {
        this.parent = parent;
        this.localFunction = localFunction;
        this.replyHandler = Optional.empty();
    }

    public StepBuilder<T> step() {
        parent.addStep(makeStep(parent, localFunction, replyHandler));
        return new StepBuilder<>(parent);
    }


    private Step<T> makeStep(FlowDefinition.FlowDefinitionBuilder<T> parent, Consumer<T> localFunction,
                             Optional<Map<Class<? extends Exception>, Consumer<T>>> replyHandler) {
        return new Step<>(parent, localFunction, replyHandler);
    }

    public FlowDefinition<T> build() {
        parent.addStep(makeStep(parent, localFunction, replyHandler));
        return parent.build();
    }

    public SimpleStepBuilder<T> onreply(Class<? extends Exception> exception, Consumer<T> function) {
        if (this.replyHandler.isEmpty()) {
            replyHandler = Optional.of(new HashMap<>());
        }

        replyHandler.get().put(exception, function);
        return this;
    }
}