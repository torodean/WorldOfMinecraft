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

    private ImageIcon getScaledIcon(String file){
        ImageIcon icon = new ImageIcon(file);
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(40, 40,  Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaledImage);
        return icon;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() throws IOException {

        filesToParse = Files.walk(Paths.get(unusedDirectory))
                .filter(Files::isRegularFile)
                .map(Path::toFile)
                .collect(Collectors.toList());

        currentFileIndex = 0;

        itemAdderTool = new ItemAdderTools(this);
        output_TextArea = new JTextArea();
        output_ScrollPane = new JScrollPane();

        // Image items.
        imagePanel = new JPanel();
        imageIcon = new ImageIcon();
        imageIconLabel = new JLabel();

        modDirectory_textField = new JTextField();
        modDir_label = new JLabel();
        unusedDirectory_textField = new JTextField();
        unusedDir_label = new JLabel();
        usedDirectory_textField = new JTextField();
        usedDir_label = new JLabel();
        skippedDirectory_textField = new JTextField();
        skippedDir_label = new JLabel();
        currentImage_label = new JLabel();
        generateCode_button = new JButton();
        skip_button = new JButton();
        current_texture = new JLabel();
        hardness_label = new JLabel();
        resistance_label = new JLabel();
        sound_label = new JLabel();
        harvest_label = new JLabel();
        harvestTool_label = new JLabel();
        material_label = new JLabel();
        hardness_textField = new JTextField();
        resistance_textField = new JTextField();
        resistance_slider = new JSlider();
        hardness_slider = new JSlider();
        material_ComboBox = new JComboBox<>();
        sound_ComboBox = new JComboBox<>();
        harvestLevel_slider = new JSlider();
        harvestTool_ComboBox = new JComboBox<>();

        output_TextArea.setColumns(20);
        output_TextArea.setRows(5);
        output_ScrollPane.setViewportView(output_TextArea);

        ImageIcon dirt_block = getScaledIcon(modDirectory + "\\ui_elements\\dirt_block.png");
        icon1 = new JButton(dirt_block);
        icon1.setHorizontalTextPosition(SwingConstants.CENTER);

        ImageIcon sand_block = getScaledIcon(modDirectory + "\\ui_elements\\sand_block.png");
        icon2 = new JButton(sand_block);
        icon2.setHorizontalTextPosition(SwingConstants.CENTER);

        ImageIcon wool_block = getScaledIcon(modDirectory + "\\ui_elements\\wool_block.png");
        icon3 = new JButton(wool_block);
        icon3.setHorizontalTextPosition(SwingConstants.CENTER);

        ImageIcon stone_block = getScaledIcon(modDirectory + "\\ui_elements\\stone_block.png");
        icon4 = new JButton(stone_block);
        icon4.setHorizontalTextPosition(SwingConstants.CENTER);

        ImageIcon log_block = getScaledIcon(modDirectory + "\\ui_elements\\log_block.png");
        icon7 = new JButton(log_block);
        icon7.setHorizontalTextPosition(SwingConstants.CENTER);

        ImageIcon gold_block = getScaledIcon(modDirectory + "\\ui_elements\\gold_block.png");
        icon5 = new JButton(gold_block);
        icon5.setHorizontalTextPosition(SwingConstants.CENTER);

        ImageIcon obsidian_block = getScaledIcon(modDirectory + "\\ui_elements\\obsidian_block.png");
        icon6 = new JButton(obsidian_block);
        icon6.setHorizontalTextPosition(SwingConstants.CENTER);

        ImageIcon glass_block = getScaledIcon(modDirectory + "\\ui_elements\\glass_block.png");
        icon8 = new JButton(glass_block);
        icon8.setHorizontalTextPosition(SwingConstants.CENTER);

        icon9 = new JButton();
        icon9.setHorizontalTextPosition(SwingConstants.CENTER);

        icon10 = new JButton();
        icon10.setHorizontalTextPosition(SwingConstants.CENTER);

        icon11 = new JButton();
        icon11.setHorizontalTextPosition(SwingConstants.CENTER);

        icon12 = new JButton();
        icon12.setHorizontalTextPosition(SwingConstants.CENTER);

        icon13 = new JButton();
        icon13.setHorizontalTextPosition(SwingConstants.CENTER);

        icon14 = new JButton();
        icon14.setHorizontalTextPosition(SwingConstants.CENTER);

        icon15 = new JButton();
        icon15.setHorizontalTextPosition(SwingConstants.CENTER);

        icon16 = new JButton();
        icon16.setHorizontalTextPosition(SwingConstants.CENTER);

        harvestLevel_textField = new JTextField();
        harvestLevel_textField.addActionListener(this::harvestLevel_textFieldActionPerformed);

        modDirectory_textField.setText(modDirectory);
        modDirectory_textField.addActionListener(this::modDirectory_textFieldActionPerformed);

        modDir_label.setText("Mod Directory:");

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
                        .addComponent(imageIconLabel, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
        );
        imagePanelLayout.setVerticalGroup(
                imagePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(imageIconLabel, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
        );
        imagePanel.setVisible(true);
        this.add(imagePanel);
        unusedDirectory_textField.setText(unusedDirectory);
        unusedDirectory_textField.addActionListener(this::unusedDirectory_textFieldActionPerformed);

        unusedDir_label.setText("Unused Textures:");

        usedDirectory_textField.setText(usedDirectory);
        usedDirectory_textField.addActionListener(this::usedDirectory_textFieldActionPerformed);

        usedDir_label.setText("Used Textures:");

        skippedDirectory_textField.setText(skippedDirectory);
        skippedDirectory_textField.addActionListener(this::skippedDirectory_textFieldActionPerformed);

        skippedDir_label.setText("Skipped Textures:");

        currentImage_label.setText("Currently Parsed Texture:");

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

        current_texture.setText("texture_name");

        hardness_label.setText("Hardness:");

        resistance_label.setText("Resistance:");

        sound_label.setText("Sound Type:");

        harvest_label.setText("Harvest Level:");

        harvestTool_label.setText("Harvest Tool:");

        material_label.setText("Material:");

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

        icon12.setText("");
        icon12.setMaximumSize(new Dimension(40, 40));
        icon12.setMinimumSize(new Dimension(40, 40));
        icon12.setPreferredSize(new Dimension(40, 40));
        icon12.addActionListener(this::icon12_buttonActionPerformed);

        icon1.setText("");
        icon1.setMaximumSize(new Dimension(40, 40));
        icon1.setMinimumSize(new Dimension(40, 40));
        icon1.setPreferredSize(new Dimension(40, 40));
        icon1.addActionListener(this::icon1_buttonActionPerformed);

        icon2.setText("");
        icon2.setMaximumSize(new Dimension(40, 40));
        icon2.setMinimumSize(new Dimension(40, 40));
        icon2.setPreferredSize(new Dimension(40, 40));
        icon2.addActionListener(this::icon2_buttonActionPerformed);

        icon3.setText("");
        icon3.setMaximumSize(new Dimension(40, 40));
        icon3.setMinimumSize(new Dimension(40, 40));
        icon3.setPreferredSize(new Dimension(40, 40));
        icon3.addActionListener(this::icon3_buttonActionPerformed);

        icon4.setText("");
        icon4.setMaximumSize(new Dimension(40, 40));
        icon4.setMinimumSize(new Dimension(40, 40));
        icon4.setPreferredSize(new Dimension(40, 40));
        icon4.addActionListener(this::icon4_buttonActionPerformed);

        icon5.setText("");
        icon5.setMaximumSize(new Dimension(40, 40));
        icon5.setMinimumSize(new Dimension(40, 40));
        icon5.setPreferredSize(new Dimension(40, 40));
        icon5.addActionListener(this::icon5_buttonActionPerformed);

        icon6.setText("");
        icon6.setMaximumSize(new Dimension(40, 40));
        icon6.setMinimumSize(new Dimension(40, 40));
        icon6.setPreferredSize(new Dimension(40, 40));
        icon6.addActionListener(this::icon6_buttonActionPerformed);

        icon7.setText("");
        icon7.setMaximumSize(new Dimension(40, 40));
        icon7.setMinimumSize(new Dimension(40, 40));
        icon7.setPreferredSize(new Dimension(40, 40));
        icon7.addActionListener(this::icon7_buttonActionPerformed);

        icon8.setText("");
        icon8.setMaximumSize(new Dimension(40, 40));
        icon8.setMinimumSize(new Dimension(40, 40));
        icon8.setPreferredSize(new Dimension(40, 40));
        icon8.addActionListener(this::icon8_buttonActionPerformed);

        icon9.setText("");
        icon9.setMaximumSize(new Dimension(40, 40));
        icon9.setMinimumSize(new Dimension(40, 40));
        icon9.setPreferredSize(new Dimension(40, 40));
        icon9.addActionListener(this::icon9_buttonActionPerformed);

        icon10.setText("");
        icon10.setMaximumSize(new Dimension(40, 40));
        icon10.setMinimumSize(new Dimension(40, 40));
        icon10.setPreferredSize(new Dimension(40, 40));
        icon10.addActionListener(this::icon10_buttonActionPerformed);

        icon11.setText("");
        icon11.setMaximumSize(new Dimension(40, 40));
        icon11.setMinimumSize(new Dimension(40, 40));
        icon11.setPreferredSize(new Dimension(40, 40));
        icon11.addActionListener(this::icon11_buttonActionPerformed);

        icon13.setText("");
        icon13.setMaximumSize(new Dimension(40, 40));
        icon13.setMinimumSize(new Dimension(40, 40));
        icon13.setPreferredSize(new Dimension(40, 40));
        icon13.addActionListener(this::icon13_buttonActionPerformed);

        icon14.setText("");
        icon14.setMaximumSize(new Dimension(40, 40));
        icon14.setMinimumSize(new Dimension(40, 40));
        icon14.setPreferredSize(new Dimension(40, 40));
        icon14.addActionListener(this::icon14_buttonActionPerformed);

        icon15.setText("");
        icon15.setMaximumSize(new Dimension(40, 40));
        icon15.setMinimumSize(new Dimension(40, 40));
        icon15.setPreferredSize(new Dimension(40, 40));
        icon1.addActionListener(this::icon15_buttonActionPerformed);

        icon16.setText("");
        icon16.setMaximumSize(new Dimension(40, 40));
        icon16.setMinimumSize(new Dimension(40, 40));
        icon16.setPreferredSize(new Dimension(40, 40));
        icon16.addActionListener(this::icon16_buttonActionPerformed);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(output_ScrollPane)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(unusedDir_label)
                                                        .addComponent(modDir_label)
                                                        .addComponent(usedDir_label)
                                                        .addComponent(skippedDir_label))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(usedDirectory_textField)
                                                        .addComponent(unusedDirectory_textField)
                                                        .addComponent(modDirectory_textField)
                                                        .addComponent(skippedDirectory_textField)))
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
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                .addComponent(icon9, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(icon1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                .addComponent(icon10, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(icon2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                .addComponent(icon11, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(icon3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                .addComponent(icon12, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(icon4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                .addComponent(icon13, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(icon5, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                .addComponent(icon14, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(icon6, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                .addComponent(icon15, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(icon7, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                .addComponent(icon16, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(icon8, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                .addComponent(hardness_label)
                                                                                .addComponent(material_label)
                                                                                .addComponent(resistance_label)
                                                                                .addComponent(sound_label)
                                                                                .addComponent(harvest_label)
                                                                                .addComponent(harvestTool_label))
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addComponent(hardness_textField, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addComponent(hardness_slider, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                                .addComponent(material_ComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addComponent(resistance_textField, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addComponent(resistance_slider, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                                .addComponent(sound_ComboBox, 0, 316, Short.MAX_VALUE)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addComponent(harvestLevel_textField, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addComponent(harvestLevel_slider, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                                .addComponent(harvestTool_ComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                                        .addGap(0, 0, Short.MAX_VALUE))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(currentImage_label)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(current_texture, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(modDirectory_textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(modDir_label))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(unusedDirectory_textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(unusedDir_label))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(usedDirectory_textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(usedDir_label))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(skippedDirectory_textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(skippedDir_label))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(currentImage_label)
                                        .addComponent(current_texture))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(imagePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(skip_button)
                                                        .addComponent(generateCode_button)))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(material_label)
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(hardness_label)
                                                                        .addComponent(hardness_textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(material_ComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(hardness_slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                .addComponent(resistance_label)
                                                                .addComponent(resistance_textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(resistance_slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(sound_label)
                                                        .addComponent(sound_ComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(15, 15, 15)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                .addComponent(harvestLevel_textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(harvest_label))
                                                        .addComponent(harvestLevel_slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(harvestTool_label)
                                                        .addComponent(harvestTool_ComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(icon1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(icon9, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(icon2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(icon10, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(icon3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(icon11, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(icon4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(icon12, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(icon5, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(icon13, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(icon6, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(icon14, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(icon7, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(icon15, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(icon8, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(icon16, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                                .addComponent(output_ScrollPane, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                                .addContainerGap())
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
    private JLabel modDir_label;
    private JLabel harvest_label;
    private JLabel harvestTool_label;
    private JLabel material_label;
    private JLabel unusedDir_label;
    private JLabel usedDir_label;
    private JLabel skippedDir_label;
    private JLabel currentImage_label;
    private JLabel current_texture;
    private JLabel hardness_label;
    private JLabel resistance_label;
    private JLabel sound_label;

    // Panel declarations.
    private JPanel imagePanel;
    private ImageIcon imageIcon;
    private JLabel imageIconLabel;

    // Output panel declarations.
    private JTextArea output_TextArea;
    private JScrollPane output_ScrollPane;

    // The icons.
    private JPanel iconPanel;
    private JButton icon1;
    private JButton icon2;
    private JButton icon3;
    private JButton icon4;
    private JButton icon5;
    private JButton icon6;
    private JButton icon7;
    private JButton icon8;
    private JButton icon9;
    private JButton icon10;
    private JButton icon11;
    private JButton icon12;
    private JButton icon13;
    private JButton icon14;
    private JButton icon15;
    private JButton icon16;

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

    private void updateSliders(){
        hardness_slider.setValue(Integer.parseInt(hardness_label.getText())*10);
        resistance_slider.setValue(Integer.parseInt(resistance_label.getText())*10);
        harvestLevel_slider.setValue(Integer.parseInt(harvest_label.getText()));
    }

    private void icon1_buttonActionPerformed(java.awt.event.ActionEvent evt){
        outputText("Setting values appropriate for dirt block.");
        material_ComboBox.setSelectedItem("EARTH");
        hardness_textField.setText("0.5");
        resistance_textField.setText("0.5");
        sound_ComboBox.setSelectedItem("GROUND");
        harvestLevel_textField.setText("0");
        harvestTool_ComboBox.setSelectedItem("SHOVEL");
        updateSliders();
    }

    private void icon2_buttonActionPerformed(java.awt.event.ActionEvent evt){
        outputText("Setting values appropriate for sand block.");
        material_ComboBox.setSelectedItem("SAND");
        hardness_textField.setText("0.5");
        resistance_textField.setText("0.5");
        sound_ComboBox.setSelectedItem("SAND");
        harvestLevel_textField.setText("0");
        harvestTool_ComboBox.setSelectedItem("SHOVEL");
        updateSliders();
    }

    private void icon3_buttonActionPerformed(java.awt.event.ActionEvent evt){
        outputText("Setting values appropriate for wool block.");
        material_ComboBox.setSelectedItem("WOOL");
        hardness_textField.setText("0.8");
        resistance_textField.setText("0.8");
        sound_ComboBox.setSelectedItem("CLOTH");
        harvestLevel_textField.setText("0");
        harvestTool_ComboBox.setSelectedItem("NONE");
        updateSliders();
    }

    private void icon4_buttonActionPerformed(java.awt.event.ActionEvent evt){
        outputText("Setting values appropriate for stone block.");
        material_ComboBox.setSelectedItem("ROCK");
        hardness_textField.setText("1.5");
        resistance_textField.setText("6.0");
        sound_ComboBox.setSelectedItem("STONE");
        harvestLevel_textField.setText("0");
        harvestTool_ComboBox.setSelectedItem("PICKAXE");
        updateSliders();
    }

    private void icon5_buttonActionPerformed(java.awt.event.ActionEvent evt){
        outputText("Setting values appropriate for gold block.");
        material_ComboBox.setSelectedItem("IRON");
        hardness_textField.setText("3.0");
        resistance_textField.setText("6.0");
        sound_ComboBox.setSelectedItem("METAL");
        harvestLevel_textField.setText("1");
        harvestTool_ComboBox.setSelectedItem("PICKAXE");
        updateSliders();
    }

    private void icon6_buttonActionPerformed(java.awt.event.ActionEvent evt){
        outputText("Setting values appropriate for obsidian block.");
        material_ComboBox.setSelectedItem("ROCK");
        hardness_textField.setText("50.0");
        resistance_textField.setText("1200.0");
        sound_ComboBox.setSelectedItem("STONE");
        harvestLevel_textField.setText("3");
        harvestTool_ComboBox.setSelectedItem("PICKAXE");
        updateSliders();
    }

    private void icon7_buttonActionPerformed(java.awt.event.ActionEvent evt){
        outputText("Setting values appropriate for obsidian block.");
        material_ComboBox.setSelectedItem("WOOD");
        hardness_textField.setText("2.0");
        resistance_textField.setText("2.0");
        sound_ComboBox.setSelectedItem("WOOD");
        harvestLevel_textField.setText("0");
        harvestTool_ComboBox.setSelectedItem("AXE");
        updateSliders();
    }

    private void icon8_buttonActionPerformed(java.awt.event.ActionEvent evt){
        outputText("Setting values appropriate for glass block.");
        material_ComboBox.setSelectedItem("GLASS");
        hardness_textField.setText("0.3");
        resistance_textField.setText("0.3");
        sound_ComboBox.setSelectedItem("GLASS");
        harvestLevel_textField.setText("0");
        harvestTool_ComboBox.setSelectedItem("NONE");
        updateSliders();
    }

    private void icon9_buttonActionPerformed(java.awt.event.ActionEvent evt){

    }

    private void icon10_buttonActionPerformed(java.awt.event.ActionEvent evt){

    }

    private void icon11_buttonActionPerformed(java.awt.event.ActionEvent evt){

    }

    private void icon12_buttonActionPerformed(java.awt.event.ActionEvent evt){

    }

    private void icon13_buttonActionPerformed(java.awt.event.ActionEvent evt){

    }

    private void icon14_buttonActionPerformed(java.awt.event.ActionEvent evt){

    }

    private void icon15_buttonActionPerformed(java.awt.event.ActionEvent evt){

    }

    private void icon16_buttonActionPerformed(java.awt.event.ActionEvent evt){
        outputText("Setting values appropriate for sand block.");
        material_ComboBox.setSelectedItem("EARTH");
        hardness_textField.setText("0.5");
        resistance_textField.setText("0.5");
        sound_ComboBox.setSelectedItem("GROUND");
        harvestLevel_textField.setText("0");
        harvestTool_ComboBox.setSelectedItem("SHOVEL");
        updateSliders();
    }

    private void skip_buttonActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        itemAdderTool.update();
        itemAdderTool.skipTextures();
        currentFileIndex++;
        displayImage(filesToParse.get(currentFileIndex));
    }

    private void displayImage(File file) throws IOException {
        BufferedImage image = ImageIO.read(file);
        current_texture.setText(file.getName());
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

    // Appends text to the output text area.
    public void outputText(String text){
        output_TextArea.append(text);
        output_TextArea.append("\n");
    }
}
