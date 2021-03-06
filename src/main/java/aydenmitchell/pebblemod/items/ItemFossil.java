package aydenmitchell.pebblemod.items;

import aydenmitchell.pebblemod.Main;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemFossil extends Item
{
	
	private String[] subNames = { "Fossil1", "Fossil2" };
	
	public ItemFossil()
	{
		super();
		this.maxStackSize = 1;
		this.setHasSubtypes(true);
		this.setCreativeTab(Main.pebbletab);
		this.setUnlocalizedName("fossil");
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemstack)
	{
		return getUnlocalizedName() + "." + subNames[itemstack.getItemDamage()];
	}
	
	@Override
	public int getMetadata(int damageValue)
	{
		return damageValue;
	}
	
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items)
	{
		if(this.isInCreativeTab(tab))
			for(int i = 0; i < subNames.length; i++)
				items.add(new ItemStack(this, 1, i));
	}
}
