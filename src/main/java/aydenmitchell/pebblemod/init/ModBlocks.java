package aydenmitchell.pebblemod.init;

import java.util.ArrayList;
import java.util.List;

import aydenmitchell.pebblemod.blocks.BlockBase;
import aydenmitchell.pebblemod.blocks.BlockBoulder;
import aydenmitchell.pebblemod.blocks.BlockPebbleGrass;
import aydenmitchell.pebblemod.blocks.BlockPebbleLeaves;
import aydenmitchell.pebblemod.blocks.BlockPebbleOre;
import aydenmitchell.pebblemod.blocks.BlockStoneFlower;
import aydenmitchell.pebblemod.blocks.BlockStoneLog;
import aydenmitchell.pebblemod.blocks.BlockStoneSapling;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {
	
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block BOULDER = new BlockBoulder("boulder", Material.ROCK);
	public static final Block PEBBLE_ORE = new BlockPebbleOre("pebble_ore", Material.ROCK);
	public static final Block STONE_FLOWER = new BlockStoneFlower("stone_flower", Material.PLANTS);
	public static final Block PEBBLE_GRASS = new BlockPebbleGrass("peble_grass", Material.PLANTS);
	public static final Block STONE_LOG = new BlockStoneLog("stone_log", Material.PLANTS);
	public static final Block PEBBLE_LEAVES = new BlockPebbleLeaves("stone_log", Material.PLANTS);

	public static final Block STONE_SAPLING = new BlockStoneSapling("stone_sapling", Material.PLANTS);
}
