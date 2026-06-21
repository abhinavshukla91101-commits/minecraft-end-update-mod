package com.endupdate.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

public class JikalBossEntity extends HostileEntity {
    private static final float SPEED = 0.25f;
    private static final double ATTACK_DAMAGE = 15.0;
    private static final int ATTACK_SPEED = 10;
    private static final int XP_DROP = 1699;

    private final ServerBossBar bossBar = new ServerBossBar(
        Text.literal("Jikal Boss"),
        BossBar.Color.PURPLE,
        BossBar.Style.PROGRESS
    );

    public JikalBossEntity(EntityType<? extends JikalBossEntity> type, World world) {
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
        this.getAttributeInstance(net.minecraft.entity.attribute.EntityAttributes.MAX_HEALTH).setBaseValue(100.0);
        this.getAttributeInstance(net.minecraft.entity.attribute.EntityAttributes.MOVEMENT_SPEED).setBaseValue(SPEED);
        this.getAttributeInstance(net.minecraft.entity.attribute.EntityAttributes.ATTACK_DAMAGE).setBaseValue(ATTACK_DAMAGE);
        this.getAttributeInstance(net.minecraft.entity.attribute.EntityAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.5);
    }

    @Override
    public void onDeath(net.minecraft.entity.damage.DamageSource damageSource) {
        this.dropXp(XP_DROP);
        super.onDeath(damageSource);
    }

    @Override
    public ServerBossBar getBossBar() {
        return this.bossBar;
    }
}
