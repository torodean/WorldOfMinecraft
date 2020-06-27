/*
 * File: ItemAdderGUI.java
 * Author: d0sag3 (Antonius Torode)
 * Created: 6/25/2020
 * Description: The Item Adder gui.
 */

package com.d0sag3.itemadder;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class is for the GUI form that ItemAdder uses.
 * The code was modeled after auto-generated code using the Netbeans design form.
 */
public class ItemAdderPanel extends JPanel {

    // The mod directory is the directory that the root directory that the mod files can be found.
    public String modDirectory = "C:\\cygwin64\\home\\d0sag3\\WorldOfMinecraft";

    // The used directory is the directory that the already added textures get moved to.
    public String usedDirectory = "C:\\cygwin64\\home\\d0sag3\\WorldOfMinecraft\\textures_converted";

    // The unused directory is the directory that the textures to be added can be found.
    public String unusedDirectory = "C:\\cygwin64\\home\\d0sag3\\WorldOfMinecraft\\textures_unconverted";

    // The skipped directory is the directory that the textures that were skipped are moved to.
    public String skippedDirectory = "C:\\cygwin64\\home\\d0sag3\\WorldOfMinecraft\\textures_skipped";

    // A list of files to be parsed.
    List<File> filesToParse;

    // Creates new form Panel to house the gui.
    public ItemAdderPanel() throws IOException {
        initComponents();
        this.setVisible(true);
        displayImage(filesToParse.get(currentFileIndex));
    }

    ItemAdderTools itemAdderTool;
    public int currentFileIndex;

