package com.dt181g.project.models;

import com.dt181g.project.factories.AbstractFactory;
import com.dt181g.project.factories.BaseCharacter;
import com.dt181g.project.factories.MonsterFactory;
import com.dt181g.project.factories.UnicornFactory;
import com.dt181g.project.support.Constants;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Main model class, responsible for handling the application's data and performing calculations.
 * @author Emma Pesjak
 */
public class MainModel {

    private final AbstractFactory monsterFactory = new MonsterFactory();
    private final AbstractFactory unicornFactory = new UnicornFactory();
    private final List<String> words = Constants.STRING_LIST_LVL1;

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
     * Method for level 2, responsible  for calculating the sum of the user's input, checks whether the
     * user input is correct.
     * @param numbs is a list of integers.
     * @return boolean that states if it is correct or not.
     */
    public boolean calculateLevel2(List<Integer> numbs) {
        int lvl2Result = numbs.stream().reduce(0, Integer::sum);
        return lvl2Result == Constants.RESULT_LVL2;
    }

    /**
     * Method for producing a random character list with image path and name, either a monster or a unicorn
     * used by level 3.
     * @return a list with image and name.
     */
    public List<String> getRandomCharImgName() {
        AbstractFactory factory = getRandomFactory();
        BaseCharacter character = factory.createChar();
        String img = character.getImg();
        String name = character.getName();
        return new ArrayList<>(Arrays.asList(img, name));
    }

    /**
     * Method for producing a random color, either a monster color or a unicorn color,
     * used by level 3.
     * @return a random color.
     */
    public Color getRandomColor() {
        AbstractFactory factory = getRandomFactory();
        return factory.createColor().getColor();
    }

    /**
     * Method for getting a random factory which is used to create random colors and characters by each factory type
     * by the two methods above. This means that the above two methods does not have to create new factories
     * each time they're called.
     * @return a random factory.
     */
    public AbstractFactory getRandomFactory() {
        int random = new Random().nextInt(2 + 1);
        if (random == 1) {
            return monsterFactory;
        } else {
            return unicornFactory;
        }
    }
}
