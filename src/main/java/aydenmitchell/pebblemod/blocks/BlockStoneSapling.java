package aydenmitchell.pebblemod.blocks;

import java.util.Random;

import aydenmitchell.pebblemod.world.WorldGenTreesRocky;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;

public class BlockStoneSapling extends BlockBush implements IGrowable
{
    public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);
    protected static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);

    public BlockStoneSapling(String string, Material material)
    {
    	super(material);
    	
        setCreativeTab(CreativeTabs.DECORATIONS);
        setHardness(0.0F);
        setSoundType(SoundType.PLANT);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return SAPLING_AABB;
    }

    /* (non-Javadoc)
     * @see net.minecraft.block.BlockBush#updateTick(net.minecraft.world.World, net.minecraft.util.math.BlockPos, net.minecraft.block.state.IBlockState, java.util.Random)
     */
    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!worldIn.isRemote)
        {
            super.updateTick(worldIn, pos, state, rand);

            if (worldIn.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(7) == 0)
            {
                grow(worldIn, rand, pos, state);
            }
        }
    }

    /**
     * Generate tree.
     *
     * @param worldIn the world in
     * @param pos the pos
     * @param state the state
     * @param rand the rand
     */
    public void generateTree(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!TerrainGen.saplingGrowTree(worldIn, rand, pos)) return;
        WorldGenerator worldgenerator = new WorldGenTreesRocky(true);

        worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 4);

        worldgenerator.generate(worldIn, rand, pos);
    }

    /**
     * Whether this IGrowable can grow.
     *
     * @param worldIn the world in
     * @param pos the pos
     * @param state the state
     * @param isClient the is client
     * @return true, if successful
     */
    @Override
    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient)
    {
        return true;
    }

    /* (non-Javadoc)
     * @see net.minecraft.block.IGrowable#canUseBonemeal(net.minecraft.world.World, java.util.Random, net.minecraft.util.math.BlockPos, net.minecraft.block.state.IBlockState)
     */
    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state)
    {
        return worldIn.rand.nextFloat() < 0.45D;
    }

    /* (non-Javadoc)
     * @see net.minecraft.block.IGrowable#grow(net.minecraft.world.World, java.util.Random, net.minecraft.util.math.BlockPos, net.minecraft.block.state.IBlockState)
     */
    @Override
    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state)
    {
        if (state.getValue(STAGE).intValue() == 0)
        {
            worldIn.setBlockState(pos, state.cycleProperty(STAGE), 4);
        }
        else
        {
            generateTree(worldIn, pos, state, rand);
        }
    }

    /**
     * Convert the given metadata into a BlockState for this Block.
     *
     * @param meta the meta
     * @return the state from meta
     */
    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return getDefaultState().withProperty(STAGE, Integer.valueOf((meta & 8) >> 3));
    }

    /**
     * Convert the BlockState into the correct metadata value.
     *
     * @param state the state
     * @return the meta from state
     */
    @Override
    public int getMetaFromState(IBlockState state)
    {
        int i = 0;
        i = i | state.getValue(STAGE).intValue() << 3;
        return i;
    }

    /* (non-Javadoc)
     * @see net.minecraft.block.Block#createBlockState()
     */
    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {STAGE});
    }
}