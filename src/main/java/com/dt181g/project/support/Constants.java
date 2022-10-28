package com.dt181g.project.support;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Interface that define constant values.
 * @author Emma Pesjak
 */
public interface Constants {

    //Image file names.
    String IMAGE_YELLOW_MONSTER = "yellowMonster.png";
    String IMAGE_BLUE_MONSTER = "blueMonster.png";
    String IMAGE_GREEN_MONSTER = "greenMonster.png";
    String IMAGE_RED_MONSTER = "redMonster.png";
    String IMAGE_ORANGE_MONSTER = "orangeMonster.png";
    String IMAGE_PURPLE_MONSTER = "purpleMonster.png";
    String IMAGE_GREY_MONSTER = "greyMonster.png";
    String IMAGE_SLIME_MONSTER = "slimeMonster.png";

    String IMAGE_ANGRYCORN = "angrycorn.png";
    String IMAGE_FANCYCORN = "fancycorn.png";
    String IMAGE_GLAMCORN = "glamcorn.png";
    String IMAGE_HAPPYCORN = "happycorn.png";
    String IMAGE_KITTYCORN = "kittycorn.png";
    String IMAGE_RAINBOWCORN = "rainbowcorn.png";
    String IMAGE_SLEEPYCORN = "sleepycorn.png";

    String IMAGE_APPLE = "apple.png";
    String IMAGE_BUCKET = "bucket.png";
    String IMAGE_DRAGON = "dragon.png";
    String IMAGE_CRYSTAL = "crystal.png";
    String IMAGE_STAR = "star.png";
    String IMAGE_FACTORY = "factory.png";
    String IMAGE_WEAPONS = "weapons.png";

    // Fonts.
    Font FONT_BIG = new Font(Font.MONOSPACED, Font.BOLD, 32);
    Font FONT_TEXT = new Font(Font.MONOSPACED, Font.PLAIN, 20);
    Font FONT_BUTTON = new Font(Font.MONOSPACED, Font.BOLD, 22);

    // Colors.
    Color COLOR_BACKGROUND = new Color(2, 2, 40);
    Color COLOR_TEXT = new Color(241, 241, 230);
    Color COLOR_BUTTON = new Color(152, 62, 92);
    Color COLOR_BUTTON_TEXT = new Color(234, 211, 193);
    Color COLOR_LOW_HEALTH = new Color(214,109, 91);
    Color COLOR_MEDIUM_LOW_HEALTH = new Color(249,173, 88);
    Color COLOR_MEDIUM_HEALTH = new Color(249,248, 113);
    Color COLOR_HIGH_HEALTH = new Color(155,222, 126);
    Color COLOR_MONSTER_BLUE = new Color(24, 59, 81);
    Color COLOR_MONSTER_RED = new Color(80, 20, 25);
    Color COLOR_UNICORN_BLUE = new Color(131, 174, 236);
    Color COLOR_UNICORN_RED = new Color(219, 120, 152);

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
