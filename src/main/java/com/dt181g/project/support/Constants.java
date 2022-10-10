package com.dt181g.project.support;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Constants {

    //Images
    ImageIcon IMAGE_YELLOW_MONSTER = new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\monsters\\yellowMonster.png");
    ImageIcon IMAGE_BLUE_MONSTER = new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\monsters\\blueMonster.png");
    ImageIcon IMAGE_GREEN_MONSTER = new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\monsters\\greenMonster.png");
    ImageIcon IMAGE_RED_MONSTER = new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\monsters\\redMonster.png");
    ImageIcon IMAGE_ORANGE_MONSTER = new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\monsters\\orangeMonster.png");
    ImageIcon IMAGE_PURPLE_MONSTER = new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\monsters\\purpleMonster.png");
    ImageIcon IMAGE_GREY_MONSTER = new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\monsters\\greyMonster.png");
    ImageIcon IMAGE_SLIME_MONSTER = new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\monsters\\slimeMonster.png");

    ImageIcon IMAGE_ANGRYCORN = new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\unicorns\\Angrycorn.png");
    ImageIcon IMAGE_FANCYCORN = new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\unicorns\\Fancycorn.png");
    ImageIcon IMAGE_GLAMCORN = new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\unicorns\\Glamcorn.png");
    ImageIcon IMAGE_HAPPYCORN = new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\unicorns\\Happycorn.png");
    ImageIcon IMAGE_KITTYCORN = new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\unicorns\\Kittycorn.png");
    ImageIcon IMAGE_RAINBOWCORN = new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\unicorns\\Rainbowcorn.png");
    ImageIcon IMAGE_SLEEPYCORN = new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\unicorns\\Sleepycorn.png");

    ImageIcon IMAGE_APPLE = new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\misc\\apple.png");
    ImageIcon IMAGE_BUCKET = new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\misc\\bucket.png");
    ImageIcon IMAGE_DRAGON = new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\misc\\dragon.png");
    ImageIcon IMAGE_CRYSTAL = new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\misc\\crystal.png");
    ImageIcon IMAGE_STAR = new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\misc\\star.png");
    ImageIcon IMAGE_FACTORY = new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\misc\\factory.png");
    ImageIcon IMAGE_WEAPONS = new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\misc\\weapons.png");

    // Fonts
    Font TITLE_FONT = new Font(Font.MONOSPACED, Font.BOLD, 28);
    Font TEXT_FONT = new Font(Font.MONOSPACED, Font.PLAIN, 16);
    Font BUTTON_FONT = new Font(Font.MONOSPACED, Font.BOLD, 20);

    // Colours
    Color COLOR_BACKGROUND = new Color(2, 2, 40);
    Color TEXT_COLOR = new Color(241, 241, 230);
    Color BUTTON_COLOR = new Color(152, 62, 92);
    Color BUTTON_TEXT_COLOR = new Color(234, 211, 193);
    Color COLOR_LOW_HEALTH = new Color(214,109, 91);
    Color COLOR_MEDIUM_LOW_HEALTH = new Color(249,173, 88);
    Color COLOR_MEDIUM_HEALTH = new Color(249,248, 113);
    Color COLOR_HIGH_HEALTH = new Color(155,222, 126);

    // Dimensions


    //lägga in alla listor och strings här med motivationen att man endast måste ändra dessa om det skulle vara?



    //grejor som används till model
    int AMOUNT_OF_UNICORNS = 7;
    int AMOUNT_OF_MONSTERS = 8;
    int RESULT_LVL2 = 15;
    List<String> STRING_LIST = new ArrayList<>(Arrays.asList("mango", "elderberry", "apple", "lime", "banana", "orange", "strawberry", "cherry", "durian", "fig", "grapes"));


}
