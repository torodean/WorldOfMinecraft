package com.d0sag3.warcraftitems.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class DeepholmMicroCaveBlock extends Block {

    public DeepholmMicroCaveBlock() {
        super(Block.Properties.create(Material.ROCK)
                .hardnessAndResistance(4.0f, 5.0f)
                .sound(SoundType.STONE)
                .harvestLevel(1)
                .harvestTool(ToolType.PICKAXE)
        );
    }
}
