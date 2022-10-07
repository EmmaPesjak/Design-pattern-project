package com.dt181g.project.models;

import com.dt181g.project.models.monsters.BaseMonster;
import com.dt181g.project.models.monsters.MonsterFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StartModel {

    private int level2Result;

    MonsterFactory monsterFactory = new MonsterFactory();

    List<String> words = new ArrayList<>(Arrays.asList("mango", "elderberry", "apple", "lime", "banana", "orange", "strawberry", "cherry", "durian", "fig", "grapes"));

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

    public String level1RandomWords() {
        return String.join(" ", words);
    }

    public String sortLevel1Alphabetically() {
        List<String> sorted = words.stream().sorted().collect(Collectors.toList());
        return String.join(" ", sorted);
    }

    public String countWords() {
        long amountOfWords = words.stream().filter(word -> word.length() > 5).count();
        return Long.toString(amountOfWords);
    }
}
