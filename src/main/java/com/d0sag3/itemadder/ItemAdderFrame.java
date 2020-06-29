/*
 * File: ItemAdderFrame.java
 * Author: d0sag3 (Antonius Torode)
 * Created: 6/25/2020
 * Description: The Item Adder gui to display. This is a frame that houses the ItemAdderPanel.
 */

package com.d0sag3.itemadder;

import java.io.IOException;

public class ItemAdderFrame extends javax.swing.JFrame {

    // Variables declaration.
    public ItemAdderPanel mainPanel;

    /**
     * Creates new form ItemAdderFrame
     */
    public ItemAdderFrame() throws IOException {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // Initializes the frame and adds the ItemAdderPanel to it.
    private void initComponents() throws IOException {

        mainPanel = new ItemAdderPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }
}
