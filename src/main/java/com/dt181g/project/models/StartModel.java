package com.dt181g.project.models;

import com.dt181g.project.models.monsters.BaseMonster;
import com.dt181g.project.models.monsters.MonsterFactory;
import com.dt181g.project.models.unicorns.UnicornFactory;
import com.dt181g.project.support.Constants;
import com.dt181g.project.views.HealthPoolPanel;

import javax.swing.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StartModel {

    private int level2Result;
    List<String> words = Constants.STRING_LIST;

    MonsterFactory monsterFactory = new MonsterFactory();

    public StartModel() {}

    public void calculateLevel2(List<Integer> numbs) {
        level2Result = numbs.stream().reduce(0, Integer::sum);
    }

    public boolean level2Success() {
        return level2Result == Constants.RESULT_LVL2;
    }

    public BaseMonster getRandomMonster() {
        return monsterFactory.createChar();
    }

    public ImageIcon getRandomCharImg() {

        int randomNmb = new Random().nextInt(2) + 1;

        if (randomNmb == 1) {
            MonsterFactory factory1 = (MonsterFactory) FactoryProvider.getFactory(1);
            return factory1.createChar().getMonsterImg();
        } else {
            UnicornFactory factory2 = (UnicornFactory) FactoryProvider.getFactory(2);
            return factory2.createChar().getUnicornImg();
        }
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
