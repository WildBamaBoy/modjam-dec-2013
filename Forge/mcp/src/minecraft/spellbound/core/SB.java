/**********************************************
 * SB.java
 * Copyright (c) 2013 MCA Dev Team.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.core;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import spellbound.blocks.BlockMushroomBlueGrey;
import spellbound.blocks.BlockMushroomOrange;
import spellbound.blocks.BlockMushroomPinkOrange;
import spellbound.blocks.BlockMushroomRedOrange;
import spellbound.blocks.BlockMushroomWhite;
import spellbound.effects.EffectColdLvl1;
import spellbound.effects.EffectColdLvl2;
import spellbound.effects.EffectColdLvl3;
import spellbound.effects.EffectFireLvl1;
import spellbound.effects.EffectFireLvl2;
import spellbound.effects.EffectFireLvl3;
import spellbound.effects.EffectLightningLvl1;
import spellbound.effects.EffectLightningLvl2;
import spellbound.effects.EffectLightningLvl3;
import spellbound.effects.EffectSummonLvl1;
import spellbound.effects.EffectSummonLvl2;
import spellbound.effects.EffectSummonLvl3;
import spellbound.effects.EffectUltimateDisintegrate;
import spellbound.effects.EffectUltimateElementalFury;
import spellbound.effects.EffectUltimateWailOfTheBanshee;
import spellbound.external.PropertiesManager;
import spellbound.gen.WorldGenMushrooms;
import spellbound.item.ItemSpellTablet;
import spellbound.item.SBItem;
import spellbound.itemblocks.ItemBlockMushroomRedOrange;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="spellbound", name="Spellbound", version="1.0.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=false,
channels={"CHANNEL"}
//packethandler = Packethandler.class //*
)

public class SB 
{
	@Instance("Spellbound")
	public static SB instance;

	public static Random rand = new Random();
	public static PropertiesManager propertiesManager;
	public static String runningDirectory;
	
	public CreativeTabs spellboundTab;
	
	//Items here
	
	//Blocks here
	
	//Primary Mushrooms
	public Block blockPrimaryMushroomRedOrange;
	public Block blockPrimaryMushroomPinkOrange;
	public Block blockPrimaryMushroomBlueGrey;
	
	//Hybrid Mushrooms
	public Block blockHybridMushroomOrange;
	public Block blockHybridMushroomWhite;
	
	//Tablets
	public Item itemTabletBase;
	
	public Item itemTabletFireBase;
	public Item itemTabletColdBase;
	public Item itemTabletLightningBase;
	
	public ItemSpellTablet itemTabletFireLvl1;
	public ItemSpellTablet itemTabletColdLvl1;
	public ItemSpellTablet itemTabletLightningLvl1;
	
	public ItemSpellTablet itemTabletFireLvl2;
	public ItemSpellTablet itemTabletColdLvl2;
	public ItemSpellTablet itemTabletLightningLvl2;
	
	public ItemSpellTablet itemTabletFireLvl3;
	public ItemSpellTablet itemTabletColdLvl3;
	public ItemSpellTablet itemTabletLightningLvl3;
	
	public ItemSpellTablet itemTabletSummonLvl1;
	public ItemSpellTablet itemTabletSummonLvl2;
	public ItemSpellTablet itemTabletSummonLvl3;
	
	public ItemSpellTablet itemTabletUltWailOfTheBanshee;
	public ItemSpellTablet itemTabletUltElementalFury;
	public ItemSpellTablet itemTabletUltDisintegrate;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		instance = this;
		runningDirectory = System.getProperty("user.dir");
		propertiesManager = new PropertiesManager();
		
		//Declare tab.
		spellboundTab = new CreativeTabs("tabSpellbound")
		{
			public ItemStack getIconItemStack()
			{
				//TODO Change tab icon
				return new ItemStack(Item.appleRed, 1, 0);
			}
		};
		LanguageRegistry.instance().addStringLocalization("tabSpellbound", "Spellbound");
		
		//Declare blocks
		blockPrimaryMushroomRedOrange = new BlockMushroomRedOrange(propertiesManager.propertiesList.itemID_MushroomRedOrange);
		blockPrimaryMushroomPinkOrange = new BlockMushroomPinkOrange(propertiesManager.propertiesList.itemID_MushroomPinkOrange);
		blockPrimaryMushroomBlueGrey = new BlockMushroomBlueGrey(propertiesManager.propertiesList.itemID_MushroomBlueGrey);
		blockHybridMushroomOrange = new BlockMushroomOrange(propertiesManager.propertiesList.itemID_MushroomOrange);
		blockHybridMushroomWhite = new BlockMushroomWhite(propertiesManager.propertiesList.itemID_MushroomWhite);
		
		//Declare items
		itemTabletBase = new SBItem(propertiesManager.propertiesList.itemID_TabletBase, "tabletbase", "Blank Tablet");
		
		itemTabletFireBase = new SBItem(propertiesManager.propertiesList.itemID_TabletFireBase, "tabletfirebase", "Fire Tablet");
		itemTabletColdBase = new SBItem(propertiesManager.propertiesList.itemID_TabletColdBase, "tabletcoldbase", "Cold Tablet");
		itemTabletLightningBase = new SBItem(propertiesManager.propertiesList.itemID_TabletLightningBase, "tabletlightningbase", "Lightning Tablet");
		
		itemTabletFireLvl1 = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletFireLvl1, "tabletfirelvl1", new EffectFireLvl1(), 1);
		itemTabletColdLvl1 = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletColdLvl1, "tabletcoldlvl1", new EffectColdLvl1(), 1);
		itemTabletLightningLvl1 = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletLightningLvl1, "tabletlightninglvl1", new EffectLightningLvl1(), 1);
		
		itemTabletFireLvl2 = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletFireLvl2, "tabletfirelvl2", new EffectFireLvl2(), 2);
		itemTabletColdLvl2 = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletColdLvl2, "tabletcoldlvl2", new EffectColdLvl2(), 2);
		itemTabletLightningLvl2 = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletLightningLvl2, "tabletlightninglvl2", new EffectLightningLvl2(), 2);
		
		itemTabletFireLvl3 = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletFireLvl3, "tabletfirelvl3", new EffectFireLvl3(), 3);
		itemTabletColdLvl3 = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletColdLvl3, "tabletcoldlvl3", new EffectColdLvl3(), 3);
		itemTabletLightningLvl3 = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletLightningLvl3, "tabletlightninglvl3", new EffectLightningLvl3(), 3);
		
		itemTabletUltWailOfTheBanshee = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletUltimateWailOfTheBanshee, "tabletwailofthebanshee", new EffectUltimateWailOfTheBanshee(), 4);
		itemTabletUltElementalFury = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletUltimateElementalFury, "tabletelementalfury", new EffectUltimateElementalFury(), 4);
		itemTabletUltDisintegrate = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletUltimateDisintegrate, "tabletdisintegrate", new EffectUltimateDisintegrate(), 4);
		
		//TODO first level
		itemTabletSummonLvl1 = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletSummonLvl1, "tabletsummonlvl1", new EffectSummonLvl1(), 1);
		itemTabletSummonLvl2 = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletSummonLvl2, "tabletsummonlvl2", new EffectSummonLvl2(), 2);
		itemTabletSummonLvl3 = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletSummonLvl3, "tabletsummonlvl3", new EffectSummonLvl3(), 3);

		//Register blocks
		//TODO Move to abstract block?
		GameRegistry.registerBlock(blockPrimaryMushroomRedOrange, ItemBlockMushroomRedOrange.class, "RedOrangePrimary");
		GameRegistry.registerBlock(blockPrimaryMushroomPinkOrange, ItemBlockMushroomRedOrange.class, "PinkOrangePrimary");
		GameRegistry.registerBlock(blockPrimaryMushroomBlueGrey, ItemBlockMushroomRedOrange.class, "BlueGreyPrimary");
		GameRegistry.registerBlock(blockHybridMushroomOrange, ItemBlockMushroomRedOrange.class, "OrangeHybrid");
		GameRegistry.registerBlock(blockHybridMushroomWhite, ItemBlockMushroomRedOrange.class, "WhiteHybrid");
		GameRegistry.registerWorldGenerator(new WorldGenMushrooms());
		
		//Add localizations
		//TODO Move to abstractmushroom
		LanguageRegistry.addName(blockPrimaryMushroomRedOrange, "Red Orange Mushroom");
		LanguageRegistry.addName(blockPrimaryMushroomPinkOrange, "Pink Orange Mushroom");
		LanguageRegistry.addName(blockPrimaryMushroomBlueGrey, "Blue Grey Mushroom");
		LanguageRegistry.addName(blockHybridMushroomOrange, "Orange Mushroom");
		LanguageRegistry.addName(blockHybridMushroomWhite, "White Mushroom");
		//TODO
		
		//Register Recipes
		GameRegistry.addRecipe(new ItemStack(itemTabletBase), 
				" C ", "C C", " C ", 'C', Item.clay);
		GameRegistry.addRecipe(new ItemStack(itemTabletFireBase), 
				" O ", "OTO", " O ", 'O', blockHybridMushroomOrange, 'T', itemTabletBase);
		GameRegistry.addRecipe(new ItemStack(itemTabletColdBase), 
				" S ", "STS", " S ", 'S', Item.snowball, 'T', itemTabletBase);
		GameRegistry.addRecipe(new ItemStack(itemTabletLightningBase), 
				" L ", "LTL", " L ", 'L', new ItemStack(Item.dyePowder, 1, 4), 'T', itemTabletBase); //>>>>>>>Lapis lazuli dmg is 4<<<<<<<<
		GameRegistry.addRecipe(new ItemStack(itemTabletFireLvl1), 
				" R ", "RTR", " R ", 'R', Item.redstone, 'T', itemTabletFireBase);
		GameRegistry.addRecipe(new ItemStack(itemTabletColdLvl1), 
				" S ", "STS", " S ", 'S', Item.snowball, 'T', itemTabletColdBase);
		GameRegistry.addRecipe(new ItemStack(itemTabletLightningLvl1), 
				" L ", "LTL", " L ", 'L', new ItemStack(Item.dyePowder, 1, 4), 'T', itemTabletLightningBase);
	}
}
