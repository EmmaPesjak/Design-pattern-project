package com.dt181g.project.views;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * Class responsible for providing images in JLabels, used by View classes.
 * @author Emma Pesjak
 */
public class GetImageFromFile {

    /**
     * Static method for loading images into JLabels.
     * @param fileName is the name of the file.
     * @param o is the object requesting a JLabel.
     * @return the JLabel with the ImageIcon.
     */
    public static JLabel getImageFromFile(String fileName, Object o) {
        URL imageURL = o.getClass().getClassLoader().getResource(fileName);
        Image image = Toolkit.getDefaultToolkit().getImage(imageURL);
        return new JLabel(new ImageIcon(image));
    }
}
