/*
 * File: ItemAdderTools.java
 * Author: d0sag3 (Antonius Torode)
 * Created: 6/25/2020
 * Description: Various tools and methods to work with the ItemAdder GUI elements.
 */

package com.d0sag3.itemadder;

//import org.apache.commons.text.WordUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors.
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * This class contains various tools used by the other ItemAdder Classes.
 */
public class ItemAdderTools {

    private String itemName;
    private String filePath;
    private String blockName;
    private String fileName;
    ItemAdderPanel mainPanel;

    // Main constructor for the ItemAdderTools class.
    ItemAdderTools(ItemAdderPanel panel){
        mainPanel = panel;
        update();
    }

    // Initializes the information for this class.
    // Must be used after each call to AddFullBlock() or skipBlock().
    public void update(){
        filePath = mainPanel.filesToParse.get(mainPanel.currentFileIndex).getAbsolutePath();
        fileName = mainPanel.filesToParse.get(mainPanel.currentFileIndex).getName().replaceAll(" ", "").toLowerCase();
        System.out.println("fileName set to: " + fileName);
//        mainPanel.outputText("test"); // This causes an error... Not sure why.

        itemName = fileName.substring(0, fileName.length() - 4);
        System.out.println("itemName set to: " + itemName);

        blockName = numberlessText(itemName) + "_block";
        System.out.println("blockName set to: " + blockName);
    }

    // This returns the item name without a file ending (containing the underscores).
    public String getBlockName(){
        return blockName;
    }

    // This will replace numbers in the string with words.
    public String numberlessText(String input){
        StringBuilder output = new StringBuilder();
        for (int i=0; i < input.length(  ); i++) {
            if(Character.isDigit(input.charAt(i))){
                output.append(getNumberChar(input.charAt(i)));
            } else {
                output.append(input.charAt(i));
            }
        }
        System.out.println("numberlessText created: " + output.toString());
        return output.toString();
    }

    //Returns a string depending on the input char.
    public String getNumberChar(char input){
        if (input == '0') {
            return "zer";
        } else if (input == '1') {
            return "one";
        } else if (input == '2') {
            return "two";
        } else if (input == '3') {
            return "the";
        } else if (input == '4') {
            return "fou";
        } else if (input == '5') {
            return "fiv";
        } else if (input == '6') {
            return "six";
        } else if (input == '7') {
            return "sev";
        } else if (input == '8') {
            return "eig";
        } else if (input == '9') {
            return "nin";
        } else {
            return "";
        }
    }

    // This returns the fileName with the file extension.
    public String getFileName(){
        return fileName;
    }

    // This returns the name of the item in all caps.
    public String getBlockNameCapitalized(){
        mainPanel.outputText("getBlockNameCapitalized returning: " + blockName.toUpperCase());
        return blockName.toUpperCase();
    }

    // This returns the name of the item as shown in Minecraft.
    public String getBlockNameProper(){
        String output = "";
        StringBuilder properBlockName = new StringBuilder();
        String noUnderscores = blockName.replaceAll("_", " ");
        Scanner scan = new Scanner(noUnderscores);

        while(scan.hasNext()) {
            String word = scan.next();
            properBlockName.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
        }

        output = properBlockName.toString().trim();
        mainPanel.outputText("getBlockNameProper returning: " + output);
        return output;
    }

    // This returns the name of the item as shown in Minecraft.
    public String getBlockNameClass(){
        mainPanel.outputText("getBlockNameClass returning: " + getBlockNameProper().replaceAll(" ", ""));
        return getBlockNameProper().replaceAll(" ", "");
    }

    // This is the text to be added into the block states file.
    public String getBlockStatesText(){
        return "{\n" +
                "  \"variants\": {\n" +
                "    \"\": { \"model\":  \"warcraftitems:block/" + blockName + "\" }\n" +
                "  }\n" +
                "}";
    }

    // Adds the appropriate json file to the blockstates.
    public void addBlockStateFile(){
        String blockStateFile = mainPanel.modDirectory + "\\src\\main\\resources\\assets\\warcraftitems\\blockstates\\" + blockName + ".json";
        createFile(blockStateFile);
        writeToFile(blockStateFile, getBlockStatesText());
    }

