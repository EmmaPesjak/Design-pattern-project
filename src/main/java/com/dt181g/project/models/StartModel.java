package com.dt181g.project.models;

import com.dt181g.project.models.monsters.BaseMonster;
import com.dt181g.project.models.monsters.MonsterFactory;
import com.dt181g.project.models.unicorns.BaseUnicorn;
import com.dt181g.project.models.unicorns.UnicornFactory;
import com.dt181g.project.support.Constants;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StartModel {

    private int level2Result;
    List<String> words = Constants.STRING_LIST;

    MonsterFactory monsterFactory = new MonsterFactory();
    UnicornFactory unicornFactory = new UnicornFactory();

    public StartModel() {}

    public void calculateLevel2(List<Integer> numbs) {
        level2Result = numbs.stream().reduce(0, Integer::sum);
    }

    public boolean level2Success() {
        return level2Result == Constants.RESULT_LVL2;
    }

    public BaseMonster getRandomMonster() {
        return monsterFactory.createMonster(new Random().nextInt(Constants.AMOUNT_OF_MONSTERS) + 1);
    }

    public BaseUnicorn getRandomUnicorn() {
        return unicornFactory.createUnicorn(new Random().nextInt(Constants.AMOUNT_OF_UNICORNS) + 1);
    }

    public String level1RandomWords() {
        return String.join(" ", words);
    }

    public String sortLevel1Alphabetically() {
        List<String> sorted = words.stream().sorted().collect(Collectors.toList());
        return String.join(" ", sorted);
    }

    public String countWordsLvl1() {
        long amountOfWords = words.stream().filter(word -> word.length() > 5).count();
        return Long.toString(amountOfWords);
    }
}
