package net.gamercave.thecursedmod.datagen;

import net.gamercave.thecursedmod.block.TheCursedModBlocks;
import net.gamercave.thecursedmod.item.TheCursedModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class TheCursedModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public TheCursedModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> CURSEDITEM_SMELTABLES = List.of(TheCursedModItems.RAW_CURSED_ITEM.get(),
                TheCursedModBlocks.CURSED_ORE.get(),
                TheCursedModBlocks.CURSED_DEEPSLATE_ORE.get());

        List<ItemLike> FREDBEAR_SMELTABLES = List.of(TheCursedModItems.UNFINISHED_FREDBEAR_PLUSH.get(),
                TheCursedModBlocks.FREDBEAR_ORE.get(),
                TheCursedModBlocks.FREDBEAR_DEEPSLATE_ORE.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TheCursedModBlocks.CURSED_BLOCK.get())
                .pattern("CCC")
                .pattern("CCC")
                .pattern("CCC")
                .define('C', TheCursedModItems.CURSED_ITEM.get())
                .unlockedBy(getHasName(TheCursedModItems.CURSED_ITEM.get()), has(TheCursedModItems.CURSED_ITEM.get())).save(pRecipeOutput);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TheCursedModBlocks.CURSED_ORE.get())
                .pattern("G G")
                .pattern("III")
                .pattern("CCC")
                .define('C', Items.COBBLESTONE)
                .define('I', Items.IRON_INGOT)
                .define('G', Items.GOLD_INGOT)
                .unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT)).save(pRecipeOutput);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TheCursedModItems.CURSED_ITEM.get(), 9)
                .requires(TheCursedModBlocks.CURSED_BLOCK.get())
                .unlockedBy(getHasName(TheCursedModBlocks.CURSED_BLOCK.get()), has(TheCursedModBlocks.CURSED_BLOCK.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.DIAMOND, 9)
                .requires(TheCursedModBlocks.TRANSFORMER_BLOCK.get())
                .unlockedBy(getHasName(TheCursedModBlocks.TRANSFORMER_BLOCK.get()), has(TheCursedModBlocks.TRANSFORMER_BLOCK.get())).save(pRecipeOutput);

        oreSmelting(pRecipeOutput, CURSEDITEM_SMELTABLES, RecipeCategory.MISC, TheCursedModItems.CURSED_ITEM.get(), 9999999, 200, "cursed");
        oreSmelting(pRecipeOutput, FREDBEAR_SMELTABLES, RecipeCategory.MISC, TheCursedModItems.FREDBEAR_PLUSH.get(), 999999999, 1, "fredbear");
    }
}
