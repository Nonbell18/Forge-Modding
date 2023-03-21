package com.example.simplytech.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EightBallItem extends Item {

    public EightBallItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(!level.isClientSide && hand == InteractionHand.MAIN_HAND) {
            OutputRandomAnswer(player);
            player.getCooldowns().addCooldown(this, 20);
        }


        return super.use(level, player, hand);
    }


    private void OutputRandomAnswer(Player player) {
        if (RandomNumber() == 0) {
            player.sendSystemMessage(Component.literal("My answer is: yes"));
        } else if (RandomNumber() == 1) {
            player.sendSystemMessage(Component.literal("my answer is: no"));
        }
    }

    private int RandomNumber() {
        return RandomSource.create().nextInt(2);
    }
}
