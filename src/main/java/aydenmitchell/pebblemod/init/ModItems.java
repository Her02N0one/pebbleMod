package aydenmitchell.pebblemod.init;

import java.util.ArrayList;
import java.util.List;

import aydenmitchell.pebblemod.items.ItemBase;
import net.minecraft.item.Item;

public class ModItems {
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static final Item PEBBLE = new ItemBase("pebble");
	public static final Item HANDFUL_PEBBLE = new ItemBase("handful_pebble");
}
