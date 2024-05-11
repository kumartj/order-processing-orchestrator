package com.sample.flow;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StepManager {
    Map<String, Step> steps;

    private StepManager() {
        this.steps = new ConcurrentHashMap<>();
    }

    private static StepManager newInstance() {
        return new StepManager();
    }


}
