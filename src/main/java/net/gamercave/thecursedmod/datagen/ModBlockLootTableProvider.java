package net.gamercave.thecursedmod.datagen;

import net.gamercave.thecursedmod.block.ModBlocks;
import net.gamercave.thecursedmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class  ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.CURSED_BLOCK.get());
        dropSelf(ModBlocks.TRANSFORMER_BLOCK.get());
        dropSelf(ModBlocks.FREDBEAR_BLOCK.get());

        this.add(ModBlocks.CURSED_ORE.get(),
                block -> createOreDrop(ModBlocks.CURSED_ORE.get(), ModItems.RAW_CURSED_ITEM.get()));

        this.add(ModBlocks.CURSED_DEEPSLATE_ORE.get(),
                block -> createOreDrop(ModBlocks.CURSED_DEEPSLATE_ORE.get(), ModItems.RAW_CURSED_ITEM.get()));

        this.add(ModBlocks.FREDBEAR_ORE.get(),
                block -> createOreDrop(ModBlocks.FREDBEAR_ORE.get(), ModItems.RAW_CURSED_ITEM.get()));

        this.add(ModBlocks.FREDBEAR_DEEPSLATE_ORE.get(),
                block -> createOreDrop(ModBlocks.FREDBEAR_DEEPSLATE_ORE.get(), ModItems.RAW_CURSED_ITEM.get()));


    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
