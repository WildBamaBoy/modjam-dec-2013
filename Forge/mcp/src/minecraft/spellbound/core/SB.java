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
	}
}
