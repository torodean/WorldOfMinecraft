package com.d0sag3.warcraftitems.util;

import com.d0sag3.warcraftitems.WarcraftItems;
import com.d0sag3.warcraftitems.blocks.BlockItemBase;
import com.d0sag3.warcraftitems.blocks.DeepholmMicroCaveBlock;
import com.d0sag3.warcraftitems.items.ItemBase;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, WarcraftItems.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, WarcraftItems.MOD_ID);

    public static void init(){
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Items
    public static final RegistryObject<Item> WOWTOKEN_ICON = ITEMS.register("wowtoken_icon", ItemBase::new);

    // Blocks
    public static final RegistryObject<Block> DEEPHOLM_MICRO_CAVE_BLOCK = BLOCKS.register("deepholm_micro_cave_block", DeepholmMicroCaveBlock::new);

    // Block Items
    public static final RegistryObject<Item> DEEPHOLM_MICRO_CAVE_BLOCK_ITEM
            = ITEMS.register("deepholm_micro_cave_block", () -> new BlockItemBase(DEEPHOLM_MICRO_CAVE_BLOCK.get()));
}
