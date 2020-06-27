package com.d0sag3.itemadder;

//import org.apache.commons.text.WordUtils;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This class contains various tools used by the other ItemAdder Classes.
 */
public class ItemAdderTools {

    // Variables stored in this class.
    private String itemName;
    private String blockName;
    private String fileName;
    ItemAdderPanel mainPanel;

    // Main constructor for the ItemAdderTools class.
    ItemAdderTools(ItemAdderPanel panel){
        mainPanel = panel;
        init();
    }

    // Initializes the information for this class.
    private void init(){
        fileName = mainPanel.currentFile.getName();
        itemName = fileName.substring(0, fileName.length() - 4);
        blockName = itemName + "_block";
    }

    // This returns the item name without a file ending (containing the underscores).
    public String getBlockName(){
        return blockName;
    }

    // This returns the fileName with the file extension.
    public String getFileName(){
        return fileName;
    }

    // This returns the name of the item in all caps.
    public String getBlockNameCapitalized(){
        return blockName.toUpperCase();
    }

    // This returns the name of the item as shown in Minecraft.
    public String getBlockNameProper(){
        //TODO - This won't work because I can't get it to compile with my added jar.
//        return WordUtils.capitalizeFully(blockName.replaceAll("_", "\\s"));
        return "";
    }

    // This returns the name of the item as shown in Minecraft.
    public String getBlockNameClass(){
        return getBlockNameProper().replaceAll("\\s", "");
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
                "                .sound(SoundType." + mainPanel.getSound_ComboBoxValue() + ")\n" +
                "                .harvestLevel(" + mainPanel.getHarvestLevelValue() + ")\n" +
                "                .harvestTool(ToolType." + mainPanel.getHarvestTool_ComboBoxValue() + ")\n" +
                "        );\n" +
                "    }\n" +
                "}";
    }

    // Creates the block class with the appropriate code.
    public void addBlockClass(){
        String blockClassFile = mainPanel.modDirectory + "\\src\\main\\java\\com\\d0sag3\\warcraftitems\\blocks" + getBlockNameClass() + ".java";
        createFile(blockClassFile);
        writeToFile(blockClassFile, getBlockClassText());
    }

    // This is the text to be added to the registry handler.
    public String getRegistryHandlerText(){
        return "    public static final RegistryObject<Block> " + getBlockNameCapitalized() + " = BLOCKS.register(\"" + getBlockName() + "\", " + getBlockNameClass() + "::new);\n"
    }

    // This will add the appropriate text for the new block to the Registry Handler.
    public void addRegistryHandlerText() throws IOException {
        Path path = Paths.get(mainPanel.modDirectory + "\\src\\main\\java\\com\\d0sag3\\warcraftitems\\util");
        Charset charset = StandardCharsets.UTF_8;

        String content = new String(Files.readAllBytes(path), charset);
        content = content.replaceAll("// Blocks\n", "// Blocks\n" + getRegistryHandlerText());
        Files.write(path, content.getBytes(charset));
    }

    // This will add the code required to add a full block to the list.
    public void AddFullBlock() throws IOException {
        addBlockClass();
        addBlockModelFile();
        addBlockStateFile();
        addItemModelFile();
        addLangAddition();
        addRegistryHandlerText();
    }

    // Creates a file.
    public void createFile(String file){
        try {
            File myObj = new File(file);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // Writes to a file.
    public void writeToFile(String file, String text){
        try {
            FileWriter myWriter = new FileWriter(file);
            myWriter.write(text);
            myWriter.close();
            System.out.println("Successfully wrote to the file: " + file);
            System.out.println("data written: " + text);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
