package com.d0sag3.warcraftitems.items;

import com.d0sag3.warcraftitems.WarcraftItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemBase extends Item {
    public ItemBase() {
        super(new Item.Properties().group(WarcraftItems.WOW_ITEMS));
    }
}
