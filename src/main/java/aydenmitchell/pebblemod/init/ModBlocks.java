package aydenmitchell.pebblemod.init;

import java.util.ArrayList;
import java.util.List;

import aydenmitchell.pebblemod.blocks.BlockBoulder;
import aydenmitchell.pebblemod.blocks.BlockFossilOre;
import aydenmitchell.pebblemod.blocks.BlockPebbleOre;
import aydenmitchell.pebblemod.blocks.BlockStoneFlower;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {
	
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block BOULDER = new BlockBoulder("boulder", Material.ROCK);
	public static final Block PEBBLE_ORE = new BlockPebbleOre("pebble_ore", Material.ROCK);
	public static final Block STONE_FLOWER = new BlockStoneFlower("stone_flower", Material.ROCK);
//	public static final Block FOSSIL_ORE = new BlockFossilOre("fossil_ore", Material.ROCK);
}
