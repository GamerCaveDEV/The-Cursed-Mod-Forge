package net.gamercave.thecursedmod.datagen;

import net.gamercave.thecursedmod.TheCursedMod;
import net.gamercave.thecursedmod.item.TheCursedModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class TheCursedModItemModelProvider extends ItemModelProvider {


    public TheCursedModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TheCursedMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(TheCursedModItems.CURSED_ITEM.get());
        basicItem(TheCursedModItems.FREDBEAR_PLUSH.get());
        basicItem(TheCursedModItems.RAW_CURSED_ITEM.get());
        basicItem(TheCursedModItems.UNFINISHED_FREDBEAR_PLUSH.get());
        basicItem(TheCursedModItems.FORGER.get());
        basicItem(TheCursedModItems.GOLDMAKER.get());
        basicItem(TheCursedModItems.SUPERSTAR.get());
        basicItem(TheCursedModItems.CURSED_MODE.get());
        basicItem(TheCursedModItems.CRYING_CHILD.get());
    }
}