    @SuppressWarnings("unchecked")
    private void initComponents() throws IOException {

        filesToParse = Files.walk(Paths.get(unusedDirectory))
                .filter(Files::isRegularFile)
                .map(Path::toFile)
                .collect(Collectors.toList());

        currentFileIndex = 0;

        itemAdderTool = new ItemAdderTools(this);

        // Image items.
        imagePanel = new JPanel();
        imageIcon = new ImageIcon();
        imageIconLabel = new JLabel();

        modDirectory_textField = new JTextField();
        jLabel1 = new JLabel();
        unusedDirectory_textField = new JTextField();
        jLabel2 = new JLabel();
        usedDirectory_textField = new JTextField();
        jLabel3 = new JLabel();
        skippedDirectory_textField = new JTextField();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        generateCode_button = new JButton();
        skip_button = new JButton();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        jLabel11 = new JLabel();
        jLabel12 = new JLabel();
        hardness_textField = new JTextField();
        resistance_textField = new JTextField();
        resistance_slider = new JSlider();
        hardness_slider = new JSlider();
        material_ComboBox = new JComboBox<>();
        sound_ComboBox = new JComboBox<>();
        harvestLevel_slider = new JSlider();
        harvestTool_ComboBox = new JComboBox<>();


        harvestLevel_textField = new JTextField();
        harvestLevel_textField.addActionListener(this::harvestLevel_textFieldActionPerformed);

        modDirectory_textField.setText(modDirectory);
        modDirectory_textField.addActionListener(this::modDirectory_textFieldActionPerformed);

        jLabel1.setText("Mod Directory:");

        imagePanel.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        imagePanel.setPreferredSize(new java.awt.Dimension(256, 256));

        imageIconLabel.setToolTipText("Test Text");
        imagePanel.setSize(256,256);
        imageIconLabel.setSize(256,256);
        imagePanel.add(imageIconLabel);

        GroupLayout imagePanelLayout = new GroupLayout(imagePanel);
        imagePanel.setLayout(imagePanelLayout);
        imagePanelLayout.setHorizontalGroup(
                imagePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(imageIconLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
        );
        imagePanelLayout.setVerticalGroup(
                imagePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(imageIconLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
        );
        imagePanel.setVisible(true);
        this.add(imagePanel);
        unusedDirectory_textField.setText(unusedDirectory);
        unusedDirectory_textField.addActionListener(this::unusedDirectory_textFieldActionPerformed);

        jLabel2.setText("Unused Textures:");

        usedDirectory_textField.setText(usedDirectory);
        usedDirectory_textField.addActionListener(this::usedDirectory_textFieldActionPerformed);

        jLabel3.setText("Used Textures:");

        skippedDirectory_textField.setText(skippedDirectory);
        skippedDirectory_textField.addActionListener(this::skippedDirectory_textFieldActionPerformed);

        jLabel4.setText("Skipped Textures:");

        jLabel5.setText("Currently Parsed Texture:");

        generateCode_button.setText("Generate Code");
        generateCode_button.addActionListener(evt -> {
            try {
                generateCode_buttonActionPerformed(evt);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        skip_button.setText("Skip");
        skip_button.addActionListener(evt -> {
            try {
                skip_buttonActionPerformed(evt);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        jLabel6.setText("texture_name");

        jLabel7.setText("Hardness:");

        jLabel8.setText("Resistance:");

        jLabel9.setText("Sound Type:");

        jLabel10.setText("Harvest Level:");

        jLabel11.setText("Harvest Tool:");

        jLabel12.setText("Material:");

        hardness_textField.setText("1.5");
        hardness_textField.addActionListener(this::hardness_textFieldActionPerformed);

        resistance_textField.setText("6.0");
        resistance_textField.addActionListener(this::resistance_textFieldActionPerformed);

        // The units on this value are in tenths. The slider supports integers but hardness can be much smaller.
        resistance_slider.setMaximum(12000);
        resistance_slider.setToolTipText("");
        resistance_slider.setValue(60);
        resistance_slider.addChangeListener(this::resistance_sliderChangePerformed);

        // The units on this value are in tenths. The slider supports integers but hardness can be much smaller.
        hardness_slider.setMaximum(500);
        hardness_slider.setToolTipText("");
        hardness_slider.setValue(15);
        hardness_slider.addChangeListener(this::hardness_sliderChangePerformed);

        material_ComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"AIR", "STRUCTURE_VOID", "PORTAL", "CARPET", "PLANTS", "OCEAN_PLANT", "TALL_PLANTS", "SEA_GRASS", "WATER", "BUBBLE_COLUMN", "LAVA", "SNOW", "FIRE", "MISCELLANEOUS", "WEB", "REDSTONE_LIGHT", "CLAY", "EARTH", "ORGANIC", "PACKED_ICE", "SAND", "SPONGE", "SHULKER", "WOOD", "BAMBOO_SAPLING", "BAMBOO", "WOOL", "TNT", "LEAVES", "GLASS", "ICE", "CACTUS", "ROCK", "IRON", "SNOW_BLOCK", "ANVIL", "BARRIER", "PISTON", "CORAL", "GOURD", "DRAGON_EGG", "CAKE"}));
        material_ComboBox.setSelectedIndex(32);

        sound_ComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"NONE", "WOOD", "GROUND", "PLANT", "STONE", "METAL", "GLASS", "CLOTH", "SAND", "SNOW", "LADDER", "ANVIL", "SLIME", "field_226947_m_", "WET_GRASS", "CORAL", "BAMBOO", "BAMBOO_SAPLING", "SCAFFOLDING", "SWEET_BERRY_BUSH", "CROP", "STEM", "NETHER_WART", "LANTERN"}));
        sound_ComboBox.setSelectedIndex(4);

        harvestLevel_textField.setText("1");
        harvestLevel_textField.addActionListener(this::harvestLevel_textFieldActionPerformed);

        harvestLevel_slider.setMaximum(3);
        harvestLevel_slider.setToolTipText("");
        harvestLevel_slider.setValue(1);
        harvestLevel_slider.addChangeListener(this::harvestLevel_sliderChangePerformed);

        harvestTool_ComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"NONE", "AXE", "PICKAXE", "SHOVEL"}));
        harvestTool_ComboBox.setSelectedIndex(2);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(generateCode_button, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(skip_button))
                                                                        .addComponent(imagePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel7)
                                                                        .addComponent(jLabel12)
                                                                        .addComponent(jLabel8)
                                                                        .addComponent(jLabel9)
                                                                        .addComponent(jLabel10)
                                                                        .addComponent(jLabel11))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(hardness_textField, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(hardness_slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(material_ComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(resistance_textField, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(resistance_slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(sound_ComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(harvestLevel_textField, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(harvestLevel_slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(harvestTool_ComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel2)
                                                                        .addComponent(jLabel1)
                                                                        .addComponent(jLabel3)
                                                                        .addComponent(jLabel4))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(unusedDirectory_textField, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                                                                        .addComponent(usedDirectory_textField, GroupLayout.Alignment.LEADING)
                                                                        .addComponent(skippedDirectory_textField, GroupLayout.Alignment.LEADING)
                                                                        .addComponent(modDirectory_textField))))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(modDirectory_textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(unusedDirectory_textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(usedDirectory_textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(skippedDirectory_textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(imagePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel12)
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabel7)
                                                                        .addComponent(hardness_textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(material_ComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(hardness_slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel8)
                                                                .addComponent(resistance_textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(resistance_slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel9)
                                                        .addComponent(sound_ComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(15, 15, 15)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                .addComponent(harvestLevel_textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel10))
                                                        .addComponent(harvestLevel_slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel11)
                                                        .addComponent(harvestTool_ComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(skip_button)
                                        .addComponent(generateCode_button))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    // This will return the selected material value.
    public String getMaterial_ComboBoxValue(){
        return material_ComboBox.getSelectedItem().toString();
    }

    // This will return the selected sound value.
    public String getSound_ComboBoxValue(){
        return sound_ComboBox.getSelectedItem().toString();
    }

    // This will return the selected harvest tool value.
    public String getHarvestTool_ComboBoxValue(){
        return harvestTool_ComboBox.getSelectedItem().toString();
    }

    // This will return the harvest level.
    public String getHardnessValue(){
        return hardness_textField.getText();
    }

    // This will return the harvest level.
    public String getResistanceValue(){
        return resistance_textField.getText();
    }

    // This will return the harvest level.
    public String getHarvestLevelValue(){
        return harvestLevel_textField.getText();
    }

    // Button declarations.
    private JButton generateCode_button;
    private JButton skip_button;

    // Combo box declarations.
    private JComboBox<String> material_ComboBox;
    private JComboBox<String> sound_ComboBox;
    private JComboBox<String> harvestTool_ComboBox;

    // Lavel declarations.
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;

    // Panel declarations.
    private JPanel imagePanel;
    private ImageIcon imageIcon;
    private JLabel imageIconLabel;

    // Slider declarations.
    private JSlider resistance_slider;
    private JSlider hardness_slider;
    private JSlider harvestLevel_slider;

    // Text field declarations.
    private JTextField modDirectory_textField;
    private JTextField unusedDirectory_textField;
    private JTextField usedDirectory_textField;
    private JTextField skippedDirectory_textField;
    private JTextField hardness_textField;
    private JTextField resistance_textField;
    private JTextField harvestLevel_textField;

    private void modDirectory_textFieldActionPerformed(java.awt.event.ActionEvent evt) {
        modDirectory = modDirectory_textField.getText();
    }

    private void unusedDirectory_textFieldActionPerformed(java.awt.event.ActionEvent evt) {
        unusedDirectory = unusedDirectory_textField.getText();
    }

    private void usedDirectory_textFieldActionPerformed(java.awt.event.ActionEvent evt) {
        usedDirectory = usedDirectory_textField.getText();
    }

    private void skippedDirectory_textFieldActionPerformed(java.awt.event.ActionEvent evt) {
        skippedDirectory = skippedDirectory_textField.getText();
    }

    private void hardness_textFieldActionPerformed(java.awt.event.ActionEvent evt) {
        hardness_slider.setValue(Integer.parseInt(hardness_textField.getText())*10);
    }

    private void harvestLevel_sliderChangePerformed(ChangeEvent evt){
        harvestLevel_textField.setText(String.valueOf(harvestLevel_slider.getValue()));
    }

    private void hardness_sliderChangePerformed(ChangeEvent evt){
        hardness_textField.setText(String.valueOf(hardness_slider.getValue()/10.0));
    }

    private void resistance_sliderChangePerformed(ChangeEvent evt){
        resistance_textField.setText(String.valueOf(resistance_slider.getValue()/10.0));
    }

    private void resistance_textFieldActionPerformed(java.awt.event.ActionEvent evt) {
        resistance_slider.setValue(Integer.parseInt(resistance_textField.getText())*10);
    }

    private void harvestLevel_textFieldActionPerformed(java.awt.event.ActionEvent evt) {
        harvestLevel_slider.setValue(Integer.parseInt(harvestLevel_textField.getText()));
    }

    private void generateCode_buttonActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        itemAdderTool.update();
        itemAdderTool.AddFullBlock();
        currentFileIndex++;
        displayImage(filesToParse.get(currentFileIndex));
    }

    private void skip_buttonActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        itemAdderTool.update();
        itemAdderTool.skipTextures();
        currentFileIndex++;
        displayImage(filesToParse.get(currentFileIndex));
    }

    private void displayImage(File file) throws IOException {
        BufferedImage image = ImageIO.read(file);
        imageIcon = new ImageIcon(image);
        ImageIcon imageIconScaled = new ImageIcon(getScaledImage(imageIcon.getImage(), 256, 256));
        imagePanel.add(imageIconLabel);
        imageIconLabel.setIcon(imageIconScaled);
        imagePanel.revalidate();
        imagePanel.repaint();
    }

    // From https://stackoverflow.com/questions/6714045/how-to-resize-jlabel-imageicon
    private Image getScaledImage(Image srcImg, int width, int height){
        BufferedImage resizedImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, width, height, null);
        g2.dispose();

        return resizedImg;
    }
}
