package com.dt181g.project.support;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Interface that define constant values.
 * @author Emma Pesjak
 */
public interface Constants {

    //Images.
    ImageIcon IMAGE_YELLOW_MONSTER =
            new ImageIcon("src/main/java/com/dt181g/project/img/monsters/yellowMonster.png");
    ImageIcon IMAGE_BLUE_MONSTER =
            new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\monsters\\blueMonster.png");
    ImageIcon IMAGE_GREEN_MONSTER =
            new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\monsters\\greenMonster.png");
    ImageIcon IMAGE_RED_MONSTER =
            new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\monsters\\redMonster.png");
    ImageIcon IMAGE_ORANGE_MONSTER =
            new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\monsters\\orangeMonster.png");
    ImageIcon IMAGE_PURPLE_MONSTER =
            new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\monsters\\purpleMonster.png");
    ImageIcon IMAGE_GREY_MONSTER =
            new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\monsters\\greyMonster.png");
    ImageIcon IMAGE_SLIME_MONSTER =
            new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\monsters\\slimeMonster.png");

    ImageIcon IMAGE_ANGRYCORN =
            new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\unicorns\\angrycorn.png");
    ImageIcon IMAGE_FANCYCORN =
            new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\unicorns\\fancycorn.png");
    ImageIcon IMAGE_GLAMCORN =
            new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\unicorns\\glamcorn.png");
    ImageIcon IMAGE_HAPPYCORN =
            new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\unicorns\\happycorn.png");
    ImageIcon IMAGE_KITTYCORN =
            new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\unicorns\\kittycorn.png");
    ImageIcon IMAGE_RAINBOWCORN =
            new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\unicorns\\rainbowcorn.png");
    ImageIcon IMAGE_SLEEPYCORN =
            new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\unicorns\\sleepycorn.png");

    ImageIcon IMAGE_APPLE = new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\misc\\apple.png");
    ImageIcon IMAGE_BUCKET = new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\misc\\bucket.png");
    ImageIcon IMAGE_DRAGON = new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\misc\\dragon.png");
    ImageIcon IMAGE_CRYSTAL = new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\misc\\crystal.png");
    ImageIcon IMAGE_STAR = new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\misc\\star.png");
    ImageIcon IMAGE_FACTORY = new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\misc\\factory.png");
    ImageIcon IMAGE_WEAPONS = new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\misc\\weapons.png");

    // Fonts.
    Font FONT_BIG = new Font(Font.MONOSPACED, Font.BOLD, 32);
    Font FONT_TEXT = new Font(Font.MONOSPACED, Font.PLAIN, 20);
    Font FONT_BUTTON = new Font(Font.MONOSPACED, Font.BOLD, 22);

    // Colours.
    Color COLOR_BACKGROUND = new Color(2, 2, 40);
    Color COLOR_TEXT = new Color(241, 241, 230);
    Color COLOR_BUTTON = new Color(152, 62, 92);
    Color COLOR_BUTTON_TEXT = new Color(234, 211, 193);
    Color COLOR_LOW_HEALTH = new Color(214,109, 91);
    Color COLOR_MEDIUM_LOW_HEALTH = new Color(249,173, 88);
    Color COLOR_MEDIUM_HEALTH = new Color(249,248, 113);
    Color COLOR_HIGH_HEALTH = new Color(155,222, 126);

    // Level 1 combobox options.
    ArrayList<String> LVL1_SORT_LIST = new ArrayList<>(Arrays.asList(
            "All words", "Sort alphabetically.", "Count words longer than 5 letters."));

    // Level 1 list of words.
    List<String> STRING_LIST_LVL1 = new ArrayList<>(Arrays.asList("mango", "elderberry", "apple", "lime",
            "banana", "orange", "strawberry", "cherry", "durian", "fig", "grapes"));

    int AMOUNT_OF_UNICORNS = 7;     // Total amount of unicorns in the game.
    int AMOUNT_OF_MONSTERS = 8;     // Total amount of monsters in the game.
    int RESULT_LVL2 = 15;           // Level 2 number of apples to place in the buckets.

    // Combat stats for level 5.
    int MAX_HEALING_AMOUNT = 20;
    int MAX_WEAPON_DAMAGE = 3;
    int VAELARYA_START_HEALTH = 50;
    int VAELARYA_UPPER_HEALTH = 200;

    // Sleep times (seconds). Used in level 5 to simulate combat times.
    int SLEEP_HEAL = 1;
    int SLEEP_SWING_WEAPON = 10;
    int SLEEP_RESTING = 5;
    int SLEEP_WAITING = 2;
}
