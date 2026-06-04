package net.inorecon.faunaindepth.block;

import net.inorecon.faunaindepth.FaunaInDepth;

import net.inorecon.faunaindepth.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(FaunaInDepth.MODID);

    public static final  DeferredBlock<Block> BRAINBLOOM = registerBlock("brainbloom",
            ()-> new Block(BlockBehaviour.Properties.of()
                    .strength(2f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.SLIME_BLOCK)));

    public static final  DeferredBlock<Block> BRAIN_STEM = registerBlock("brain_stem",
            ()-> new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .strength(2f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STEM)));


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
