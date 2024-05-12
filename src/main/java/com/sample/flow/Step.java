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

}
