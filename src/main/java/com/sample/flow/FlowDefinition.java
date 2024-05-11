package com.sample.flow;

import java.util.ArrayList;
import java.util.List;

public class FlowDefinition<T> {

    private final List<Step<T>> steps;

    public FlowDefinition(List<Step<T>> steps) {
        this.steps = steps;
    }

    public List<Step<T>> getSteps() {
        return steps;
    }

    public static class FlowDefinitionBuilder<T> {

         private List<Step<T>> steps = new ArrayList<>();


        public FlowDefinition<T> build(){
            return new FlowDefinition<>(steps);
        }

        public void addStep(Step<T> tStep) {
            steps.add(tStep);
        }
    }


}
