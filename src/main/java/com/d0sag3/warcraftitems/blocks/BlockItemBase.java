package com.d0sag3.warcraftitems.blocks;

import com.d0sag3.warcraftitems.WarcraftItems;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

// This is a base class for block items.
public class BlockItemBase extends BlockItem {
    public BlockItemBase(Block block) {
        super(block, new Item.Properties().group(WarcraftItems.WOW_ITEMS));
    }
}
