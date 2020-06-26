/*
 * File: ItemAdderGUI.java
 * Author: d0sag3 (Antonius Torode)
 * Created: 6/25/2020
 * Description: The Item Adder assist in automation of creating the warcraftitems mod.
 */

package com.d0sag3.itemadder;

import javafx.geometry.Pos;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Item Adder is a class that will handle automatic generation of minecraft data given user input.
 * It will be designed to parse through the WoW textures and give the user options to set block properties
 * and then automatically generate the code needed for the mod/Minecraft to add the textures/blocks to the game.
 */
public class ItemAdderGUI implements ActionListener {

    // The mod directory is the directory that the root directory that the mod files can be found.
    public static String modDirectory = "C:\\Users\\d0sag3\\Desktop\\WarcraftItems";

    // Java GUI elements.
    private JPanel panel;
    private JFrame frame;
    private JButton button;
    private JLabel label;

    // Main constructor for the Item Adder GUI.
    public ItemAdderGUI() {
        initGUI();
    }

    // Initialization function for the GUI. This will place the elements and set up the gui default values.
    public void initGUI() {
        frame = new JFrame();

        button = new JButton("Generate");
        button.addActionListener(this);

        label = new JLabel("Test Label");

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(256,256,256,256));
        panel.setLayout(new GridLayout(0,1));
        panel.add(button, Pos.TOP_LEFT);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Warcraft Item Adder");
        frame.pack();
        frame.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e){
        label.setText(modDirectory);
    }

    // The main function to run the GUI program.
    public static void main(String[] args) {
        new ItemAdderGUI();
    }

}

