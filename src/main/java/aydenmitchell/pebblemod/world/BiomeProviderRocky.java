package aydenmitchell.pebblemod.world;

import aydenmitchell.pebblemod.init.ModBiomes;
import net.minecraft.world.biome.BiomeProviderSingle;

public class BiomeProviderRocky extends BiomeProviderSingle
{
    
    /**
     * Instantiates a new biome provider cloud.
     */
    public BiomeProviderRocky()
    {
        super(ModBiomes.rocky);
        
        // DEBUG
        System.out.println("Constructing BiomeProviderRocky");
    }
}