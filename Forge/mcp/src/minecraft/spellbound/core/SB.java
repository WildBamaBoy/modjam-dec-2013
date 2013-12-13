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
import spellbound.blocks.BlockMushroomBlack;
import spellbound.blocks.BlockMushroomBlueGrey;
import spellbound.blocks.BlockMushroomGold;
import spellbound.blocks.BlockMushroomGrey;
import spellbound.blocks.BlockMushroomGreyOrange;
import spellbound.blocks.BlockMushroomLightBlue;
import spellbound.blocks.BlockMushroomOrange;
import spellbound.blocks.BlockMushroomPinkOrange;
import spellbound.blocks.BlockMushroomRainbow;
import spellbound.blocks.BlockMushroomRedOrange;
import spellbound.blocks.BlockMushroomWhite;
import spellbound.blocks.BlockMushroomYellow;
import spellbound.effects.EffectAdvanceTime;
import spellbound.effects.EffectAllSeeingEye;
import spellbound.effects.EffectBlink;
import spellbound.effects.EffectBreach;
import spellbound.effects.EffectChangeWeather;
import spellbound.effects.EffectChaos;
import spellbound.effects.EffectColdLvl1;
import spellbound.effects.EffectColdLvl2;
import spellbound.effects.EffectColdLvl3;
import spellbound.effects.EffectColdShield;
import spellbound.effects.EffectColorSpray;
import spellbound.effects.EffectDimensionDoor;
import spellbound.effects.EffectFireLvl1;
import spellbound.effects.EffectFireLvl2;
import spellbound.effects.EffectFireLvl3;
import spellbound.effects.EffectFireShield;
import spellbound.effects.EffectFishForm;
import spellbound.effects.EffectFlight;
import spellbound.effects.EffectGrease;
import spellbound.effects.EffectGreaterScrying;
import spellbound.effects.EffectHaste;
import spellbound.effects.EffectLightningLvl1;
import spellbound.effects.EffectLightningLvl2;
import spellbound.effects.EffectLightningLvl3;
import spellbound.effects.EffectLightningShield;
import spellbound.effects.EffectMinorScrying;
import spellbound.effects.EffectMiscastMagic;
import spellbound.effects.EffectPush;
import spellbound.effects.EffectShieldOfInvulnerability;
import spellbound.effects.EffectSummonLvl1;
import spellbound.effects.EffectSummonLvl2;
import spellbound.effects.EffectSummonLvl3;
import spellbound.effects.EffectSurgeShield;
import spellbound.effects.EffectTransport;
import spellbound.effects.EffectUltimateDisintegrate;
import spellbound.effects.EffectUltimateElementalFury;
import spellbound.effects.EffectUltimateWailOfTheBanshee;
import spellbound.effects.EffectWallOfBedrock;
import spellbound.effects.EffectWallOfObsidian;
import spellbound.effects.EffectWallOfStone;
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
	
	//Primary Mushrooms
	public Block blockPrimaryMushroomRedOrange;
	public Block blockPrimaryMushroomPinkOrange;
	public Block blockPrimaryMushroomBlueGrey;
	
	//Hybrid Mushrooms
	public Block blockHybridMushroomOrange;
	public Block blockHybridMushroomWhite;
	public Block blockHybridMushroomGreyOrange; //Orange + BlueGrey
	public Block blockHybridMushroomLightBlue; //GreyOrange + BlueGrey //COLD!
	public Block blockHybridMushroomGrey; //GreyOrange + BlueGrey >>>Also
	public Block blockHybridMushroomYellow; //OrangeGrey + Grey //LIGHTNING!
	public Block blockHybridMushroomRainbow; //Red Orange + Yellow //RANDOM! //2nd LEVEL
	public Block blockHybridMushroomGold; //Rainbow + Yellow //2nd level
	public Block blockHybridMushroomBlack; //Blue Grey + Grey //2nd level
	
	//Tablets
	public Item itemTabletBase;
	
	public Item itemTabletFireBase;
	public Item itemTabletColdBase;
	public Item itemTabletLightningBase;
	public Item itemTabletForesightBase;
	
	//Offensive spells
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
	
	//Defensive spells
	public ItemSpellTablet itemTabletFireShield;
	public ItemSpellTablet itemTabletIceShield;
	public ItemSpellTablet itemTabletLightningShield;
	public ItemSpellTablet itemTabletSurgeShield;
	public ItemSpellTablet itemTabletShieldOfInvulnerability;

	public ItemSpellTablet itemTabletWallOfStone;
	public ItemSpellTablet itemTabletWallOfObsidian;
	public ItemSpellTablet itemTabletWallOfBedrock;

	public ItemSpellTablet itemTabletPush;
	public ItemSpellTablet itemTabletColorSpray;
	public ItemSpellTablet itemTabletGrease;
	public ItemSpellTablet itemTabletBlink;

	public ItemSpellTablet itemTabletSummonMagicalArmor; //TODO Omit?
	
	//Helpful spells
	public ItemSpellTablet itemTabletTransport;
	public ItemSpellTablet itemTabletDimensionDoor;
	
	public ItemSpellTablet itemTabletHaste;
	public ItemSpellTablet itemTabletAdvanceTime;
	public ItemSpellTablet itemTabletChangeWeather;
	public ItemSpellTablet itemTabletFlight;
	public ItemSpellTablet itemTabletFishForm;
	
	//>>>>>>>>>>>>>>> Foresight <<<<<<<<<<<<<<<<<<
