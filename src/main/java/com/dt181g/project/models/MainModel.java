package com.dt181g.project.models;

import com.dt181g.project.models.monsters.BaseMonster;
import com.dt181g.project.models.monsters.MonsterFactory;
import com.dt181g.project.models.unicorns.UnicornFactory;
import com.dt181g.project.support.Constants;

import javax.swing.*;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


//dela upp dessa i olika beroende på level?
/**
 *
 * @author Emma Pesjak
 */
public class MainModel {

    List<String> words = Constants.STRING_LIST_LVL1;

    private int lvl2Result;

    MonsterFactory monsterFactory = (MonsterFactory) FactoryProvider.getFactory(1);
    UnicornFactory unicornFactory = (UnicornFactory) FactoryProvider.getFactory(2);


    /**
     *
     */
    public MainModel() {}

    /**
     *
     * @param numbs
     */
    public void calculateLvl2(List<Integer> numbs) {
        lvl2Result = numbs.stream().reduce(0, Integer::sum);
    }

    /**
     *
     * @return
     */
    public boolean lvl2Success() {
        return lvl2Result == Constants.RESULT_LVL2;
    }

    /**
     *
     * @return
     */
    public BaseMonster getRandomMonster() {
        return monsterFactory.createChar();
    }

    /**
     *
     * @return
     */
    public ImageIcon getRandomCharImg() {

        int randomNmb = new Random().nextInt(2) + 1;

        if (randomNmb == 1) {
            return monsterFactory.createChar().getMonsterImg();
        } else {
            return unicornFactory.createChar().getUnicornImg();
        }
    }

    /**
     *
     * @return
     */
    public String lvl1RandomWords() {
        return String.join(" ", words);
    }

    /**
     *
     * @return
     */
    public String sortLvl1Alphabetically() {
        List<String> sorted = words.stream().sorted().collect(Collectors.toList());
        return String.join(" ", sorted);
    }

    /**
     *
     * @return
     */
    public String countWordsLvl1() {
        long amountOfWords = words.stream().filter(word -> word.length() > 5).count();
        return "There are " + Long.toString(amountOfWords) + " words containing more than 5 letters. That is awesome!";
    }
}
