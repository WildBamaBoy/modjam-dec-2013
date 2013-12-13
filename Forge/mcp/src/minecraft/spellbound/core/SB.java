/**********************************************
 * SB.java
 * Copyright (c) 2013 MCA Dev Team.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.core;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import spellbound.blocks.BlockMushroomBlueGrey;
import spellbound.blocks.BlockMushroomOrange;
import spellbound.blocks.BlockMushroomPinkOrange;
import spellbound.blocks.BlockMushroomRedOrange;
import spellbound.blocks.BlockMushroomWhite;
import spellbound.external.PropertiesManager;
import spellbound.gen.WorldGenMushrooms;
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
	
	public Item itemTabletFireLvl1;
	public Item itemTabletColdLvl1;
	public Item itemTabletLightningLvl1;
	
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
				return new ItemStack(Item.appleRed, 1, 0);
			}
		};
		LanguageRegistry.instance().addStringLocalization("tabSpellbound", "Spellbound");
		
		
		//Declare items
		
		
		//Declare blocks
		blockPrimaryMushroomRedOrange = new BlockMushroomRedOrange(propertiesManager.propertiesList.itemID_MushroomRedOrange);
		blockPrimaryMushroomPinkOrange = new BlockMushroomPinkOrange(propertiesManager.propertiesList.itemID_MushroomPinkOrange);
		blockPrimaryMushroomBlueGrey = new BlockMushroomBlueGrey(propertiesManager.propertiesList.itemID_MushroomBlueGrey);
		blockHybridMushroomOrange = new BlockMushroomOrange(propertiesManager.propertiesList.itemID_MushroomOrange);
		blockHybridMushroomWhite = new BlockMushroomWhite(propertiesManager.propertiesList.itemID_MushroomWhite);
		
		//Declare items
		itemTabletBase = new Item(propertiesManager.propertiesList.itemID_TabletBase).setTextureName("spellbound:tabletbase");
		
		itemTabletFireBase = new Item(propertiesManager.propertiesList.itemID_TabletFire).setTextureName("spellbound:tabletfirelvl1");
		itemTabletColdBase = new Item(propertiesManager.propertiesList.itemID_TabletCold).setTextureName("spellbound:tabletcoldlvl1");
		itemTabletLightningBase = new Item(propertiesManager.propertiesList.itemID_TabletLightning).setTextureName("spellbound:tabletlightninglvl1");;
		
		itemTabletFireLvl1 = new Item(propertiesManager.propertiesList.itemID_TabletFire).setTextureName("spellbound:tabletfirelvl1");
		itemTabletColdLvl1 = new Item(propertiesManager.propertiesList.itemID_TabletCold).setTextureName("spellbound:tabletcoldlvl1");
		itemTabletLightningLvl1 = new Item(propertiesManager.propertiesList.itemID_TabletLightning).setTextureName("spellbound:tabletlightninglvl1");
		
		//Do recipes 
		
		//Register blocks
		//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>YOU USED THE SAME CLASS FOR ITEMBLOCK!!!1
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
		LanguageRegistry.addName(itemTabletFireLvl1, "Fire Tablet");
		LanguageRegistry.addName(itemTabletColdLvl1, "Cold Tablet");
		LanguageRegistry.addName(itemTabletLightningLvl1, "Lightning Tablet");
		
		GameRegistry.addRecipe(new ItemStack(itemTabletBase), 
				" C ", "C C", " C ", 'C', Item.clay);
		GameRegistry.addRecipe(new ItemStack(itemTabletFireLvl1), 
				" R ", "RTR", " R ", 'R', Item.redstone, 'T', itemTabletBase);
		GameRegistry.addRecipe(new ItemStack(itemTabletColdLvl1), 
				" S ", "STS", " S ", 'S', Item.snowball, 'T', itemTabletBase);
		GameRegistry.addRecipe(new ItemStack(itemTabletLightningLvl1), 
				" L ", "LTL", " L ", 'L', new ItemStack(Item.dyePowder, 1, 4), 'T', itemTabletBase);
	}
}
