package com.example.simplytech.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab TAB_SIMPLY_TECH = new CreativeModeTab("simplytech") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Moditems.RAW_CITRINE.get());
        }
    };
}
