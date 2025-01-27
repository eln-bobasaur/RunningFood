package com.eln_bobasaur.runningfood.datagen.structure;

import com.eln_bobasaur.runningfood.RunningFood;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModStructures {

    public static final DeferredRegister<StructureType<?>> STRUCTURES = DeferredRegister.create(Registries.STRUCTURE_TYPE,
            RunningFood.MODID);

    public static final DeferredHolder<StructureType<?>, StructureType<MickeyDs>> MICKEYDS = STRUCTURES.register("mickeyds", () -> explicitStructureTypeTyping(MickeyDs.CODEC));

    /**
     * Originally, I had a double lambda ()->()-> for the RegistryObject line above, but it turns out that
     * some IDEs cannot resolve the typing correctly. This method explicitly states what the return type
     * is so that the IDE can put it into the DeferredRegistry properly.
     */
    private static <T extends Structure> StructureType<T> explicitStructureTypeTyping(MapCodec<T> structureCodec) {
        return () -> structureCodec;
    }

    public static void register(IEventBus bus) {
        STRUCTURES.register(bus);
    }
}
