package aydenmitchell.pebblemod.proxy;

import aydenmitchell.pebblemod.blocks.BlockPebbleLeaves;
import net.minecraft.item.Item;

public class CommonProxy {
	
	public void registerItemRenderer(Item item, int meta, String id){}

	public void preInit()
	{
	
	}
	
	public void init()
	{
	
	}
	
	public void postInit()
	{
		
	}
	
    public void setGraphicsLevel(BlockPebbleLeaves parBlock, boolean parFancyEnabled)
    {
        parBlock.setGraphicsLevel(parFancyEnabled);
    }

}
