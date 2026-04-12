package net.gamercave.thecursedmod.datagen;

import com.jcraft.jorbis.Block;
import net.gamercave.thecursedmod.TheCursedMod;
import net.gamercave.thecursedmod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TheCursedMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.CURSED_ORE.get())
                .add(ModBlocks.CURSED_DEEPSLATE_ORE.get())
                .add(ModBlocks.FREDBEAR_ORE.get())
                .add(ModBlocks.FREDBEAR_DEEPSLATE_ORE.get())
                .add(ModBlocks.CURSED_BLOCK.get())
                .add(ModBlocks.FREDBEAR_BLOCK.get());


        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.CURSED_DEEPSLATE_ORE.get())
                .add(ModBlocks.FREDBEAR_DEEPSLATE_ORE.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.CURSED_ORE.get())
                .add(ModBlocks.FREDBEAR_ORE.get())
                .add(ModBlocks.FREDBEAR_BLOCK.get())
                .add(ModBlocks.CURSED_BLOCK.get());

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.TRANSFORMER_BLOCK.get());
    }
}
