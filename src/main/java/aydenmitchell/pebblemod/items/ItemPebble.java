package aydenmitchell.pebblemod.items;

import aydenmitchell.pebblemod.Main;
import aydenmitchell.pebblemod.entity.projectile.EntityPebble;
import aydenmitchell.pebblemod.init.ModItems;
import aydenmitchell.pebblemod.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemPebble extends Item implements IHasModel{

	public ItemPebble(String name) {
		
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(Main.pebbletab);
		
		ModItems.ITEMS.add(this);
		
	}

	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
	{
	    ItemStack itemstack = playerIn.getHeldItem(handIn);
	
	    if (!playerIn.capabilities.isCreativeMode)
	    {
	        itemstack.shrink(1);
	    }
	
	    worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
	
	    if (!worldIn.isRemote)
	    {
	        EntityPebble entitypebble = new EntityPebble(worldIn, playerIn);
	        entitypebble.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
	        worldIn.spawnEntity(entitypebble);
	    }
	
	    playerIn.addStat(StatList.getObjectUseStats(this));
	    return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean isFull3D()
	{
		return true;
	}
}
