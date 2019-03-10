
package aydenmitchell.pebblemod.world;

import java.util.Random;

import aydenmitchell.pebblemod.init.ModBlocks;

import net.minecraft.block.BlockBush;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

// TODO: Auto-generated Javadoc
public class WorldGenFlowersRocky extends WorldGenerator
{
    
    /**
     * Instantiates a new world gen flowers cloud.
     */
    public WorldGenFlowersRocky()
    {
    }

    /* (non-Javadoc)
     * @see net.minecraft.world.gen.feature.WorldGenerator#generate(net.minecraft.world.World, java.util.Random, net.minecraft.util.math.BlockPos)
     */
    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        BlockBush flower = (BlockBush) ModBlocks.STONE_FLOWER;
        
        for (int i = 0; i < 64; ++i)
        {
            BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

            if (worldIn.isAirBlock(blockpos) && (!worldIn.provider.isNether() || blockpos.getY() < 255) && flower.canBlockStay(worldIn, blockpos, flower.getDefaultState()))
            {
                worldIn.setBlockState(blockpos, flower.getDefaultState(), 2);
            }
        }

        return true;
    }
}