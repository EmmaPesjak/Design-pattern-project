package com.dt181g.project.models;

import com.dt181g.project.models.monsters.BaseMonster;
import com.dt181g.project.models.monsters.MonsterFactory;

import java.util.List;
import java.util.Random;

public class StartModel {

    private int yellowResult;

    MonsterFactory monsterFactory = new MonsterFactory();

    public StartModel() {}

    public void calculateYellow(List<Integer> numbs) {
        yellowResult = numbs.stream().reduce(0, Integer::sum);
    }

    public boolean yellowSuccess() {
        return yellowResult == 15;
    }

    public BaseMonster getRandomMonster() {
        return monsterFactory.createMonster(new Random().nextInt(8) + 1);
    }
}
