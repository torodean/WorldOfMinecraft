package com.d0sag3.warcraftitems.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class DarkportalTrimNewzeroneRedBlock extends Block {

    public DarkportalTrimNewzeroneRedBlock() {
        super(Block.Properties.create(Material.ROCK)
                .hardnessAndResistance(1.5f, 6.0f)
                .sound(SoundType.STONE)
                .harvestLevel(0)
                .harvestTool(ToolType.PICKAXE)
        );
    }
}