package net.gamercave.thecursedmod.datagen;

import net.gamercave.thecursedmod.TheCursedMod;
import net.gamercave.thecursedmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TheCursedMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.CURSED_BLOCK);
        blockWithItem(ModBlocks.FREDBEAR_BLOCK);

        blockWithItem(ModBlocks.CURSED_ORE);
        blockWithItem(ModBlocks.CURSED_DEEPSLATE_ORE);

        blockWithItem(ModBlocks.FREDBEAR_ORE);
        blockWithItem(ModBlocks.FREDBEAR_DEEPSLATE_ORE);

        blockWithItem(ModBlocks.TRANSFORMER_BLOCK);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));

    }
}
