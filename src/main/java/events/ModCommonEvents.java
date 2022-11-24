package events;

import init.ModEntityTypes;
import net.gabinks.frog.Frog;
import net.gabinks.frog.entities.FrogEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ModCommonEvents {
    @Mod.EventBusSubscriber(modid = Frog.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents {
        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
            event.put(ModEntityTypes.FLINT_FROG.get(), FrogEntity.setAttributes());
            event.put(ModEntityTypes.CACTUS_FROG.get(), FrogEntity.setAttributes());
            event.put(ModEntityTypes.NETHER_QUARTZ_FROG.get(), FrogEntity.setAttributes());
            event.put(ModEntityTypes.SOULSAND_FROG.get(), FrogEntity.setAttributes());
            event.put(ModEntityTypes.LOG_FROG.get(), FrogEntity.setAttributes());
            event.put(ModEntityTypes.COBBLESTONE_FROG.get(), FrogEntity.setAttributes());
            event.put(ModEntityTypes.BONE_FROG.get(), FrogEntity.setAttributes());
            event.put(ModEntityTypes.SAND_FROG.get(), FrogEntity.setAttributes());
            event.put(ModEntityTypes.NETHER_FROG.get(), FrogEntity.setAttributes());
        }
    }
}
