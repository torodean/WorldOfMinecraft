package com.d0sag3.itemadder;

//import org.apache.commons.text.WordUtils;

import java.io.File;

/**
 * This class contains various tools used by the other ItemAdder Classes.
 */
public class ItemAdderTools {

    private String itemName;
    private String fileName;

    ItemAdderTools(File file){
        init(file);
    }

    private void init(File file){
        fileName = file.getName();
        itemName = fileName.substring(0, fileName.length() - 4);
    }

    public String getItemName(){
        return itemName;
    }

    public String getFileName(){
        return fileName;
    }

    public String getItemNameCapitalized(){
        return itemName.toUpperCase();
    }

    public String getItemNameProper(){
//        return WordUtils.capitalizeFully(itemName.replaceAll("_", "\\s"));
        return "";
    }
}
