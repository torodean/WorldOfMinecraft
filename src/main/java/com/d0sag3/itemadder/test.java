package com.d0sag3.itemadder;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class test {

    JFrame mainFrame = new JFrame();
    JPanel imagePanel = new JPanel();
    JLabel imageIconLabel = new JLabel();
    ImageIcon imageIcon = new ImageIcon();

    public test() throws IOException {
        imagePanel.setSize(256,256);
        imageIconLabel.setSize(256,256);
        imagePanel.add(imageIconLabel);

        mainFrame.setSize(512, 512);
        mainFrame.add(imagePanel);
        mainFrame.setVisible(true);

        File file = new File("C:\\cygwin64\\home\\d0sag3\\WorldOfMinecraft\\textures_test\\test_image.png");
        displayImage(file);
    }

    private void displayImage(File file) throws IOException {

        // This does not work.
        // Suppose to update the imagePanel to show the image.
        BufferedImage image = ImageIO.read(file);
        imageIcon = new ImageIcon(image);
        imageIconLabel.setIcon(imageIcon);
        imagePanel.add(imageIconLabel);
        imagePanel.revalidate();
        imagePanel.repaint();

//        // For troubleshooting - this works.
//        // Opens the image in a new JFrame.
//        JFrame frame = new JFrame();
//        frame.setSize(256,256);
//        frame.add(imageIconLabel);
//        frame.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        new test();
    }
}


