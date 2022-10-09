package com.dt181g.project.support;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Constants {

    //Images
    JLabel IMAGE_YELLOW_MONSTER = new JLabel(new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\monsters\\yellowMonster.png"));
    JLabel IMAGE_BLUE_MONSTER = new JLabel(new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\monsters\\blueMonster.png"));
    JLabel IMAGE_GREEN_MONSTER = new JLabel(new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\monsters\\greenMonster.png"));
    JLabel IMAGE_RED_MONSTER = new JLabel(new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\monsters\\redMonster.png"));
    JLabel IMAGE_ORANGE_MONSTER = new JLabel(new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\monsters\\orangeMonster.png"));
    JLabel IMAGE_PURPLE_MONSTER = new JLabel(new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\monsters\\purpleMonster.png"));
    JLabel IMAGE_GREY_MONSTER = new JLabel(new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\monsters\\greyMonster.png"));
    JLabel IMAGE_SLIME_MONSTER = new JLabel(new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\monsters\\slimeMonster.png"));

    JLabel IMAGE_ANGRYCORN = new JLabel(new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\unicorns\\Angrycorn.png"));
    JLabel IMAGE_FANCYCORN = new JLabel(new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\unicorns\\Fancycorn.png"));
    JLabel IMAGE_GLAMCORN = new JLabel(new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\unicorns\\Glamcorn.png"));
    JLabel IMAGE_HAPPYCORN = new JLabel(new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\unicorns\\Happycorn.png"));
    JLabel IMAGE_KITTYCORN = new JLabel(new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\unicorns\\Kittycorn.png"));
    JLabel IMAGE_RAINBOWCORN = new JLabel(new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\unicorns\\Rainbowcorn.png"));
    JLabel IMAGE_SLEEPYCORN = new JLabel(new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\unicorns\\Sleepycorn.png"));

    JLabel IMAGE_APPLE = new JLabel(new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\misc\\apple.png"));
    JLabel IMAGE_BUCKET = new JLabel(new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\misc\\bucket.png"));
    JLabel IMAGE_DRAGON = new JLabel( new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\misc\\dragon.png"));
    JLabel IMAGE_CRYSTAL = new JLabel(new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\misc\\crystal.png"));
    JLabel IMAGE_STAR = new JLabel(new ImageIcon("src\\main\\java\\com\\dt181g\\project\\img\\misc\\star.png"));

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
