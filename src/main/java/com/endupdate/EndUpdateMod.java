package com.endupdate;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.endupdate.entity.JacalEntity;
import com.endupdate.entity.KigalEntity;
import com.endupdate.entity.JikalBossEntity;
import com.endupdate.block.*;

public class EndUpdateMod implements ModInitializer {
    public static final String MOD_ID = "endupdate";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    // Entities
    public static final EntityType<JacalEntity> JACAL = Registry.register(
        Registries.ENTITY_TYPE,
        new Identifier(MOD_ID, "jacal"),
        FabricEntityTypeBuilder.create(SpawnGroup.HOSTILE, JacalEntity::new)
            .dimensions(EntityDimensions.fixed(0.6f, 1.8f))
            .build()
    );

    public static final EntityType<KigalEntity> KIGAL = Registry.register(
        Registries.ENTITY_TYPE,
        new Identifier(MOD_ID, "kigal"),
        FabricEntityTypeBuilder.create(SpawnGroup.HOSTILE, KigalEntity::new)
            .dimensions(EntityDimensions.fixed(0.7f, 1.9f))
            .build()
    );

    public static final EntityType<JikalBossEntity> JIKAL_BOSS = Registry.register(
        Registries.ENTITY_TYPE,
        new Identifier(MOD_ID, "jikal_boss"),
        FabricEntityTypeBuilder.create(SpawnGroup.HOSTILE, JikalBossEntity::new)
            .dimensions(EntityDimensions.fixed(1.5f, 3.5f))
            .build()
    );

    // Blocks
    public static final Block END_CRYSTAL_BLOCK = registerBlock("end_crystal_block", new EndCrystalBlock(FabricBlockSettings.create().resistance(50)));
    public static final Block VOID_STONE = registerBlock("void_stone", new VoidStoneBlock(FabricBlockSettings.create().resistance(50)));
    public static final Block ETHEREAL_GLASS = registerBlock("ethereal_glass", new EtherealGlassBlock(FabricBlockSettings.create().resistance(30)));
    public static final Block ENDER_PEARL_BLOCK = registerBlock("ender_pearl_block", new EnderPearlBlock(FabricBlockSettings.create().resistance(40)));

    private static Block registerBlock(String name, Block block) {
        Block registeredBlock = Registry.register(Registries.BLOCK, new Identifier(MOD_ID, name), block);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, name), new BlockItem(registeredBlock, new Item.Settings()));
        return registeredBlock;
    }

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing End Update Mod!");
    }
}
