package com.dt181g.project.models;

import com.dt181g.project.models.monsters.BaseMonster;
import com.dt181g.project.models.monsters.MonsterFactory;
import com.dt181g.project.models.unicorns.UnicornFactory;
import com.dt181g.project.support.Constants;

import javax.swing.*;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Main model class, responsible for
 * @author Emma Pesjak
 */
public class MainModel {

    List<String> words = Constants.STRING_LIST_LVL1;

    private int lvl2Result;

    MonsterFactory monsterFactory = (MonsterFactory) FactoryProvider.getFactory(1);
    UnicornFactory unicornFactory = (UnicornFactory) FactoryProvider.getFactory(2);

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
     * Method for level 1, responsible for joining a list of words to a string to use for output.
     * @return a joint string.
     */
    public String level1RandomWords() {
        return String.join(" ", words);
    }

    /**
     * Method for level 1, responsible for sorting words in alphabetical order.
     * @return a string with the ordered words.
     */
    public String sortLevel1Alphabetically() {
        List<String> sorted = words.stream().sorted().collect(Collectors.toList());
        return String.join(" ", sorted);
    }

    /**
     * Method level 1, responsible for counting the amount of words with more than 5 letters.
     * @return the amount in a string to use for output.
     */
    public String countWordsLevel1() {
        long amountOfWords = words.stream().filter(word -> word.length() > 5).count();
        return "There are " + amountOfWords + " words containing more than 5 letters. That is awesome!";
    }

    /**
     *
     * @param numbs is a list of integers.
     */
    public void calculateLevel2(List<Integer> numbs) {
        lvl2Result = numbs.stream().reduce(0, Integer::sum);
    }

    /**
     * Method that checks whether.......
     * @return
     */
    public boolean level2Success() {
        return lvl2Result == Constants.RESULT_LVL2;
    }
}
