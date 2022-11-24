package client.renderer;

import client.models.FrogFlintEntityModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.gabinks.frog.Frog;
import net.gabinks.frog.entities.FrogEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class FrogFlintRenderer extends GeoEntityRenderer<FrogEntity> {

    public FrogFlintRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new FrogFlintEntityModel());
        this.shadowRadius = 0.3F;
    }

    @Override
    public ResourceLocation getTextureLocation(FrogEntity animatable) {
        return new ResourceLocation(Frog.MOD_ID, "textures/entities/frog_flint_entity.png");
    }

    @Override
    public RenderType getRenderType(FrogEntity animatable, float partialTick, PoseStack poseStack,
                                    @Nullable MultiBufferSource bufferSource,
                                    @Nullable VertexConsumer buffer, int packedLight,
                                    ResourceLocation texture) {



        return super.getRenderType(animatable, partialTick, poseStack, bufferSource, buffer, packedLight, texture);
    }
}
