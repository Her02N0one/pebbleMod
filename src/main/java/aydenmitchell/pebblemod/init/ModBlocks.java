package aydenmitchell.pebblemod.init;

import java.util.ArrayList;
import java.util.List;

import aydenmitchell.pebblemod.blocks.BlockBase;
import aydenmitchell.pebblemod.blocks.BlockBoulder;
import aydenmitchell.pebblemod.blocks.BlockPebbleOre;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;

public class ModBlocks {
	
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block BOULDER = new BlockBoulder("boulder", Material.ROCK);
	public static final Block PEBBLE_ORE = new BlockPebbleOre("pebble_ore", Material.ROCK);
	public static final Block STONE_FLOWER = new BlockBase("stone_flower", Material.PLANTS);
	public static final Block PEBBLE_GRASS = new BlockBase("peble_grass", Material.PLANTS);
	public static final Block STONE_LOG = new BlockBase("stone_log", Material.PLANTS);
	public static final Block PEBBLE_LEAVES = new BlockBase("peble_leaves", Material.PLANTS);
}
