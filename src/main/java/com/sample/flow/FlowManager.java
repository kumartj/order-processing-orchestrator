package com.sample.flow;

import java.util.Map;
import java.util.function.Consumer;

public class FlowManager {

    public static <T> void processDefinition(T data, FlowDefinition<T> flowDefinition) {
        for (Step<T> step : flowDefinition.getSteps()) {

            try {
                step.getLocalFunction().accept(data);
            } catch (Exception e) {
                if (step.getReplyHandler().isPresent()) {
                    Map<Class<? extends Exception>, Consumer<T>> classConsumerMap = step.getReplyHandler().get();
                    System.out.println("e.getClass() = " + e.getClass());
                    Consumer<T> replyHandler = classConsumerMap.get(e.getClass());
                    if (replyHandler != null) replyHandler.accept(data);
                }
            }
            System.out.println("step = " + step);
        }
    }

}
