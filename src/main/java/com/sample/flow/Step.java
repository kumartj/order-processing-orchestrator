package com.sample.saga;

import com.sample.order.orderprocess.OrderProcessingData;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

public class Step<T> {

    private final int stepNumber;
    private final Consumer<T> localFunction;

    public Step(int stepNumber, Consumer<T> localFunction) {
        this.stepNumber = stepNumber;
        this.localFunction = localFunction;
    }


    public static class StepBuilder<T> {

        private int stepNumber;
        private Consumer<T> localFunction;

        private Optional<Map<Class<Exception>, Consumer<T>>> replyHandler;

        public  StepBuilder(int step) {
            this.stepNumber = step;
        }

        public StepBuilder<T> invokeFunction(Consumer<T> function) {
            this.localFunction = function;
            return this;
        }
        public Step<T> build(){
            return new Step<>(this.stepNumber,
                    this.localFunction);
        }

        public StepBuilder<T> onreply(Class<Exception> exception, Consumer<T> function) {
            if(this.replyHandler.isEmpty()) {
                replyHandler = Optional.of(new HashMap<>());
            }

            replyHandler.get().put(exception, function);
            return this;
        }
    }
}
