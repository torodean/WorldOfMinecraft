package com.d0sag3.warcraftitems.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class SevneDruidCeilingzeroneBlock extends Block {

    public SevneDruidCeilingzeroneBlock() {
        super(Block.Properties.create(Material.WOOD)
                .hardnessAndResistance(2.0f, 2.0f)
                .sound(SoundType.WOOD)
                .harvestLevel(0)
                .harvestTool(ToolType.AXE)
        );
    }
}