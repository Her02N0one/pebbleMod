package aydenmitchell.pebblemod.blocks;

import aydenmitchell.pebblemod.Main;
import aydenmitchell.pebblemod.util.IHasModel;
import aydenmitchell.pebblemod.util.IMetaName;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;

public class BlockFossilOre extends Block implements IHasModel, IMetaName
{
	public enum BlockType implements IStringSerializable
	{
		FOSSIL1("name1"),
		FOSSIL2("name2");
		
		public final String name;
		BlockType(String name)
		{
			this.name = name;
		}
		@Override
		public String getName()
		{
			return name;
		}
		
	}
	
	public static final PropertyEnum BLOCK_TYPE = PropertyEnum.create("block_type", BlockType.class);
	
	public BlockFossilOre(String name, Material material)
	{
		super(material);
		this.setCreativeTab(Main.pebbletab);
		this.setUnlocalizedName(name);
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
		
	}
	
	@Override
	public String getSpecialName(ItemStack stack)
	{
		return null;
	}
}
