package client.models;

import net.gabinks.frog.Frog;
import net.gabinks.frog.entities.FrogEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class FrogSandEntityModel extends AnimatedGeoModel<FrogEntity> {

    @Override
    public ResourceLocation getModelResource(FrogEntity object) {
        return new ResourceLocation(Frog.MOD_ID, "geo/frog2.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FrogEntity object) {
        return new ResourceLocation(Frog.MOD_ID, "textures/entities/frog_sand_entity");
    }

    @Override
    public ResourceLocation getAnimationResource(FrogEntity animatable) {
        return new ResourceLocation(Frog.MOD_ID, "animations/frog.animation_2.json");
    }

}
