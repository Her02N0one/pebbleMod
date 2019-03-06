package aydenmitchell.pebblemod.blocks;

import java.util.Random;

import aydenmitchell.pebblemod.Main;
import aydenmitchell.pebblemod.init.ModBlocks;
import aydenmitchell.pebblemod.init.ModItems;
import aydenmitchell.pebblemod.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockPebbleOre extends Block implements IHasModel {

	public BlockPebbleOre(String name, Material material) {
		
		super(material);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setSoundType(SoundType.STONE);
		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setHarvestLevel("pickaxe", 0);
		this.setCreativeTab(CreativeTabs.DECORATIONS);

		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
		
	}
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ModItems.PEBBLE;
	}
	
	@Override
	public int quantityDropped(Random random) {
		return random.nextInt(4) + 1;
	}
}