    // This is the text to be added to the en_us.json file.
    public String getLangAddition(){
        return ",\n" +
                "  \"block.warcraftitems." + blockName + "\": \"" + getBlockNameProper() + "\"";
    }

    // This will update the en_us.json file to include the appropriate line for the new item.
    public void addLangAddition() throws IOException {
        Path path = Paths.get(mainPanel.modDirectory + "\\src\\main\\resources\\assets\\warcraftitems\\lang\\en_us.json");
        Charset charset = StandardCharsets.UTF_8;

        String content = new String(Files.readAllBytes(path), charset);
        content = content.replaceAll("\n}", getLangAddition() + "\n}");
        Files.write(path, content.getBytes(charset));
    }

    // This is the text to be added to the json file in models/block/...
    public String getBlockModelText(){
        return "{\n" +
                "  \"parent\": \"block/cube_all\",\n" +
                "  \"textures\": {\n" +
                "    \"all\": \"warcraftitems:blocks/" + blockName + "\"\n" +
                "  }\n" +
                "}";
    }

    // Adds the appropriate json file to the block models.
    public void addBlockModelFile(){
        String blockModelFile = mainPanel.modDirectory + "\\src\\main\\resources\\assets\\warcraftitems\\models\\block\\" + blockName + ".json";
        createFile(blockModelFile);
        writeToFile(blockModelFile, getBlockModelText());
    }

    // This is the text to be added to the json file in models/item/...
    public String getBlockItemText(){
        return "{\n" +
                "  \"parent\": \"warcraftitems:block/" + blockName + "\"\n" +
                "}";
    }

    // Adds the appropriate json file to the block models.
    public void addItemModelFile(){
        String itemModelFile = mainPanel.modDirectory + "\\src\\main\\resources\\assets\\warcraftitems\\models\\item\\" + blockName + ".json";
        createFile(itemModelFile);
        writeToFile(itemModelFile, getBlockItemText());
    }

    // This is the text to create the new block class.
    public String getBlockClassText(){
        String soundComponent = "";
        String harvestToolComponent = "";
        if (!mainPanel.getSound_ComboBoxValue().equals("NONE")) {
            soundComponent = "                .sound(SoundType." + mainPanel.getSound_ComboBoxValue() + ")\n";
        }
        if (!mainPanel.getHarvestTool_ComboBoxValue().equals("NONE")) {
            harvestToolComponent = "                .harvestTool(ToolType." + mainPanel.getHarvestTool_ComboBoxValue() + ")\n";
        }

        return "package com.d0sag3.warcraftitems.blocks;\n" +
                "\n" +
                "import net.minecraft.block.Block;\n" +
                "import net.minecraft.block.SoundType;\n" +
                "import net.minecraft.block.material.Material;\n" +
                "import net.minecraftforge.common.ToolType;\n" +
                "\n" +
                "public class " + getBlockNameClass() + " extends Block {\n" +
                "\n" +
                "    public " + getBlockNameClass() + "() {\n" +
                "        super(Block.Properties.create(Material." + mainPanel.getMaterial_ComboBoxValue() + ")\n" +
                "                .hardnessAndResistance(" + mainPanel.getHardnessValue() + "f, " + mainPanel.getResistanceValue() + "f)\n" +
                soundComponent +
                "                .harvestLevel(" + mainPanel.getHarvestLevelValue() + ")\n" +
                harvestToolComponent +
                "        );\n" +
                "    }\n" +
                "}";
    }

    // Creates the block class with the appropriate code.
    public void addBlockClass(){
        String blockClassFile = mainPanel.modDirectory + "\\src\\main\\java\\com\\d0sag3\\warcraftitems\\blocks\\" + getBlockNameClass() + ".java";
        createFile(blockClassFile);
        writeToFile(blockClassFile, getBlockClassText());
    }

    // This is the text to be added to the registry handler.
    public String getRegistryHandlerText(){
        return "    public static final RegistryObject<Block> " + getBlockNameCapitalized() + " = BLOCKS.register(\"" + getBlockName() + "\", " + getBlockNameClass() + "::new);";
    }

