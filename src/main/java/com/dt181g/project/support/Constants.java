package com.dt181g.project.support;

import javax.swing.*;
import java.awt.*;

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
    Color COLOR_MIDNIGHT = new Color(2, 2, 40);
    Color TEXT_COLOR = new Color(241, 241, 230);
    Color BUTTON_COLOR = new Color(152, 62, 92);
    Color BUTTON_TEXT_COLOR = new Color(234, 211, 193);
    Color COLOR_LOW_HEALTH = new Color(214,109, 91);
    Color COLOR_MEDIUM_LOW_HEALTH = new Color(249,173, 88);
    Color COLOR_MEDIUM_HEALTH = new Color(249,248, 113);
    Color COLOR_HIGH_HEALTH = new Color(155,222, 126);

    // Dimensions

}
