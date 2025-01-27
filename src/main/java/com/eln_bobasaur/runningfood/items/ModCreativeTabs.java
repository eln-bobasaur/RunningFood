package com.eln_bobasaur.runningfood.items;

import com.eln_bobasaur.runningfood.RunningFood;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RunningFood.MODID);

    public static final Supplier<CreativeModeTab> RUNNING_FOODS_TAB =
            CREATIVE_MODE_TABS.register("running_foods_tab",
                    () -> CreativeModeTab.builder()
                            .icon(() -> new ItemStack(ModItems.BURGER.get()))
                            .title(Component.translatable("creativetab.runningfood.running_foods_tab"))
                            .displayItems(((itemDisplayParameters, output) -> {
                                output.accept(ModItems.BURGER);
                            })).build());

    public static void register(IEventBus bus)
    {
        CREATIVE_MODE_TABS.register(bus);
    }
}
