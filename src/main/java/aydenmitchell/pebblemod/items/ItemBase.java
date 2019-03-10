package aydenmitchell.pebblemod.items;

import aydenmitchell.pebblemod.Main;
import aydenmitchell.pebblemod.init.ModItems;
import aydenmitchell.pebblemod.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {

	public ItemBase(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.pebbletab);
		
		ModItems.ITEMS.add(this);
		
	}
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
		
	}

}
