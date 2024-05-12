package com.sample.flow;

import java.util.Optional;
import java.util.function.Consumer;

public class AsyncStep<T> extends  Step<T> {

    public AsyncStep(FlowDefinition.FlowDefinitionBuilder<T> parent, Consumer<T> localFunction) {
        super(parent, localFunction, Optional.empty());
    }
}
