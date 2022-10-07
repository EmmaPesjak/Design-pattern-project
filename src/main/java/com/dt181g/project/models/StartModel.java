package com.dt181g.project.models;

import com.dt181g.project.models.monsters.BaseMonster;
import com.dt181g.project.models.monsters.MonsterFactory;

import java.util.List;
import java.util.Random;

public class StartModel {

    private int level2Result;

    MonsterFactory monsterFactory = new MonsterFactory();

    public StartModel() {}

    public void calculateLevel2(List<Integer> numbs) {
        level2Result = numbs.stream().reduce(0, Integer::sum);
    }

    public boolean level2Success() {
        return level2Result == 15;
    }

    public BaseMonster getRandomMonster() {
        return monsterFactory.createMonster(new Random().nextInt(8) + 1);
    }


    public List<String> sortLevel1Alphabetically(List<String> words) {
        return words.stream().sorted().toList();
    }

    public long countWords(List<String> words) {
        return words.stream().filter(word -> word.length() > 5).count();
    }
}
