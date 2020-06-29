package com.d0sag3.warcraftitems.util;

// Imports
import com.d0sag3.warcraftitems.blocks.*;
import com.d0sag3.warcraftitems.WarcraftItems;
import com.d0sag3.warcraftitems.items.ItemBase;
import net.minecraft.block.Block;
import net.minecraft.entity.item.PaintingType;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, WarcraftItems.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, WarcraftItems.MOD_ID);
    public static final DeferredRegister<PaintingType> PAINTING_TYPES = DeferredRegister.create(ForgeRegistries.PAINTING_TYPES, WarcraftItems.MOD_ID);

    public static void init(){
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        PAINTING_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Paintings
    public static RegistryObject<PaintingType> SIXAK_ARAKKOA_BACKGROUND = PAINTING_TYPES.register("sixak_arakkoa_background",()-> new PaintingType(32,32));
    public static RegistryObject<PaintingType> MAGETHETWOXTHETWO = PAINTING_TYPES.register("magethetwoxthetwo",()-> new PaintingType(64,64));
    public static RegistryObject<PaintingType> LKPAINTING = PAINTING_TYPES.register("lkpainting",()-> new PaintingType(64,48));
    public static RegistryObject<PaintingType> LKTHETWOXTHETWO = PAINTING_TYPES.register("lkthetwoxthetwo",()-> new PaintingType(32,16));
    public static RegistryObject<PaintingType> LKONESIXXTHETWO = PAINTING_TYPES.register("lkonesixxthetwo",()-> new PaintingType(16,32));
    public static RegistryObject<PaintingType> ILLIDANPAINTING = PAINTING_TYPES.register("illidanpainting",()-> new PaintingType(64,48));
    public static RegistryObject<PaintingType> GULDANPAINTING = PAINTING_TYPES.register("guldanpainting",()-> new PaintingType(64,32));
    public static RegistryObject<PaintingType> GOBLINPAINTING = PAINTING_TYPES.register("goblinpainting",()-> new PaintingType(16,16));
    public static RegistryObject<PaintingType> GIRLBLOODELFPAINTING = PAINTING_TYPES.register("girlbloodelfpainting",()-> new PaintingType(64,48));
    public static RegistryObject<PaintingType> DWARFWOLFBATTLEPAINTING = PAINTING_TYPES.register("dwarfwolfbattlepainting",()-> new PaintingType(64,48));
    public static RegistryObject<PaintingType> DRATHWINGPAINTING = PAINTING_TYPES.register("drathwingpainting",()-> new PaintingType(64,48));
    public static RegistryObject<PaintingType> BOOMYPAINTING = PAINTING_TYPES.register("boomypainting",()-> new PaintingType(64,48));
    public static RegistryObject<PaintingType> BONEDRAGONPAINTING = PAINTING_TYPES.register("bonedragonpainting",()-> new PaintingType(64,48));
    public static RegistryObject<PaintingType> ANGELTHETWOXONESIX = PAINTING_TYPES.register("angelthetwoxonesix",()-> new PaintingType(32,16));

    // Items
    public static final RegistryObject<Item> WOWTOKEN_ICON = ITEMS.register("wowtoken_icon", ItemBase::new);

    // Blocks

    // Block Items
}