    // This is the block item section to add to the registry handler.
    public String getRegistryHandlerBlockItemText(){
        return "    public static final RegistryObject<Item> " + getBlockNameCapitalized() + "_ITEM" + "\n" +
                "            = ITEMS.register(\"" + getBlockName() + "\", () -> new BlockItemBase(" + getBlockNameCapitalized() + ".get()));";
    }

    // This will add the appropriate text for the block item to the Registry Handler.
    public void addRegistryHandlerBlockItemText() throws IOException {
        Path path = Paths.get(mainPanel.modDirectory + "\\src\\main\\java\\com\\d0sag3\\warcraftitems\\util\\RegistryHandler.java");
        Charset charset = StandardCharsets.UTF_8;

        String content = new String(Files.readAllBytes(path), charset);
        content = content.replaceAll("// Block Items", "// Block Items\n" + getRegistryHandlerBlockItemText());
        Files.write(path, content.getBytes(charset));
    }

    // This is the import to add to the registry handler.
    public String getRegistryHandlerPaintingText(){
        return "    public static RegistryObject<PaintingType> " + numberlessText(itemName).toUpperCase() + " = PAINTING_TYPES.register(\"" + numberlessText(itemName) + "\",()-> new PaintingType(" + mainPanel.paintingWidth + "," + mainPanel.paintingHeight + "));";
    }

    // This will add the appropriate text for the import to the Registry Handler.
    public void addRegistryHandlerPainting() throws IOException {
        Path path = Paths.get(mainPanel.modDirectory + "\\src\\main\\java\\com\\d0sag3\\warcraftitems\\util\\RegistryHandler.java");
        Charset charset = StandardCharsets.UTF_8;

        String content = new String(Files.readAllBytes(path), charset);
        content = content.replaceAll("// Paintings", "// Paintings\n" + getRegistryHandlerPaintingText());
        Files.write(path, content.getBytes(charset));
    }

    // This will add the appropriate text for the new block to the Registry Handler.
    public void addRegistryHandlerText() throws IOException {
        Path path = Paths.get(mainPanel.modDirectory + "\\src\\main\\java\\com\\d0sag3\\warcraftitems\\util\\RegistryHandler.java");
        Charset charset = StandardCharsets.UTF_8;

        String content = new String(Files.readAllBytes(path), charset);
        content = content.replaceAll("// Blocks", "// Blocks\n" + getRegistryHandlerText());
        Files.write(path, content.getBytes(charset));
    }

    // This is the text needed to add a block to the loot table.
    public String getLootTableText(){
        return "{\n" +
                "  \"type\": \"minecraft:block\",\n" +
                "  \"pools\": [\n" +
                "    {\n" +
                "      \"rolls\": 1,\n" +
                "      \"entries\": [\n" +
                "        {\n" +
                "          \"type\": \"minecraft:item\",\n" +
                "          \"name\": \"warcraftitems:" + getBlockName() + "\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";
    }

    // This will add the block to the loot tables by creating the appropriate json file.
    public void addLootTableFile(){
        String lootTableFile = mainPanel.modDirectory + "\\src\\main\\resources\\data\\warcraftitems\\loot_tables\\blocks\\" + blockName + ".json";
        createFile(lootTableFile);
        writeToFile(lootTableFile, getLootTableText());
    }

