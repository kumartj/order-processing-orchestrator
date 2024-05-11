package com.sample.flow;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

public class Step<T> {

    private final Consumer<T> localFunction;

    private final FlowDefinition.FlowDefinitionBuilder<T> parent;

    private final Optional<Map<Class<? extends Exception>, Consumer<T>>> replyHandler;

    public Consumer<T> getLocalFunction() {
        return localFunction;
    }


    public Optional<Map<Class<? extends Exception>, Consumer<T>>> getReplyHandler() {
        return replyHandler;
    }

    public Step(FlowDefinition.FlowDefinitionBuilder<T> parent, Consumer<T> localFunction, Optional<Map<Class<? extends Exception>, Consumer<T>>> replyHandler) {
        this.localFunction = localFunction;
        this.parent = parent;
        this.replyHandler = replyHandler;
    }

    @Override
    public String toString() {
        return "Step{" +
                "localFunction=" + localFunction.toString() +
                ", parent=" + parent +
                ", replyHandler=" + replyHandler.get() +
                '}';
    }

    public static class StepBuilder<T> {

        private Consumer<T> localFunction;

        private FlowDefinition.FlowDefinitionBuilder<T> parent;

        private Optional<Map<Class<? extends Exception>, Consumer<T>>> replyHandler;

        public StepBuilder(FlowDefinition.FlowDefinitionBuilder<T> parent) {
            this.parent = parent;
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


        public StepBuilder<T> invokeFunction(Consumer<T> function) {
            StepBuilder<T> stepBuilder = new StepBuilder<>(parent);
            stepBuilder.localFunction = function;
            return stepBuilder;
        }


        public FlowDefinition<T> build() {
            return parent.build();
        }

        public StepBuilder<T> onreply(Class<? extends Exception> exception, Consumer<T> function) {
            if ( this.replyHandler.isEmpty()) {
                replyHandler = Optional.of(new HashMap<>());
            }

            replyHandler.get().put(exception, function);
            return this;
        }
    }
}
