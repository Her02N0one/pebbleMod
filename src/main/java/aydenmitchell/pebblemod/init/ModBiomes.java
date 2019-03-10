package aydenmitchell.pebblemod.init;

import aydenmitchell.pebblemod.util.Reference;
import aydenmitchell.pebblemod.world.BiomeRocky;
import aydenmitchell.pebblemod.world.ModWorldGen;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

@ObjectHolder(Reference.MOD_ID)
public class ModBiomes
{
    // instantiate Biomes
    public final static BiomeRocky rocky = null;

    @Mod.EventBusSubscriber(modid = Reference.MOD_ID)
    public static class RegistrationHandler
    {
        /**
         * Register this mod's {@link Biome}s.
         *
         * @param event The event
         */
        @SubscribeEvent
        public static void onEvent(final RegistryEvent.Register<Biome> event)
        {
            final IForgeRegistry<Biome> registry = event.getRegistry();

            System.out.println("Registering biomes");
            
            registry.register(new BiomeRocky().setRegistryName(Reference.MOD_ID, ModWorldGen.ROCKY_NAME));
        }
    }
    
    /**
     * This method should be called during the "init" FML lifecycle 
     * because it must happen after object handler injection.
     */
    public static void initBiomeManagerAndDictionary()
    {
        BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(rocky, 10));
        BiomeManager.addSpawnBiome(rocky);
        BiomeManager.addStrongholdBiome(rocky);
        BiomeManager.addVillageBiome(rocky, true);
        BiomeDictionary.addTypes(rocky, 
                BiomeDictionary.Type.COLD,
                BiomeDictionary.Type.DRY,
                BiomeDictionary.Type.MAGICAL
                );
    }
}
