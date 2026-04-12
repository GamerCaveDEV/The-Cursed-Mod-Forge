package net.gamercave.thecursedmod.datagen;

import net.gamercave.thecursedmod.TheCursedMod;
import net.gamercave.thecursedmod.block.TheCursedModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class TheCursedModBlockTagProvider extends BlockTagsProvider {
    public TheCursedModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TheCursedMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(TheCursedModBlocks.CURSED_ORE.get())
                .add(TheCursedModBlocks.CURSED_DEEPSLATE_ORE.get())
                .add(TheCursedModBlocks.FREDBEAR_ORE.get())
                .add(TheCursedModBlocks.FREDBEAR_DEEPSLATE_ORE.get())
                .add(TheCursedModBlocks.CURSED_BLOCK.get())
                .add(TheCursedModBlocks.FREDBEAR_BLOCK.get());


        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(TheCursedModBlocks.CURSED_DEEPSLATE_ORE.get())
                .add(TheCursedModBlocks.FREDBEAR_DEEPSLATE_ORE.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(TheCursedModBlocks.CURSED_ORE.get())
                .add(TheCursedModBlocks.FREDBEAR_ORE.get())
                .add(TheCursedModBlocks.FREDBEAR_BLOCK.get())
                .add(TheCursedModBlocks.CURSED_BLOCK.get());

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(TheCursedModBlocks.TRANSFORMER_BLOCK.get());
    }
}
