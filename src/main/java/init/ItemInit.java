package init;

import net.gabinks.frog.Frog;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Frog.MOD_ID);

    public static final RegistryObject<ForgeSpawnEggItem> FROG_ENTITY_SPAWN_EGG = ITEMS.register("frog_entity_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.FLINT_FROG, 0xFF55AA, 0x27DA9F,
                    props().stacksTo(16)));
    public static final RegistryObject<Item> LANDING_NET = ITEMS.register("landing_net",
            () -> new Item(props()));

    public static final RegistryObject<Item> FLINT_FROG = ITEMS.register("flint_frog",
            () -> new ForgeSpawnEggItem(ModEntityTypes.FLINT_FROG, 0, 0,
                    props()));

    public static final RegistryObject<Item> CACTUS_FROG = ITEMS.register("cactus_frog",
            () -> new ForgeSpawnEggItem(ModEntityTypes.CACTUS_FROG, 0, 0, props()));

    public static final RegistryObject<Item> NETHER_QUARTZ_FROG = ITEMS.register("nether_quartz_frog",
            () -> new ForgeSpawnEggItem(ModEntityTypes.NETHER_QUARTZ_FROG, 0, 0, props()));

    public static final RegistryObject<Item> SOULSAND_FROG = ITEMS.register("soulsand_frog",
            () -> new ForgeSpawnEggItem(ModEntityTypes.SOULSAND_FROG, 0, 0, props()));

    public static final RegistryObject<Item> LOG_FROG = ITEMS.register("log_frog",
            () -> new ForgeSpawnEggItem(ModEntityTypes.LOG_FROG, 0, 0, props()));

    public static final RegistryObject<Item> COBBLESTONE_FROG = ITEMS.register("cobblestone_frog",
            () -> new ForgeSpawnEggItem(ModEntityTypes.COBBLESTONE_FROG, 0, 0, props()));

    public static final RegistryObject<Item> BONE_FROG = ITEMS.register("bone_frog",
            () -> new ForgeSpawnEggItem(ModEntityTypes.BONE_FROG, 0, 0, props()));

    public static final RegistryObject<Item> SAND_FROG = ITEMS.register("sand_frog",
            () -> new ForgeSpawnEggItem(ModEntityTypes.SAND_FROG, 0, 0, props()));

    public static final RegistryObject<Item> NETHER_FROG = ITEMS.register("nether_frog",
            () -> new ForgeSpawnEggItem(ModEntityTypes.NETHER_FROG, 0, 0, props()));
    private static Item.Properties props() {
        return new Item.Properties().tab(Frog.FrogTab);
    }
}

