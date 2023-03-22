package com.example.simplytech.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

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

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        if(Screen.hasShiftDown()) {
        components.add(Component.literal("Right click this item to get a random answer in Chat!").withStyle(ChatFormatting.GRAY));
        } else {
            components.add(Component.literal("Press SHIFT for more info").withStyle(ChatFormatting.GOLD));
        }


        super.appendHoverText(itemStack, level, components, flag);
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
