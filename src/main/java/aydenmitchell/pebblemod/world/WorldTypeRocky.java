/**
    Copyright (C) 2017 by jabelar

    This file is part of jabelar's Minecraft Forge modding examples; as such,
    you can redistribute it and/or modify it under the terms of the GNU
    General Public License as published by the Free Software Foundation,
    either version 3 of the License, or (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
    GNU General Public License for more details.

    For a copy of the GNU General Public License see <http://www.gnu.org/licenses/>.
*/
package aydenmitchell.pebblemod.world;

import java.util.Random;

import aydenmitchell.pebblemod.world.ModWorldGen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiCreateWorld;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

// TODO: Auto-generated Javadoc
public class WorldTypeRocky extends WorldType
{    
    
    /**
     * Instantiates a new world type cloud.
     */
    public WorldTypeRocky()
    {
        super(ModWorldGen.ROCKY_NAME);
        
        // DEBUG
        System.out.println("Constructing WorldTypeCloud");
    }

    /* (non-Javadoc)
     * @see net.minecraft.world.WorldType#getBiomeProvider(net.minecraft.world.World)
     */
    @Override
    public BiomeProvider getBiomeProvider(World world)
    {
        return new BiomeProviderRocky();
    }

    /* (non-Javadoc)
     * @see net.minecraft.world.WorldType#getChunkGenerator(net.minecraft.world.World, java.lang.String)
     */
    @Override
    public IChunkGenerator getChunkGenerator(World world, String generatorOptions)
    {
        return new ChunkGeneratorRocky(world);
    }

    /* (non-Javadoc)
     * @see net.minecraft.world.WorldType#getMinimumSpawnHeight(net.minecraft.world.World)
     */
    @Override
    public int getMinimumSpawnHeight(World world)
    {
        return world.getSeaLevel() + 1;
    }

    /* (non-Javadoc)
     * @see net.minecraft.world.WorldType#getHorizon(net.minecraft.world.World)
     */
    @Override
    public double getHorizon(World world)
    {
        return 63.0D;
    }

    /* (non-Javadoc)
     * @see net.minecraft.world.WorldType#voidFadeMagnitude()
     */
    @Override
    public double voidFadeMagnitude()
    {
        return 0.03125D;
    }

    /* (non-Javadoc)
     * @see net.minecraft.world.WorldType#handleSlimeSpawnReduction(java.util.Random, net.minecraft.world.World)
     */
    @Override
    public boolean handleSlimeSpawnReduction(Random random, World world)
    {
        return false;
    }

    /**
     * Called when 'Create New World' button is pressed before starting game.
     */
    @Override
    public void onGUICreateWorldPress() { }

    /**
     * Gets the spawn fuzz for players who join the world.
     * Useful for void world types.
     *
     * @param world the world
     * @param server the server
     * @return Fuzz for entity initial spawn in blocks.
     */
    @Override
    public int getSpawnFuzz(WorldServer world, net.minecraft.server.MinecraftServer server)
    {
        return Math.max(0, server.getSpawnRadius(world));
    }

    /**
     * Called when the 'Customize' button is pressed on world creation GUI.
     *
     * @param mc The Minecraft instance
     * @param guiCreateWorld the createworld GUI
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void onCustomizeButton(Minecraft mc, GuiCreateWorld guiCreateWorld)
    {
    }

    /**
     * Should world creation GUI show 'Customize' button for this world type?.
     *
     * @return if this world type has customization parameters
     */
    @Override
    public boolean isCustomizable()
    {
        return false;
    }

    /**
     * returns true if selecting this worldtype from the customize menu should display the generator.[worldtype].info
     * message
     *
     * @return true, if successful
     */
    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasInfoNotice()
    {
        return true;
    }

    /**
     * Get the height to render the clouds for this world type.
     *
     * @return The height to render clouds at
     */
    @Override
    public float getCloudHeight()
    {
        return 128.0F;
    }
}