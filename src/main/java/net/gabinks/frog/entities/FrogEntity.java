package net.gabinks.frog.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.frog.Frog;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class FrogEntity extends Frog implements IAnimatable {
    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);

    public FrogEntity(EntityType<? extends Animal> type, Level level) {
        super(type, level);
    }

    public static AttributeSupplier setAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 10.0D)
                .add(Attributes.ATTACK_DAMAGE, 10.0D)
                .add(Attributes.MOVEMENT_SPEED, 1.5F).build();
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if(event.isMoving()){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.frog.walk", ILoopType.EDefaultLoopTypes.LOOP));
            return PlayState.CONTINUE;
        }
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.frog.croak", ILoopType.EDefaultLoopTypes.LOOP));
        return PlayState.CONTINUE;
    }
    private <E extends IAnimatable> PlayState predicate1(AnimationEvent<E> event) {
        if (this.jumpAnimationState.isStarted()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.frog.jump", ILoopType.EDefaultLoopTypes.HOLD_ON_LAST_FRAME));
            return PlayState.CONTINUE;
        }
        return PlayState.STOP;
    }
    private <E extends IAnimatable> PlayState predicate2(AnimationEvent<E> event) {
        if (this.isSwimming()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.frog.swim", ILoopType.EDefaultLoopTypes.LOOP));
            return PlayState.CONTINUE;
        } else if (this.swimIdleAnimationState.isStarted()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.frog.idle.water", ILoopType.EDefaultLoopTypes.LOOP));
            return PlayState.CONTINUE;
        }
        return PlayState.STOP;
    }
    private <E extends IAnimatable> PlayState predicate3(AnimationEvent<E> event) {
        if (this.tongueAnimationState.isStarted()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.frog.tongue", ILoopType.EDefaultLoopTypes.PLAY_ONCE));
            return PlayState.CONTINUE;
        }
        return PlayState.STOP;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
        data.addAnimationController(new AnimationController(this, "controller1", 0, this::predicate1));
        data.addAnimationController(new AnimationController(this, "controller2", 0, this::predicate2));
        data.addAnimationController(new AnimationController(this, "controller3", 0, this::predicate3));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    public static boolean canSpawn(EntityType<FrogEntity> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random){
        return checkAnimalSpawnRules(entityType, level, spawnType, pos, random);
    }
}
