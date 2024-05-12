package com.sample.flow;


import java.util.function.Consumer;

public  class StepBuilder<T> {


    private FlowDefinition.FlowDefinitionBuilder<T> parent;


    public StepBuilder(FlowDefinition.FlowDefinitionBuilder<T> parent) {
        this.parent = parent;
    }

    public SimpleStepBuilder<T> invokeFunction(Consumer<T> function) {
        return new SimpleStepBuilder<>(parent, function);
    }



    public AsyncStepBuilder<T> invokeAsyncFunction(Consumer<T> function) {
        return new AsyncStepBuilder<>(parent, function);
    }

}