    public void addPainting(int width, int height) throws IOException {
        addRegistryHandlerPainting();
        File file = new File(filePath);
        BufferedImage originalImage = ImageIO.read(file);

        // Creates scaled images.
        BufferedImage scaledImage256 = getScaledImage(originalImage, width*16, height*16);
        BufferedImage scaledImage128 = getScaledImage(originalImage, width*8, height*8);
        BufferedImage scaledImage64 = getScaledImage(originalImage, width*4, height*4);
        BufferedImage scaledImage32 = getScaledImage(originalImage, width*2, height*2);
        BufferedImage scaledImage16 = getScaledImage(originalImage, width, height);

        String output_fileName;

        output_fileName = mainPanel.modDirectory + "\\src\\main\\resources\\assets\\warcraftitems\\textures256\\painting\\" + numberlessText(itemName) + ".png";
        ImageIO.write( scaledImage256, "PNG", new File(output_fileName) ); //write the image to a file
        output_fileName = mainPanel.modDirectory + "\\src\\main\\resources\\assets\\warcraftitems\\textures128\\painting\\" + numberlessText(itemName) + ".png";
        ImageIO.write( scaledImage128, "PNG", new File(output_fileName) ); //write the image to a file
        output_fileName = mainPanel.modDirectory + "\\src\\main\\resources\\assets\\warcraftitems\\textures64\\painting\\" + numberlessText(itemName) + ".png";
        ImageIO.write( scaledImage64, "PNG", new File(output_fileName) ); //write the image to a file
        output_fileName = mainPanel.modDirectory + "\\src\\main\\resources\\assets\\warcraftitems\\textures32\\painting\\" + numberlessText(itemName) + ".png";
        ImageIO.write( scaledImage32, "PNG", new File(output_fileName) ); //write the image to a file
        output_fileName = mainPanel.modDirectory + "\\src\\main\\resources\\assets\\warcraftitems\\textures16\\painting\\" + numberlessText(itemName) + ".png";
        ImageIO.write( scaledImage16, "PNG", new File(output_fileName) ); //write the image to a file

        // Copies the original size.
        Path path = Paths.get(filePath);
        Files.copy(Paths.get(mainPanel.modDirectory + "\\src\\main\\resources\\assets\\warcraftitems\\textures256\\painting\\" + numberlessText(itemName) + ".png"), Paths.get(mainPanel.modDirectory + "\\src\\main\\resources\\assets\\warcraftitems\\textures\\painting\\" + numberlessText(itemName) + ".png"));
        Files.move(path, Paths.get(mainPanel.usedDirectory + "\\" + getFileName()));
    }

    // This will add the code required to add a full block to the list.
    public void addFullBlock() throws IOException {
        addBlockClass();
        addBlockModelFile();
        addBlockStateFile();
        addItemModelFile();
        addLangAddition();
        addRegistryHandlerText();
        addRegistryHandlerBlockItemText();
        addLootTableFile();
        addTextures();
    }

    private BufferedImage getScaledImage(BufferedImage originalImage, int width, int height){
        BufferedImage scaledImage = new BufferedImage( width, height, originalImage.getType() );
        Graphics2D graphic2D = scaledImage.createGraphics(); //create a graphics object to paint to
        graphic2D.setBackground( Color.WHITE );
        graphic2D.setPaint( Color.WHITE );
        graphic2D.fillRect( 0, 0, width, height );
        graphic2D.setRenderingHint( RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR );
        graphic2D.drawImage( originalImage, 0, 0, width, height, null ); //draw the image scaled

        return scaledImage;
    }

