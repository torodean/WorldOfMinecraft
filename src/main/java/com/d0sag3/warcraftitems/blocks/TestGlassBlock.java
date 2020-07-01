package com.d0sag3.warcraftitems.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class TestGlassBlock extends Block {

    public TestGlassBlock() {
        super(Block.Properties.create(Material.GLASS)
                .hardnessAndResistance(0.3f, 0.3f)
                .sound(SoundType.GLASS)
                .harvestLevel(0)
        );
    }
}