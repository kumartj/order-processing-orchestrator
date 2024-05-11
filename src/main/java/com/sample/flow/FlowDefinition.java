package com.sample.flow;

import java.util.ArrayList;
import java.util.List;

public class FlowDefinition<T> {

    //Builder Pattern

    public static class FlowDefinitionBuilder<T> {

         private List<Step<T>> steps = new ArrayList<>();


        public FlowDefinition<T> build(){
            return new FlowDefinition<>();
        }

        public void addStep(Step<T> tStep) {
            steps.add(tStep);
        }
    }


}