    public void addTextures() {
        try{
            // TODO - THIS IS ALL PRODUCTION CODE. CURRENTLY COMMENTED OUT TO MAKE TESTING EASIER.
//            File file = new File(filePath);
//            BufferedImage originalImage = ImageIO.read(file);
//
//            // Creates scaled images.
//            BufferedImage scaledImage256 = getScaledImage(originalImage, 256, 256);
//            BufferedImage scaledImage128 = getScaledImage(originalImage, 128, 128);
//            BufferedImage scaledImage64 = getScaledImage(originalImage, 64, 64);
//            BufferedImage scaledImage32 = getScaledImage(originalImage, 32, 32);
//            BufferedImage scaledImage16 = getScaledImage(originalImage, 16, 16);
//
//            String output_fileName;
//
//            // Copies all the scaled images to the proper folders.
//            output_fileName = mainPanel.modDirectory + "\\src\\main\\resources\\assets\\warcraftitems\\textures256\\blocks\\" + getBlockName() + ".png";
//            ImageIO.write( scaledImage256, "PNG", new File(output_fileName) ); //write the image to a file
//            output_fileName = mainPanel.modDirectory + "\\src\\main\\resources\\assets\\warcraftitems\\textures128\\blocks\\" + getBlockName() + ".png";
//            ImageIO.write( scaledImage128, "PNG", new File(output_fileName) ); //write the image to a file
//            output_fileName = mainPanel.modDirectory + "\\src\\main\\resources\\assets\\warcraftitems\\textures64\\blocks\\" + getBlockName() + ".png";
//            ImageIO.write( scaledImage64, "PNG", new File(output_fileName) ); //write the image to a file
//            output_fileName = mainPanel.modDirectory + "\\src\\main\\resources\\assets\\warcraftitems\\textures32\\blocks\\" + getBlockName() + ".png";
//            ImageIO.write( scaledImage32, "PNG", new File(output_fileName) ); //write the image to a file
//            output_fileName = mainPanel.modDirectory + "\\src\\main\\resources\\assets\\warcraftitems\\textures16\\blocks\\" + getBlockName() + ".png";
//            ImageIO.write( scaledImage16, "PNG", new File(output_fileName) ); //write the image to a file
//
//            output_fileName = mainPanel.modDirectory + "\\src\\main\\resources\\assets\\warcraftitems\\textures256\\items\\" + getBlockName() + ".png";
//            ImageIO.write( scaledImage256, "PNG", new File(output_fileName) ); //write the image to a file
//            output_fileName = mainPanel.modDirectory + "\\src\\main\\resources\\assets\\warcraftitems\\textures128\\items\\" + getBlockName() + ".png";
//            ImageIO.write( scaledImage128, "PNG", new File(output_fileName) ); //write the image to a file
//            output_fileName = mainPanel.modDirectory + "\\src\\main\\resources\\assets\\warcraftitems\\textures64\\items\\" + getBlockName() + ".png";
//            ImageIO.write( scaledImage64, "PNG", new File(output_fileName) ); //write the image to a file
//            output_fileName = mainPanel.modDirectory + "\\src\\main\\resources\\assets\\warcraftitems\\textures32\\items\\" + getBlockName() + ".png";
//            ImageIO.write( scaledImage32, "PNG", new File(output_fileName) ); //write the image to a file
//            output_fileName = mainPanel.modDirectory + "\\src\\main\\resources\\assets\\warcraftitems\\textures16\\items\\" + getBlockName() + ".png";
//            ImageIO.write( scaledImage16, "PNG", new File(output_fileName) ); //write the image to a file

            // Copies the original size.
            Path path = Paths.get(filePath);
            Files.copy(path, Paths.get(mainPanel.modDirectory + "\\src\\main\\resources\\assets\\warcraftitems\\textures\\blocks\\" + getBlockName() + ".png"));
            Files.copy(path, Paths.get(mainPanel.modDirectory + "\\src\\main\\resources\\assets\\warcraftitems\\textures\\items\\" + getBlockName() + ".png"));
            Files.move(path, Paths.get(mainPanel.usedDirectory + "\\" + getFileName()));
        } catch (IOException ie) {
            mainPanel.outputText(ie.toString());
        }
    }

    public void skipTextures() throws IOException {
        mainPanel.outputText("Moving current files to skipped files.");
        Path path = Paths.get(filePath);
        Files.move(path, Paths.get(mainPanel.skippedDirectory + "\\" + getFileName()));
    }

    // Creates a file.
    public void createFile(String file){
        try {
            File myObj = new File(file);
            if (myObj.createNewFile()) {
                mainPanel.outputText("File created: " + myObj.getName());
            } else {
                mainPanel.outputText("File already exists.");
            }
        } catch (IOException e) {
            mainPanel.outputText("An error occurred.");
            e.printStackTrace();
        }
    }

    // Writes to a file.
    public void writeToFile(String file, String text){
        try {
            FileWriter myWriter = new FileWriter(file);
            myWriter.write(text);
            myWriter.close();
            mainPanel.outputText("Successfully wrote to the file: " + file);
            mainPanel.outputText("data written: " + text);
        } catch (IOException e) {
            mainPanel.outputText("An error occurred.");
            e.printStackTrace();
        }
    }
}
