package net.gabinks.frog;

import client.renderer.*;
import client.items.FrogGetItem;
import init.ItemInit;
import init.ModEntityTypes;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.ambient.AmbientCreature;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.geckolib3.GeckoLib;

@Mod(Frog.MOD_ID)
public class Frog
{
    public static final String MOD_ID = "frog";

    public Frog()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        ModEntityTypes.register(modEventBus);
        ItemInit.ITEMS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        MinecraftForge.EVENT_BUS.register(FrogGetItem.class);

        GeckoLib.initialize();
    }

    public static final CreativeModeTab FrogTab = new CreativeModeTab(MOD_ID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemInit.FROG_ENTITY_SPAWN_EGG.get());
        }
    };

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() ->{
            SpawnPlacements.register(ModEntityTypes.SAND_FROG.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AmbientCreature::checkMobSpawnRules);
            SpawnPlacements.register(ModEntityTypes.LOG_FROG.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AmbientCreature::checkMobSpawnRules);
            SpawnPlacements.register(ModEntityTypes.NETHER_FROG.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, net.minecraft.world.entity.animal.frog.Frog::checkFrogSpawnRules);
        });
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Register all the frogs
            EntityRenderers.register(ModEntityTypes.FLINT_FROG.get(), FrogFlintRenderer::new);
            EntityRenderers.register(ModEntityTypes.CACTUS_FROG.get(), FrogCactusRenderer::new);
            EntityRenderers.register(ModEntityTypes.NETHER_QUARTZ_FROG.get(), FrogNetherQuartzRenderer::new);
            EntityRenderers.register(ModEntityTypes.SOULSAND_FROG.get(), FrogSoulSandRenderer::new);
            EntityRenderers.register(ModEntityTypes.LOG_FROG.get(), FrogLogRenderer::new);
            EntityRenderers.register(ModEntityTypes.COBBLESTONE_FROG.get(), FrogCobblestoneRenderer::new);
            EntityRenderers.register(ModEntityTypes.BONE_FROG.get(), FrogBoneRenderer::new);
            EntityRenderers.register(ModEntityTypes.SAND_FROG.get(), FrogSandRenderer::new);
            EntityRenderers.register(ModEntityTypes.NETHER_FROG.get(), FrogNetherRenderer::new);
        }
    }
}
