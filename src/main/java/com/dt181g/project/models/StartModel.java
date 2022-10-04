package com.dt181g.project.models;

import java.util.List;

public class StartModel {

    private int yellowResult;

    public StartModel() {

    }

    public void calculateYellow(List<Integer> numbs) {
        yellowResult = numbs.stream().reduce(0, Integer::sum);
    }

    public boolean yellowSuccess() {
        return yellowResult == 15;
    }
}
