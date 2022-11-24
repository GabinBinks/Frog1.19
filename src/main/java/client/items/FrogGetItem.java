package client.items;

import client.renderer.FrogCactusRenderer;
import init.ItemInit;
import net.gabinks.frog.Frog;
import net.gabinks.frog.entities.FrogEntity;
import net.minecraft.client.renderer.entity.FrogRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Frog.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class FrogGetItem {
    @SubscribeEvent
    public static void playerInteractEvent(PlayerInteractEvent.EntityInteract event){
        Player player = event.getEntity();
        RegistryObject<Item> landing = ItemInit.LANDING_NET;
        if(!player.getItemInHand(event.getHand()).isEmpty() && player.getItemInHand(event.getHand()).getItem() == landing.get()){
            Entity entity = event.getTarget();
            if(entity instanceof FrogEntity){
                entity.remove(Entity.RemovalReason.DISCARDED);
                if(entity.getType().getDescriptionId().contains("entity.frog.flint_frog")){
                    entity.spawnAtLocation(new ItemStack(ItemInit.FLINT_FROG.get()));
                }
                if(entity.getType().getDescriptionId().contains("entity.frog.cactus_frog")){
                    entity.spawnAtLocation(new ItemStack(ItemInit.CACTUS_FROG.get()));
                }
                if(entity.getType().getDescriptionId().contains("entity.frog.nether_quartz_frog")){
                    entity.spawnAtLocation(new ItemStack(ItemInit.NETHER_QUARTZ_FROG.get()));
                }
                if(entity.getType().getDescriptionId().contains("entity.frog.soulsand_frog")){
                    entity.spawnAtLocation(new ItemStack(ItemInit.SOULSAND_FROG.get()));
                }
                if(entity.getType().getDescriptionId().contains("entity.frog.log_frog")){
                    entity.spawnAtLocation(new ItemStack(ItemInit.LOG_FROG.get()));
                }
                if(entity.getType().getDescriptionId().contains("entity.frog.cobblestone_frog")){
                    entity.spawnAtLocation(new ItemStack(ItemInit.COBBLESTONE_FROG.get()));
                }
                if(entity.getType().getDescriptionId().contains("entity.frog.bone_frog")){
                    entity.spawnAtLocation(new ItemStack(ItemInit.BONE_FROG.get()));
                }
                if(entity.getType().getDescriptionId().contains("entity.frog.sand_frog")){
                    entity.spawnAtLocation(new ItemStack(ItemInit.SAND_FROG.get()));
                }
                if(entity.getType().getDescriptionId().contains("entity.frog.nether_frog")){
                    entity.spawnAtLocation(new ItemStack(ItemInit.NETHER_FROG.get()));
                }
            }
        }
    }
}