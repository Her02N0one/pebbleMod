package aydenmitchell.pebblemod;

import aydenmitchell.pebblemod.init.ModRecipes;
import aydenmitchell.pebblemod.proxy.CommonProxy;
import aydenmitchell.pebblemod.tabs.PebbleTab;
import aydenmitchell.pebblemod.util.Reference;
import aydenmitchell.pebblemod.world.ModWorldGen;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main
{
	public static final CreativeTabs pebbletab = new PebbleTab("pebbletab");
	
	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler 
	public static void PreInit(FMLPreInitializationEvent event)
	{
		GameRegistry.registerWorldGenerator(new ModWorldGen(), 3);

	}
	@EventHandler 
	public static void Init(FMLInitializationEvent event){
	
		ModRecipes.init();
	}
	@EventHandler 
	public static void PostInit(FMLPostInitializationEvent event)
	{

	}
}
