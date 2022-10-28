package com.dt181g.project.models;

import com.dt181g.project.models.factories.BaseCharacter;
import com.dt181g.project.models.factories.FactoryProvider;
import com.dt181g.project.models.factories.MonsterFactory;
import com.dt181g.project.models.factories.UnicornFactory;
import com.dt181g.project.support.Constants;

import java.awt.*;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Main model class, responsible for handling the application's data and perform calculations.
 * @author Emma Pesjak
 */
public class MainModel {

    private final List<String> words = Constants.STRING_LIST_LVL1;
    private int lvl2Result;
    private final MonsterFactory monsterFactory = (MonsterFactory) FactoryProvider.getFactory(1);
    private final UnicornFactory unicornFactory = (UnicornFactory) FactoryProvider.getFactory(2);

    /**
     * Method for creating a monster from the MonsterFactory.
     * @return a random Monster.
     */
    public BaseCharacter getRandomMonster() {
        return monsterFactory.createChar();
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
     * Method for level 2, responsible  for calculating the sum of the user's input.
     * @param numbs is a list of integers.
     */
    public void calculateLevel2(List<Integer> numbs) {
        lvl2Result = numbs.stream().reduce(0, Integer::sum);
    }

    /**
     * Method for level 2, checks whether the user input is correct.
     * @return boolean that states if it is correct or not.
     */
    public boolean level2Success() {
        return lvl2Result == Constants.RESULT_LVL2;
    }

    /**
     * Method for producing a random character image, either a monster or a unicorn.
     * @return a random character image file path.
     */
    public String getRandomCharImg() {

        int randomNmb = new Random().nextInt(2) + 1;

        if (randomNmb == 1) {
            return monsterFactory.createChar().getImg();
        } else {
            return unicornFactory.createChar().getImg();
        }
    }

    /**
     * Method for producing a random color, either a monster color or a unicorn color.
     * @return a random color.
     */
    public Color getRandomColor() {

        int randomNmb = new Random().nextInt(2) + 1;

        if (randomNmb == 1) {
            return monsterFactory.createColor().getColor();
        } else {
            return unicornFactory.createColor().getColor();
        }
    }
}
