package aydenmitchell.pebblemod.init;

import aydenmitchell.pebblemod.util.Reference;
//import aydenmitchell.pebblemod.world.BiomeRocky;
import aydenmitchell.pebblemod.world.ModWorldGen;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.terraingen.WorldTypeEvent.InitBiomeGens;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

//public class ModBiomes{
//	
//	public static final Biome ROCKY = new BiomeRocky();
//	
//	public static void registerBiomes()
//	{
//		//ModBiomes(ROCKY, "rocky", BiomeType.WARM, Type.HILLS);
//	}
//
//	private static Biome iniBiome(Biome biome, String name, BiomeType biomeType, Type... types) {
//		
//		biome.setRegistryName(name);
//		ForgeRegistries.BIOMES.register(biome);
//		BiomeDictionary.addTypes(biome, types);
//		BiomeManager.addBiome(biomeType, new BiomeEntry(biome, 10));
//		BiomeManager.addSpawnBiome(biome);
//		return biome;
//	}
//}