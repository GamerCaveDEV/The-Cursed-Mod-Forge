package net.gamercave.thecursedmod.datagen;

import net.gamercave.thecursedmod.block.ModBlocks;
import net.gamercave.thecursedmod.item.ModItems;
import net.gamercave.thecursedmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> CURSEDITEM_SMELTABLES = List.of(ModItems.RAW_CURSED_ITEM.get(),
                ModBlocks.CURSED_ORE.get(),
                ModBlocks.CURSED_DEEPSLATE_ORE.get());

        List<ItemLike> FREDBEAR_SMELTABLES = List.of(ModItems.UNFINISHED_FREDBEAR_PLUSH.get(),
                ModBlocks.FREDBEAR_ORE.get(),
                ModBlocks.FREDBEAR_DEEPSLATE_ORE.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CURSED_BLOCK.get())
                .pattern("CCC")
                .pattern("CCC")
                .pattern("CCC")
                .define('C', ModItems.CURSED_ITEM.get())
                .unlockedBy(getHasName(ModItems.CURSED_ITEM.get()), has(ModItems.CURSED_ITEM.get())).save(pRecipeOutput);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CURSED_ORE.get())
                .pattern("G G")
                .pattern("III")
                .pattern("CCC")
                .define('C', Items.COBBLESTONE)
                .define('I', Items.IRON_INGOT)
                .define('G', Items.GOLD_INGOT)
                .unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT)).save(pRecipeOutput);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CURSED_ITEM.get(), 9)
                .requires(ModBlocks.CURSED_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.CURSED_BLOCK.get()), has(ModBlocks.CURSED_BLOCK.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.DIAMOND, 9)
                .requires(ModBlocks.TRANSFORMER_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.TRANSFORMER_BLOCK.get()), has(ModBlocks.TRANSFORMER_BLOCK.get())).save(pRecipeOutput);

        oreSmelting(pRecipeOutput, CURSEDITEM_SMELTABLES, RecipeCategory.MISC, ModItems.CURSED_ITEM.get(), 9999999, 200, "cursed");
        oreSmelting(pRecipeOutput, FREDBEAR_SMELTABLES, RecipeCategory.MISC, ModItems.FREDBEAR_PLUSH.get(), 999999999, 1, "fredbear");
    }
}
