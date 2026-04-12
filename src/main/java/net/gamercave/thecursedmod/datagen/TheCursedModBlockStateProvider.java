package net.gamercave.thecursedmod.datagen;

import net.gamercave.thecursedmod.TheCursedMod;
import net.gamercave.thecursedmod.block.TheCursedModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class TheCursedModBlockStateProvider extends BlockStateProvider {
    public TheCursedModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TheCursedMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(TheCursedModBlocks.CURSED_BLOCK);
        blockWithItem(TheCursedModBlocks.FREDBEAR_BLOCK);

        blockWithItem(TheCursedModBlocks.CURSED_ORE);
        blockWithItem(TheCursedModBlocks.CURSED_DEEPSLATE_ORE);

        blockWithItem(TheCursedModBlocks.FREDBEAR_ORE);
        blockWithItem(TheCursedModBlocks.FREDBEAR_DEEPSLATE_ORE);

        blockWithItem(TheCursedModBlocks.TRANSFORMER_BLOCK);
    }

    private void blockWithItem(DeferredBlock<Block> block) {
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }
}
