package init;


import net.gabinks.frog.Frog;
import net.gabinks.frog.entities.FrogEntity;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(Registry.ENTITY_TYPE_REGISTRY, Frog.MOD_ID);

    public static final RegistryObject<EntityType<FrogEntity>> FLINT_FROG =
            ENTITY_TYPES.register("flint_frog",
                    () -> EntityType.Builder.of(FrogEntity::new, MobCategory.CREATURE)
                            .sized(0.5f, 0.5f)
                            .build(new ResourceLocation(Frog.MOD_ID, "flint_frog").toString()));

    public static final RegistryObject<EntityType<FrogEntity>> CACTUS_FROG =
            ENTITY_TYPES.register("cactus_frog",
                    () -> EntityType.Builder.of(FrogEntity::new, MobCategory.CREATURE)
                            .sized(0.5f, 0.5f)
                            .build(new ResourceLocation(Frog.MOD_ID, "cactus_frog").toString()));

    public static final RegistryObject<EntityType<FrogEntity>> NETHER_QUARTZ_FROG =
            ENTITY_TYPES.register("nether_quartz_frog",
                    () -> EntityType.Builder.of(FrogEntity::new, MobCategory.CREATURE)
                            .sized(0.5f, 0.5f)
                            .build(new ResourceLocation(Frog.MOD_ID, "nether_quartz_frog").toString()));

    public static final RegistryObject<EntityType<FrogEntity>> SOULSAND_FROG =
            ENTITY_TYPES.register("soulsand_frog",
                    () -> EntityType.Builder.of(FrogEntity::new, MobCategory.CREATURE)
                            .sized(0.5f, 0.5f)
                            .build(new ResourceLocation(Frog.MOD_ID, "soulsand_frog").toString()));

    public static final RegistryObject<EntityType<FrogEntity>> LOG_FROG =
            ENTITY_TYPES.register("log_frog",
                    () -> EntityType.Builder.of(FrogEntity::new, MobCategory.CREATURE)
                            .sized(0.5f, 0.5f)
                            .build(new ResourceLocation(Frog.MOD_ID, "log_frog").toString()));

    public static final RegistryObject<EntityType<FrogEntity>> COBBLESTONE_FROG =
            ENTITY_TYPES.register("cobblestone_frog",
                    () -> EntityType.Builder.of(FrogEntity::new, MobCategory.CREATURE)
                            .sized(0.5f, 0.5f)
                            .build(new ResourceLocation(Frog.MOD_ID, "cobblestone_frog").toString()));

    public static final RegistryObject<EntityType<FrogEntity>> BONE_FROG =
            ENTITY_TYPES.register("bone_frog",
                    () -> EntityType.Builder.of(FrogEntity::new, MobCategory.CREATURE)
                            .sized(0.5f, 0.5f)
                            .build(new ResourceLocation(Frog.MOD_ID, "bone_frog").toString()));

    public static final RegistryObject<EntityType<FrogEntity>> SAND_FROG =
            ENTITY_TYPES.register("sand_frog",
                    () -> EntityType.Builder.of(FrogEntity::new, MobCategory.CREATURE)
                            .sized(0.5f, 0.5f)
                            .build(new ResourceLocation(Frog.MOD_ID, "sand_frog").toString()));

    public static final RegistryObject<EntityType<FrogEntity>> NETHER_FROG =
            ENTITY_TYPES.register("nether_frog",
                    () -> EntityType.Builder.of(FrogEntity::new, MobCategory.CREATURE)
                            .sized(0.5f, 0.5f)
                            .build(new ResourceLocation(Frog.MOD_ID, "nether_frog").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
