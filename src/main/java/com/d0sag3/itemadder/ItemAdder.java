/*
 * File: ItemAdderGUI.java
 * Author: d0sag3 (Antonius Torode)
 * Created: 6/25/2020
 * Description: The Item Adder assist in automation of creating the warcraftitems mod.
 */

package com.d0sag3.itemadder;

import java.io.IOException;

/**
 * The Item Adder is a class that will handle automatic generation of minecraft data given user input.
 * It will be designed to parse through the WoW textures and give the user options to set block properties
 * and then automatically generate the code needed for the mod/Minecraft to add the textures/blocks to the game.
 */
public class ItemAdder {

    // Main constructor for the Item Adder GUI.
    public ItemAdder() {
        init();
    }

    // Initialization function for the GUI. This will place the elements and set up the gui default values.
    private void init() {
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new ItemAdderFrame().setVisible(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    // The main function to run the GUI program.
    public static void main(String[] args) {
        new ItemAdder();
    }
}

