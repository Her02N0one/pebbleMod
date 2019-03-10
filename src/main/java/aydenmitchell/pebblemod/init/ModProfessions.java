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
package aydenmitchell.pebblemod.init;

import java.util.Random;

import aydenmitchell.pebblemod.util.Reference;

import net.minecraft.entity.IMerchant;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityVillager.ITradeList;
import net.minecraft.entity.passive.EntityVillager.PriceInfo;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerCareer;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerProfession;
import net.minecraftforge.registries.IForgeRegistry;

// TODO: Auto-generated Javadoc
@ObjectHolder(Reference.MOD_ID)
public class ModProfessions
{
    // instantiate VillagerProfessions
    public final static VillagerProfession mysterious_stranger = null;
    
    // declare VillagerCareers
    public static VillagerCareer cloud_enchanter;

    @Mod.EventBusSubscriber(modid = Reference.MOD_ID)
    public static class RegistrationHandler
    {
        /**
         * Register this mod's {@link VillagerProfession}s.
         *
         * @param event
         *            The event
         */
        @SubscribeEvent
        public static void onEvent(final RegistryEvent.Register<VillagerProfession> event)
        {
            final IForgeRegistry<VillagerProfession> registry = event.getRegistry();

            // DEBUG
            System.out.println("Registering villager professions");
            
            registry.register(new VillagerProfession(
            		Reference.MOD_ID+":mysterious_stranger", 
            		Reference.MOD_ID+":textures/entities/mysterious_stranger.png", 
            		Reference.MOD_ID+":textures/entities/mysterious_stranger.png"
                    )
             );
        }
    }
    
    /**
     * Associate careers and trades.
     */
    public static void associateCareersAndTrades()
    {
        // DEBUG
        System.out.println("Associating careers and trades to villager professions");
        
        cloud_enchanter = (new VillagerCareer(mysterious_stranger, "cloud_enchanter"))
                .addTrade(1, new TradeEmeraldsForEnchantedBoots());
    }
    
    public static class TradeEmeraldsForEnchantedBoots implements ITradeList
    {
        /** The  item stack to buy */
        public ItemStack stack;
        /** The price info determining the amount of emeralds to trade in for the enchanted item */
        public EntityVillager.PriceInfo priceInfo;

        /**
         * Instantiates a new trade emeralds for enchanted boots.
         */
        public TradeEmeraldsForEnchantedBoots()
        {
            stack = new ItemStack(Items.GOLDEN_BOOTS);
            stack.addEnchantment(ModEnchantments.safe_falling, 2);
            priceInfo = new PriceInfo(17, 64);
        }

        /* (non-Javadoc)
         * @see net.minecraft.entity.passive.EntityVillager.ITradeList#addMerchantRecipe(net.minecraft.entity.IMerchant, net.minecraft.village.MerchantRecipeList, java.util.Random)
         */
        @Override
        public void addMerchantRecipe(IMerchant merchant, MerchantRecipeList recipeList, Random random)
        {
            int actualPrice = 1;

            if (priceInfo != null)
            {
                actualPrice = priceInfo.getPrice(random);
            }

            ItemStack stackToPay = new ItemStack(Items.EMERALD, actualPrice, 0);
            recipeList.add(new MerchantRecipe(stackToPay, stack));
            
            // DEBUG
            System.out.println("Merchant recipe list = "+recipeList.getRecipiesAsTags());
        }
    }    
}
