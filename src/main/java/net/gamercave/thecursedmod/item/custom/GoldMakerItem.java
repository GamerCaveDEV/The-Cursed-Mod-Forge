package net.gamercave.thecursedmod.item.custom; // Adjust package name

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class GoldMakerItem extends Item {

    public GoldMakerItem(Properties pProperties) {
        super(pProperties);
    }

    // This method is called when the item is right-clicked on a block
    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();

        // 1. Check if the code is running on the logical server side.
        // Block placement and modifications must ALWAYS happen on the server.
        if (!level.isClientSide()) {
            BlockPos clickedPos = pContext.getClickedPos();
            pContext.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), ((ServerPlayer) pContext.getPlayer()),
                    item -> pContext.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

            level.playSound(null, pContext.getClickedPos(), SoundEvents.AMETHYST_BLOCK_PLACE, SoundSource.BLOCKS);

            // 2. Set the block at the clicked position to a Gold Block.
            // Blocks.GOLD_BLOCK is the static reference to the Minecraft Gold Block.
            boolean success = level.setBlock(clickedPos, Blocks.GOLD_ORE.defaultBlockState(), 3);

            if (success) {
                // 3. Consume one item from the player's stack.
                // This makes the item one-time use per gold block placed.
                // Remove this line if you want the item to have infinite uses.
                pContext.getItemInHand().shrink(1);

                // 4. Return success to stop further interaction handling.
                return InteractionResult.SUCCESS;
            }
        }

        // Return a positive result for client-side to play the arm swing animation.
        return InteractionResult.CONSUME;
    }
}