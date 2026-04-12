package net.gamercave.thecursedmod.datagen;

import net.gamercave.thecursedmod.TheCursedMod;
import net.gamercave.thecursedmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {


    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TheCursedMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.CURSED_ITEM.get());
        basicItem(ModItems.FREDBEAR_PLUSH.get());
        basicItem(ModItems.RAW_CURSED_ITEM.get());
        basicItem(ModItems.UNFINISHED_FREDBEAR_PLUSH.get());
        basicItem(ModItems.FORGER.get());
        basicItem(ModItems.GOLDMAKER.get());
        basicItem(ModItems.SUPERSTAR.get());
    }
}
