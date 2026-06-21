package com.endupdate.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class KigalEntity extends HostileEntity {
    private static final float SPEED = 0.35f;
    private static final double ATTACK_DAMAGE = 7.0;
    private static final int ATTACK_SPEED = 15;

    public KigalEntity(EntityType<? extends KigalEntity> type, World world) {
        super(type, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(2, new MeleeAttackGoal(this, SPEED, false));
        this.goalSelector.add(7, new WanderAroundFarGoal(this, SPEED));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    @Override
    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(net.minecraft.entity.attribute.EntityAttributes.MAX_HEALTH).setBaseValue(25.0);
        this.getAttributeInstance(net.minecraft.entity.attribute.EntityAttributes.MOVEMENT_SPEED).setBaseValue(SPEED);
        this.getAttributeInstance(net.minecraft.entity.attribute.EntityAttributes.ATTACK_DAMAGE).setBaseValue(ATTACK_DAMAGE);
    }
}
