package aydenmitchell.pebblemod.init;

import java.util.ArrayList;
import java.util.List;


import aydenmitchell.pebblemod.items.ArmorBase;
import aydenmitchell.pebblemod.items.ItemBase;
import aydenmitchell.pebblemod.items.FoodBase;
import aydenmitchell.pebblemod.items.ItemPebble;
import aydenmitchell.pebblemod.items.tools.ToolPickaxe;
import aydenmitchell.pebblemod.util.Reference;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems {
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	//Material
	public static final ArmorMaterial ARMOR_PEBBLE = EnumHelper.addArmorMaterial("armor_pebble", Reference.MOD_ID + ":pebble", 6, new int[]{1, 2, 3, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0F);
	public static final ToolMaterial MATERIAL_PEBBLE = EnumHelper.addToolMaterial("material_pebble", 1, 131, 4.0F, 1.0F, 5);
	
	//Items
	public static final Item PEBBLE = new ItemPebble("pebble");
	public static final Item HANDFUL_PEBBLE = new ItemBase("handful_pebble");
	public static final Item FOSSIL = new ItemBase("fossil");
	public static final Item SPRITE_CRANBERRY = new FoodBase("sprite_cranberry", 7, 0.1f, false);
	
	
	//Armor
	public static final Item HELMET_PEBBLE = new ArmorBase("helmet_pebble", ARMOR_PEBBLE, 1, EntityEquipmentSlot.HEAD);
	
	//Weapons
	 
	//Tools
	public static final ItemPickaxe PICK_SWORD = new ToolPickaxe("pick_sword", MATERIAL_PEBBLE);
}
