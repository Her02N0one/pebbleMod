package aydenmitchell.pebblemod.tabs;

import aydenmitchell.pebblemod.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class PebbleTab extends CreativeTabs
{
	
	public PebbleTab(String label)
	{ 
		super("pebbletab");
//		this.setBackgroundImageName("pebblebkgrnd.png");
	}

	@Override
	public ItemStack getTabIconItem() { return new ItemStack(ModItems.PEBBLE);}
	
 
}
