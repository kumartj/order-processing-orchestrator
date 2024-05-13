package com.sample.flow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class FlowManager {

    private static final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static <T> void execute(FlowDefinition<T> flowDefinition, T data) {
        for (Step<T> step : flowDefinition.getSteps()) {
            try {
                if ((step instanceof AsyncStep<T>)) {
                    executorService.submit(() -> step.getLocalFunction().accept(data));
                } else {
                    step.getLocalFunction().accept(data);

                }
            } catch (Exception e) {
                if(step instanceof AsyncStep<T>){
                    throw e;
                }
                //step is a simple step
                if (step.getReplyHandler().isPresent()) {
                    Consumer<T> consumerReplyHandler = step.getReplyHandler()
                            .get()
                            .get(e.getClass());
                    if (consumerReplyHandler != null) {
                        consumerReplyHandler.accept(data);
                    }
                }
                throw e;
            }
        }
    }

}
