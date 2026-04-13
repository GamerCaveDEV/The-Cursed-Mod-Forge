package net.gamercave.thecursedmod.datagen;

import net.gamercave.thecursedmod.block.TheCursedModBlocks;
import net.gamercave.thecursedmod.item.TheCursedModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class TheCursedModBlockLootTableProvider extends BlockLootSubProvider {
    protected TheCursedModBlockLootTableProvider(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate() {
        dropSelf(TheCursedModBlocks.CURSED_BLOCK.get());
        dropSelf(TheCursedModBlocks.TRANSFORMER_BLOCK.get());
        dropSelf(TheCursedModBlocks.FREDBEAR_BLOCK.get());

        this.add(TheCursedModBlocks.CURSED_ORE.get(),
                block -> createOreDrop(TheCursedModBlocks.CURSED_ORE.get(), TheCursedModItems.RAW_CURSED_ITEM.get()));

        this.add(TheCursedModBlocks.CURSED_DEEPSLATE_ORE.get(),
                block -> createOreDrop(TheCursedModBlocks.CURSED_DEEPSLATE_ORE.get(), TheCursedModItems.RAW_CURSED_ITEM.get()));

        this.add(TheCursedModBlocks.FREDBEAR_ORE.get(),
                block -> createOreDrop(TheCursedModBlocks.FREDBEAR_ORE.get(), TheCursedModItems.RAW_CURSED_ITEM.get()));

        this.add(TheCursedModBlocks.FREDBEAR_DEEPSLATE_ORE.get(),
                block -> createOreDrop(TheCursedModBlocks.FREDBEAR_DEEPSLATE_ORE.get(), TheCursedModItems.RAW_CURSED_ITEM.get()));


    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return TheCursedModBlocks.BLOCKS.getEntries().stream()
                .map(block -> (Block) block.get())
                .toList();
    }
}