//	public ItemSpellTablet itemTablet;
//	public ItemSpellTablet itemTabletAdvanceTime;
//	public ItemSpellTablet itemTabletChangeWeather;
//	public ItemSpellTablet itemTabletFlight;
	
	public ItemSpellTablet itemTabletMinorScrying;
	public ItemSpellTablet itemTabletGreaterScrying;
	public ItemSpellTablet itemTabletAllSeeingeye;
	
	//Disruptive Magic
	public ItemSpellTablet itemTabletBreach;
	public ItemSpellTablet itemTabletMiscastMagic;
	public ItemSpellTablet itemTabletChaos;
	
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
		blockPrimaryMushroomRedOrange = new BlockMushroomRedOrange(propertiesManager.propertiesList.blockID_MushroomRedOrange);
		blockPrimaryMushroomPinkOrange = new BlockMushroomPinkOrange(propertiesManager.propertiesList.blockID_MushroomPinkOrange);
		blockPrimaryMushroomBlueGrey = new BlockMushroomBlueGrey(propertiesManager.propertiesList.blockID_MushroomBlueGrey);
		blockHybridMushroomOrange = new BlockMushroomOrange(propertiesManager.propertiesList.blockID_MushroomOrange);
		blockHybridMushroomWhite = new BlockMushroomWhite(propertiesManager.propertiesList.blockID_MushroomWhite);

		blockHybridMushroomGreyOrange = new BlockMushroomGreyOrange(propertiesManager.propertiesList.blockID_MushroomGreyOrange); //Orange + BlueGrey
		blockHybridMushroomLightBlue = new BlockMushroomLightBlue(propertiesManager.propertiesList.blockID_MushroomLightBlue); //GreyOrange + BlueGrey //COLD!
		blockHybridMushroomGrey = new BlockMushroomGrey(propertiesManager.propertiesList.blockID_MushroomGrey); //GreyOrange + BlueGrey >>>Also
		blockHybridMushroomYellow = new BlockMushroomYellow(propertiesManager.propertiesList.blockID_MushroomYellow); //OrangeGrey + Grey //LIGHTNING!
		blockHybridMushroomRainbow = new BlockMushroomRainbow(propertiesManager.propertiesList.blockID_MushroomRainbow); //Red Orange + Yellow //RANDOM! //2nd LEVEL
		blockHybridMushroomGold = new BlockMushroomGold(propertiesManager.propertiesList.blockID_MushroomGold); //Rainbow + Yellow //2nd level
		blockHybridMushroomBlack = new BlockMushroomBlack(propertiesManager.propertiesList.blockID_MushroomBlack); //Blue Grey + Grey //2nd level
		
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

		itemTabletFireShield = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletFireShield, "tabletfireshield", new EffectFireShield(), 1);
		itemTabletIceShield = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletIceShield, "tableticeshield", new EffectColdShield(), 1);
		itemTabletLightningShield = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletLightningShield, "tabletlightningshield", new EffectLightningShield(), 1);
		itemTabletSurgeShield = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletSurgeShield, "tabletsurgeshield", new EffectSurgeShield(), 1);
		itemTabletShieldOfInvulnerability = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletShieldOfInvulnerability, "tabletshieldofinvulnerability", new EffectShieldOfInvulnerability(), 4);

		itemTabletWallOfStone = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletWallOfStone, "tabletwallofstone", new EffectWallOfStone(), 1);
		itemTabletWallOfObsidian = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletWallOfObsidian, "tabletwallofobsidian", new EffectWallOfObsidian(), 2);
		itemTabletWallOfBedrock = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletWallOfBedrock, "tabletwallofbedrock", new EffectWallOfBedrock(), 3);

		itemTabletPush = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletPush, "tabletpush", new EffectPush(), 1);
		itemTabletColorSpray = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletColorSpray, "tabletcolorspray", new EffectColorSpray(), 1);
		itemTabletGrease = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletGrease, "tabletgrease", new EffectGrease(), 1);
		itemTabletBlink = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletBlink, "tabletblink", new EffectBlink(), 1);
		
		itemTabletTransport = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletTransport, "tablettransport", new EffectTransport(), 1);
		itemTabletDimensionDoor = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletDimensionDoor, "tabletdimensiondoor", new EffectDimensionDoor(), 2);
		
		itemTabletHaste = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletHaste, "tablethaste", new EffectHaste(), 1);
		itemTabletAdvanceTime = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletAdvanceTime, "tabletadvancetime", new EffectAdvanceTime(), 1);
		itemTabletChangeWeather = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletChangeWeather, "tabletchangeweather", new EffectChangeWeather(), 1);
		itemTabletFlight = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletFlight, "tabletflight", new EffectFlight(), 1);
		itemTabletFishForm = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletFishForm, "tabletfishform", new EffectFishForm(), 1);
		
		//Foresight
		
		itemTabletMinorScrying = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletMinorScrying, "tabletminorscrying", new EffectMinorScrying(), 1);
		itemTabletGreaterScrying = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletGreaterScrying, "tabletgreaterscrying", new EffectGreaterScrying(), 2);
		itemTabletAllSeeingeye = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletAllSeeingEye, "tabletallseeingeye", new EffectAllSeeingEye(), 3);
		
		//Disruptive Magic
		itemTabletBreach = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletBreach, "tabletbreach", new EffectBreach(), 1);
		itemTabletMiscastMagic = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletMiscastMagic, "tabletmiscastmagic", new EffectMiscastMagic(), 2);
		itemTabletChaos = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletChaos, "tabletchaos", new EffectChaos(), 3);
		
		//Register blocks
		//TODO Move to abstract block?
		GameRegistry.registerBlock(blockPrimaryMushroomRedOrange, ItemBlockMushroomRedOrange.class, "RedOrangePrimary");
		GameRegistry.registerBlock(blockPrimaryMushroomPinkOrange, ItemBlockMushroomRedOrange.class, "PinkOrangePrimary");
		GameRegistry.registerBlock(blockPrimaryMushroomBlueGrey, ItemBlockMushroomRedOrange.class, "BlueGreyPrimary");
		GameRegistry.registerBlock(blockHybridMushroomOrange, ItemBlockMushroomRedOrange.class, "OrangeHybrid");
		GameRegistry.registerBlock(blockHybridMushroomWhite, ItemBlockMushroomRedOrange.class, "WhiteHybrid");
		GameRegistry.registerBlock(blockHybridMushroomLightBlue, ItemBlockMushroomRedOrange.class, "LightBlueHybrid");
		GameRegistry.registerBlock(blockHybridMushroomGrey, ItemBlockMushroomRedOrange.class, "GreyHybrid");
		GameRegistry.registerBlock(blockHybridMushroomYellow, ItemBlockMushroomRedOrange.class, "YellowHybrid");
		GameRegistry.registerBlock(blockHybridMushroomRainbow, ItemBlockMushroomRedOrange.class, "RainbowHybrid");
		GameRegistry.registerBlock(blockHybridMushroomGold, ItemBlockMushroomRedOrange.class, "GoldHybrid");
		GameRegistry.registerBlock(blockHybridMushroomBlack, ItemBlockMushroomRedOrange.class, "BlackHybrid");
		
		GameRegistry.registerWorldGenerator(new WorldGenMushrooms());
		
		//Add localizations
		//TODO Move to abstractmushroom
		LanguageRegistry.addName(blockPrimaryMushroomRedOrange, "Red Orange Mushroom");
		LanguageRegistry.addName(blockPrimaryMushroomPinkOrange, "Pink Orange Mushroom");
		LanguageRegistry.addName(blockPrimaryMushroomBlueGrey, "Blue Grey Mushroom");
		LanguageRegistry.addName(blockHybridMushroomOrange, "Orange Mushroom");
		LanguageRegistry.addName(blockHybridMushroomWhite, "White Mushroom");
		LanguageRegistry.addName(blockHybridMushroomLightBlue, "Light Blue Mushroom");
		LanguageRegistry.addName(blockHybridMushroomGrey, "Grey Mushroom");
		LanguageRegistry.addName(blockHybridMushroomYellow, "Yellow Mushroom");
		LanguageRegistry.addName(blockHybridMushroomRainbow, "Rainbow Mushroom");
		LanguageRegistry.addName(blockHybridMushroomGold, "Gold Mushroom");
		LanguageRegistry.addName(blockHybridMushroomBlack, "Black Mushroom");
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
