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
import spellbound.effects.EffectFireLvl1;
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
	//-------------- PRIMARY
	public Block blockPrimaryMushroomRedOrange;
	public Block blockPrimaryMushroomPinkOrange;
	public Block blockPrimaryMushroomBlueGrey;
	
	//Hybrid
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
		
		itemTabletFireLvl1 = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletFireLvl1, "tabletfirelvl1", new EffectFireLvl1());
//		itemTabletColdLvl1 = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletColdLvl1, "tabletcoldlvl1", new EffectColdLvl1());
//		itemTabletLightningLvl1 = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletLightningLvl1, "tabletlightninglvl1", new EffectLightningLvl1());
//		
		
		//Register blocks
		//TODO Move?
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
		
		LanguageRegistry.addName(itemTabletBase, "Blank Tablet");
		
		LanguageRegistry.addName(itemTabletFireBase, "Fire Tablet");
		LanguageRegistry.addName(itemTabletColdBase, "Cold Tablet");
		LanguageRegistry.addName(itemTabletLightningBase, "Lightning Tablet");
		
		LanguageRegistry.addName(itemTabletFireLvl1, "Flaming Hands");
//		LanguageRegistry.addName(itemTabletColdLvl1, "Icy Grip");
//		LanguageRegistry.addName(itemTabletLightningLvl1, "Tazer");
		
		GameRegistry.addRecipe(new ItemStack(itemTabletBase), 
				" C ", "C C", " C ", 'C', Item.clay);
		
		GameRegistry.addRecipe(new ItemStack(itemTabletFireBase), 
				" O ", "OTO", " O ", 'O', blockHybridMushroomOrange, 'T', itemTabletBase);
		GameRegistry.addRecipe(new ItemStack(itemTabletColdBase), 
				" S ", "STS", " S ", 'S', Item.snowball, 'T', itemTabletBase);
		GameRegistry.addRecipe(new ItemStack(itemTabletLightningBase), 
				" L ", "LTL", " L ", 'L', new ItemStack(Item.dyePowder, 1, 4), 'T', itemTabletBase);
		
		GameRegistry.addRecipe(new ItemStack(itemTabletFireLvl1), 
				" R ", "RTR", " R ", 'R', Item.redstone, 'T', itemTabletFireBase);
//		GameRegistry.addRecipe(new ItemStack(itemTabletColdLvl1), 
//				" S ", "STS", " S ", 'S', Item.snowball, 'T', itemTabletColdBase);
//		GameRegistry.addRecipe(new ItemStack(itemTabletLightningLvl1), 
//				" L ", "LTL", " L ", 'L', new ItemStack(Item.dyePowder, 1, 4), 'T', itemTabletLightningBase);
	}
}
