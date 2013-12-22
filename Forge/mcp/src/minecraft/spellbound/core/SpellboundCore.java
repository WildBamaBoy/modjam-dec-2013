/**********************************************
 * SpellboundCore.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.core;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.crash.CrashReport;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import spellbound.blocks.BlockFalseBedrock;
import spellbound.blocks.BlockFalseObsidian;
import spellbound.blocks.BlockMushroomBlack;
import spellbound.blocks.BlockMushroomBlueGrey;
import spellbound.blocks.BlockMushroomGold;
import spellbound.blocks.BlockMushroomGrey;
import spellbound.blocks.BlockMushroomLightBlue;
import spellbound.blocks.BlockMushroomOrange;
import spellbound.blocks.BlockMushroomOrangeGrey;
import spellbound.blocks.BlockMushroomPinkOrange;
import spellbound.blocks.BlockMushroomPurple;
import spellbound.blocks.BlockMushroomRainbow;
import spellbound.blocks.BlockMushroomRedOrange;
import spellbound.blocks.BlockMushroomWhite;
import spellbound.blocks.BlockMushroomYellow;
import spellbound.core.forge.CommonProxy;
import spellbound.core.forge.PacketHandler;
import spellbound.core.util.SpellEntry;
import spellbound.entity.EntityTargetSpellCold;
import spellbound.entity.EntityTargetSpellDisintegrate;
import spellbound.entity.EntityTargetSpellDisruption;
import spellbound.entity.EntityTargetSpellDivination;
import spellbound.entity.EntityTargetSpellElementalFury;
import spellbound.entity.EntityTargetSpellFire;
import spellbound.entity.EntityTargetSpellLightning;
import spellbound.entity.EntityTargetSpellMundane;
import spellbound.external.PropertiesManager;
import spellbound.gen.WorldGenMushrooms;
import spellbound.item.ItemBookOfSpells;
import spellbound.item.ItemSpellTablet;
import spellbound.item.SpellboundItem;
import spellbound.spells.AbstractSpell;
import spellbound.spells.SpellAdvanceTime;
import spellbound.spells.SpellBlink;
import spellbound.spells.SpellBreach;
import spellbound.spells.SpellChangeWeather;
import spellbound.spells.SpellChaos;
import spellbound.spells.SpellColdLvl1;
import spellbound.spells.SpellColdLvl2;
import spellbound.spells.SpellColdLvl3;
import spellbound.spells.SpellColdShield;
import spellbound.spells.SpellColorSpray;
import spellbound.spells.SpellDimensionDoor;
import spellbound.spells.SpellDisintegrate;
import spellbound.spells.SpellElementalFury;
import spellbound.spells.SpellFireLvl1;
import spellbound.spells.SpellFireLvl2;
import spellbound.spells.SpellFireLvl3;
import spellbound.spells.SpellFireShield;
import spellbound.spells.SpellFishForm;
import spellbound.spells.SpellFlightLvl1;
import spellbound.spells.SpellFlightLvl2;
import spellbound.spells.SpellGrease;
import spellbound.spells.SpellHaste;
import spellbound.spells.SpellLightningLvl1;
import spellbound.spells.SpellLightningLvl2;
import spellbound.spells.SpellLightningLvl3;
import spellbound.spells.SpellLightningShield;
import spellbound.spells.SpellMiscastMagic;
import spellbound.spells.SpellPush;
import spellbound.spells.SpellShieldOfInvulnerability;
import spellbound.spells.SpellSummonChestFullOfCookies;
import spellbound.spells.SpellSummonLvl1;
import spellbound.spells.SpellSummonLvl2;
import spellbound.spells.SpellSummonLvl3;
import spellbound.spells.SpellSurgeShield;
import spellbound.spells.SpellTransport;
import spellbound.spells.SpellWailOfTheSheWolf;
import spellbound.spells.SpellWallOfBedrock;
import spellbound.spells.SpellWallOfObsidian;
import spellbound.spells.SpellWallOfStone;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid="spellbound", name="Spellbound", version="1.0.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=false,
channels={"SB_LIGHTNING", "SB_CHATMESSAGE", "SB_FLIGHT", "SB_WALLGFX", "SB_COLDGFX", "SB_SHIELDGFX",
		"SB_COLORGFX", "SB_SUMMONGFX"}, 
packetHandler = PacketHandler.class)
public class SpellboundCore
{
	@Instance("spellbound")
	private static SpellboundCore instance;

	@SidedProxy(clientSide="spellbound.core.forge.ClientProxy", serverSide="spellbound.core.forge.CommonProxy")
	public static CommonProxy proxy;

	public static Random modRandom = new Random();
	private static final Logger	logger = FMLLog.getLogger();

	public CreativeTabs spellboundTab;
	public PropertiesManager propertiesManager;
	public String runningDirectory;

	private final Map<EntityPlayer, List<SpellEntry>> activeSpells = new LinkedHashMap<EntityPlayer, List<SpellEntry>>();

	//False blocks
	public Block blockFalseObsidian;
	public Block blockFalseBedrock;

	//Mushrooms
	public Block blockPrimaryMushroomRedOrange;
	public Block blockPrimaryMushroomPinkOrange;
	public Block blockPrimaryMushroomBlueGrey;
	public Block blockHybridMushroomOrange;
	public Block blockHybridMushroomWhite;
	public Block blockHybridMushroomOrangeGrey;
	public Block blockHybridMushroomLightBlue;
	public Block blockHybridMushroomGrey;
	public Block blockHybridMushroomYellow;
	public Block blockHybridMushroomRainbow;
	public Block blockHybridMushroomGold;
	public Block blockHybridMushroomBlack;
	public Block blockHybridMushroomPurple;
	
	//Book of Spells
	public Item itemBookOfSpells;
	
	//Base
	public Item itemTabletBase;
	public Item itemTabletFireBase;
	public Item itemTabletColdBase;
	public Item itemTabletLightningBase;
	public Item itemTabletSummonBase;
	public Item itemTabletProtectionBase;
	public Item itemTabletDivinationBase;
	public Item itemTabletMundaneBase;
	public Item itemTabletDisruptionBase;

	//Offensive
	public ItemSpellTablet itemTabletFireLvl1;
	public ItemSpellTablet itemTabletFireLvl2;
	public ItemSpellTablet itemTabletFireLvl3;
	public ItemSpellTablet itemTabletColdLvl1;
	public ItemSpellTablet itemTabletColdLvl2;
	public ItemSpellTablet itemTabletColdLvl3;
	public ItemSpellTablet itemTabletLightningLvl1;
	public ItemSpellTablet itemTabletLightningLvl2;
	public ItemSpellTablet itemTabletLightningLvl3;

	//Summons
	public ItemSpellTablet itemTabletSummonLvl1;
	public ItemSpellTablet itemTabletSummonLvl2;
	public ItemSpellTablet itemTabletSummonLvl3;

	//Ultimate
	public ItemSpellTablet itemTabletWailOfTheSheWolf;
	public ItemSpellTablet itemTabletElementalFury;
	public ItemSpellTablet itemTabletDisintegrate;

	//Shields
	public ItemSpellTablet itemTabletFireShield;
	public ItemSpellTablet itemTabletColdShield;
	public ItemSpellTablet itemTabletLightningShield;
	public ItemSpellTablet itemTabletSurgeShield;
	public ItemSpellTablet itemTabletShieldOfInvulnerability;

	//Protection
	public ItemSpellTablet itemTabletWallOfStone;
	public ItemSpellTablet itemTabletWallOfObsidian;
	public ItemSpellTablet itemTabletWallOfBedrock;
	public ItemSpellTablet itemTabletPush;
	public ItemSpellTablet itemTabletColorSpray;
	public ItemSpellTablet itemTabletBlink;

	//Divination
	public ItemSpellTablet itemTabletTransport;
	public ItemSpellTablet itemTabletDimensionDoor;

	//Mundane
	public ItemSpellTablet itemTabletHaste;
	public ItemSpellTablet itemTabletGrease;
	public ItemSpellTablet itemTabletAdvanceTime;
	public ItemSpellTablet itemTabletChangeWeather;
	public ItemSpellTablet itemTabletFlightLvl1;
	public ItemSpellTablet itemTabletFlightLvl2;
	public ItemSpellTablet itemTabletFishForm;

	//Disruption
	public ItemSpellTablet itemTabletBreach;
	public ItemSpellTablet itemTabletMiscastMagic;
	public ItemSpellTablet itemTabletChaos;

	//Misc
	public ItemSpellTablet itemTabletSummonChestFullOfCookies;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		instance = this;
		runningDirectory = System.getProperty("user.dir");
		propertiesManager = new PropertiesManager();

		proxy.registerTickHandlers();
		proxy.registerSounds();

		registerCreativeTab();
		registerItems();
		registerBlocks();
		registerLocalizations();
		registerRecipes();
		
		proxy.registerRenderers();

		GameRegistry.registerWorldGenerator(new WorldGenMushrooms());
		EntityRegistry.registerModEntity(EntityTargetSpellFire.class, EntityTargetSpellFire.class.getSimpleName(), 9, this, 50, 2, true);
		EntityRegistry.registerModEntity(EntityTargetSpellCold.class, EntityTargetSpellCold.class.getSimpleName(), 10, this, 50, 2, true);
		EntityRegistry.registerModEntity(EntityTargetSpellLightning.class, EntityTargetSpellLightning.class.getSimpleName(), 11, this, 50, 2, true);
		EntityRegistry.registerModEntity(EntityTargetSpellDisruption.class, EntityTargetSpellDisruption.class.getSimpleName(), 12, this, 50, 2, true);
		EntityRegistry.registerModEntity(EntityTargetSpellDivination.class, EntityTargetSpellDivination.class.getSimpleName(), 13, this, 50, 2, true);
		EntityRegistry.registerModEntity(EntityTargetSpellMundane.class, EntityTargetSpellMundane.class.getSimpleName(), 14, this, 50, 2, true);
		EntityRegistry.registerModEntity(EntityTargetSpellElementalFury.class, EntityTargetSpellElementalFury.class.getSimpleName(), 15, this, 50, 2, true);
		EntityRegistry.registerModEntity(EntityTargetSpellDisintegrate.class, EntityTargetSpellDisintegrate.class.getSimpleName(), 16, this, 50, 2, true);
	}

	private void registerCreativeTab()
	{
		itemTabletDivinationBase = new SpellboundItem(propertiesManager.propertiesList.itemID_TabletDivinationBase, "tabletdivinationbase", "Divination Tablet");
		spellboundTab = new CreativeTabs("tabSpellbound")
		{
			public ItemStack getIconItemStack()
			{
				return new ItemStack(itemTabletDivinationBase, 1, 0);
			}
		};
		LanguageRegistry.instance().addStringLocalization("itemGroup.tabSpellbound", "Spellbound");
		itemTabletDivinationBase.setCreativeTab(spellboundTab);
	}

	private void registerItems()
	{
		//Book of Spells
		itemBookOfSpells = new ItemBookOfSpells(propertiesManager.propertiesList.itemID_BookOfSpells);
		
		//Base
		itemTabletBase = new SpellboundItem(propertiesManager.propertiesList.itemID_TabletBase, "tabletbase", "Blank Tablet");
		itemTabletFireBase = new SpellboundItem(propertiesManager.propertiesList.itemID_TabletFireBase, "tabletfirebase", "Fire Tablet");
		itemTabletColdBase = new SpellboundItem(propertiesManager.propertiesList.itemID_TabletColdBase, "tabletcoldbase", "Cold Tablet");
		itemTabletLightningBase = new SpellboundItem(propertiesManager.propertiesList.itemID_TabletLightningBase, "tabletlightningbase", "Lightning Tablet");
		itemTabletSummonBase = new SpellboundItem(propertiesManager.propertiesList.itemID_TabletSummonBase, "tabletsummonbase", "Summon Tablet");
		itemTabletProtectionBase = new SpellboundItem(propertiesManager.propertiesList.itemID_TabletProtectionBase, "tabletprotectionbase", "Protection Tablet");
		itemTabletMundaneBase = new SpellboundItem(propertiesManager.propertiesList.itemID_TabletMundaneBase, "tabletmundanebase", "Mundane Tablet");
		itemTabletDisruptionBase = new SpellboundItem(propertiesManager.propertiesList.itemID_TabletDisruptionBase, "tabletdisruptionbase", "Disruption Tablet");

		//Offensive
		itemTabletFireLvl1 = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletFireLvl1, "tabletfirelvl1", new SpellFireLvl1(), 1);
		itemTabletColdLvl1 = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletColdLvl1, "tabletcoldlvl1", new SpellColdLvl1(), 1);
		itemTabletLightningLvl1 = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletLightningLvl1, "tabletlightninglvl1", new SpellLightningLvl1(), 1);
		itemTabletFireLvl2 = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletFireLvl2, "tabletfirelvl2", new SpellFireLvl2(), 2);
		itemTabletColdLvl2 = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletColdLvl2, "tabletcoldlvl2", new SpellColdLvl2(), 2);
		itemTabletLightningLvl2 = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletLightningLvl2, "tabletlightninglvl2", new SpellLightningLvl2(), 2);
		itemTabletFireLvl3 = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletFireLvl3, "tabletfirelvl3", new SpellFireLvl3(), 3);
		itemTabletColdLvl3 = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletColdLvl3, "tabletcoldlvl3", new SpellColdLvl3(), 3);
		itemTabletLightningLvl3 = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletLightningLvl3, "tabletlightninglvl3", new SpellLightningLvl3(), 3);
		
		//Ultimate
		itemTabletWailOfTheSheWolf = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletWailOfTheSheWolf, "tabletwailoftheshewolf", new SpellWailOfTheSheWolf(), 4);
		itemTabletElementalFury = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletElementalFury, "tabletelementalfury", new SpellElementalFury(), 4);
		itemTabletDisintegrate = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletDisintegrate, "tabletdisintegrate", new SpellDisintegrate(), 4);
		
		//Summons
		itemTabletSummonLvl1 = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletSummonLvl1, "tabletsummonlvl1", new SpellSummonLvl1(), 1);
		itemTabletSummonLvl2 = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletSummonLvl2, "tabletsummonlvl2", new SpellSummonLvl2(), 2);
		itemTabletSummonLvl3 = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletSummonLvl3, "tabletsummonlvl3", new SpellSummonLvl3(), 3);
		
		//Shields
		itemTabletFireShield = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletFireShield, "tabletfireshield", new SpellFireShield(), 1);
		itemTabletColdShield = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletIceShield, "tableticeshield", new SpellColdShield(), 1);
		itemTabletLightningShield = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletLightningShield, "tabletlightningshield", new SpellLightningShield(), 1);
		itemTabletSurgeShield = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletSurgeShield, "tabletsurgeshield", new SpellSurgeShield(), 1);
		itemTabletShieldOfInvulnerability = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletShieldOfInvulnerability, "tabletshieldofinvulnerability", new SpellShieldOfInvulnerability(), 4);
		
		//Protection
		itemTabletWallOfStone = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletWallOfStone, "tabletwallofstone", new SpellWallOfStone(), 1);
		itemTabletWallOfObsidian = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletWallOfObsidian, "tabletwallofobsidian", new SpellWallOfObsidian(), 2);
		itemTabletWallOfBedrock = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletWallOfBedrock, "tabletwallofbedrock", new SpellWallOfBedrock(), 3);
		itemTabletPush = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletPush, "tabletpush", new SpellPush(), 1);
		itemTabletColorSpray = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletColorSpray, "tabletcolorspray", new SpellColorSpray(), 1);
		itemTabletGrease = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletGrease, "tabletgrease", new SpellGrease(), 1);
		itemTabletBlink = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletBlink, "tabletblink", new SpellBlink(), 1);
		
		//Divination
		itemTabletTransport = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletTransport, "tablettransport", new SpellTransport(), 1);
		itemTabletDimensionDoor = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletDimensionDoor, "tabletdimensiondoor", new SpellDimensionDoor(), 2);
		
		//Mundane
		itemTabletHaste = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletHaste, "tablethaste", new SpellHaste(), 1);
		itemTabletAdvanceTime = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletAdvanceTime, "tabletadvancetime", new SpellAdvanceTime(), 1);
		itemTabletChangeWeather = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletChangeWeather, "tabletchangeweather", new SpellChangeWeather(), 1);
		itemTabletFlightLvl1 = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletFlightLvl1, "tabletflightlvl1", new SpellFlightLvl1(), 1);
		itemTabletFlightLvl2 = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletFlightLvl2, "tabletflightlvl2", new SpellFlightLvl2(), 2);
		itemTabletFishForm = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletFishForm, "tabletfishform", new SpellFishForm(), 1);
		
		//Disruption
		itemTabletBreach = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletBreach, "tabletbreach", new SpellBreach(), 1);
		itemTabletMiscastMagic = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletMiscastMagic, "tabletmiscastmagic", new SpellMiscastMagic(), 2);
		itemTabletChaos = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletChaos, "tabletchaos", new SpellChaos(), 3);
		
		//Misc
		itemTabletSummonChestFullOfCookies = new ItemSpellTablet(propertiesManager.propertiesList.itemID_TabletCookies, "tabletsummonchestfullofcookies", new SpellSummonChestFullOfCookies(), 1);
	}

	private void registerBlocks()
	{
		blockFalseBedrock = new BlockFalseBedrock(propertiesManager.propertiesList.blockID_BlockFalseBedrock);
		blockFalseObsidian = new BlockFalseObsidian(propertiesManager.propertiesList.blockID_BlockFalseObsidian);

		blockPrimaryMushroomRedOrange = new BlockMushroomRedOrange(propertiesManager.propertiesList.blockID_MushroomRedOrange);
		blockPrimaryMushroomPinkOrange = new BlockMushroomPinkOrange(propertiesManager.propertiesList.blockID_MushroomPinkOrange);
		blockPrimaryMushroomBlueGrey = new BlockMushroomBlueGrey(propertiesManager.propertiesList.blockID_MushroomBlueGrey);
		blockHybridMushroomOrange = new BlockMushroomOrange(propertiesManager.propertiesList.blockID_MushroomOrange);
		blockHybridMushroomWhite = new BlockMushroomWhite(propertiesManager.propertiesList.blockID_MushroomWhite);
		blockHybridMushroomOrangeGrey = new BlockMushroomOrangeGrey(propertiesManager.propertiesList.blockID_MushroomOrangeGrey);
		blockHybridMushroomLightBlue = new BlockMushroomLightBlue(propertiesManager.propertiesList.blockID_MushroomLightBlue);
		blockHybridMushroomGrey = new BlockMushroomGrey(propertiesManager.propertiesList.blockID_MushroomGrey);
		blockHybridMushroomYellow = new BlockMushroomYellow(propertiesManager.propertiesList.blockID_MushroomYellow);
		blockHybridMushroomRainbow = new BlockMushroomRainbow(propertiesManager.propertiesList.blockID_MushroomRainbow);
		blockHybridMushroomGold = new BlockMushroomGold(propertiesManager.propertiesList.blockID_MushroomGold);
		blockHybridMushroomBlack = new BlockMushroomBlack(propertiesManager.propertiesList.blockID_MushroomBlack);
		blockHybridMushroomPurple = new BlockMushroomPurple(propertiesManager.propertiesList.blockID_MushroomPurple);
		
		GameRegistry.registerBlock(blockPrimaryMushroomRedOrange, "RedOrangePrimary");
		GameRegistry.registerBlock(blockPrimaryMushroomPinkOrange, "PinkOrangePrimary");
		GameRegistry.registerBlock(blockPrimaryMushroomBlueGrey, "BlueGreyPrimary");
		GameRegistry.registerBlock(blockHybridMushroomOrange, "OrangeHybrid");
		GameRegistry.registerBlock(blockHybridMushroomWhite, "WhiteHybrid");
		GameRegistry.registerBlock(blockHybridMushroomOrangeGrey, "GreyOrangeHybrid");
		GameRegistry.registerBlock(blockHybridMushroomLightBlue, "LightBlueHybrid");
		GameRegistry.registerBlock(blockHybridMushroomGrey, "GreyHybrid");
		GameRegistry.registerBlock(blockHybridMushroomYellow, "YellowHybrid");
		GameRegistry.registerBlock(blockHybridMushroomRainbow, "RainbowHybrid");
		GameRegistry.registerBlock(blockHybridMushroomGold, "GoldHybrid");
		GameRegistry.registerBlock(blockHybridMushroomBlack, "BlackHybrid");
		GameRegistry.registerBlock(blockHybridMushroomPurple, "PurpleHybrid");
	}

	private void registerRecipes()
	{
		//Book of Spells
		GameRegistry.addRecipe(new ItemStack(itemBookOfSpells),
				" T ", "TBT", " T ", 'B', Item.book, 'T', itemTabletBase);
		
		//Base Tablets
		GameRegistry.addRecipe(new ItemStack(itemTabletBase), 
				" C ", "C C", " C ", 'C', Item.clay);
		GameRegistry.addRecipe(new ItemStack(itemTabletFireBase), 
				" M ", "MTM", " M ", 'M', blockHybridMushroomOrange, 'T', itemTabletBase);
		GameRegistry.addRecipe(new ItemStack(itemTabletColdBase), 
				" M ", "MTM", " M ", 'M', blockHybridMushroomLightBlue, 'T', itemTabletBase);
		GameRegistry.addRecipe(new ItemStack(itemTabletLightningBase), 
				" M ", "MTM", " M ", 'M', blockHybridMushroomYellow, 'T', itemTabletBase);
		GameRegistry.addRecipe(new ItemStack(itemTabletSummonBase), 
				" M ", "MTM", " M ", 'M', blockHybridMushroomPurple, 'T', itemTabletBase);
		GameRegistry.addRecipe(new ItemStack(itemTabletProtectionBase), 
				" M ", "MTM", " M ", 'M', blockHybridMushroomGrey, 'T', itemTabletBase);
		GameRegistry.addRecipe(new ItemStack(itemTabletDivinationBase), 
				" M ", "MTM", " M ", 'M', blockHybridMushroomBlack, 'T', itemTabletBase);
		GameRegistry.addRecipe(new ItemStack(itemTabletMundaneBase), 
				" M ", "MTM", " M ", 'M', blockHybridMushroomRainbow, 'T', itemTabletBase);
		GameRegistry.addRecipe(new ItemStack(itemTabletDisruptionBase), 
				" M ", "MTM", " M ", 'M', blockHybridMushroomGold, 'T', itemTabletBase);

		//Offensive spells
		GameRegistry.addRecipe(new ItemStack(itemTabletFireLvl1), 
				" R ", "RTR", " R ", 'R', Item.redstone, 'T', itemTabletFireBase);
		GameRegistry.addRecipe(new ItemStack(itemTabletFireLvl2), 
				"RRR", "RTR", "RRR", 'R', Item.redstone, 'T', itemTabletFireLvl1);
		GameRegistry.addRecipe(new ItemStack(itemTabletFireLvl3), 
				" R ", "RTR", " R ", 'R', Block.blockRedstone, 'T', itemTabletFireLvl2);
		GameRegistry.addRecipe(new ItemStack(itemTabletColdLvl1), 
				" S ", "STS", " S ", 'S', Item.snowball, 'T', itemTabletColdBase);
		GameRegistry.addRecipe(new ItemStack(itemTabletColdLvl2), 
				"SSS", "STS", "SSS", 'S', Item.snowball, 'T', itemTabletColdLvl1);
		GameRegistry.addRecipe(new ItemStack(itemTabletColdLvl3), 
				" B ", "BTB", " B ", 'B', Block.blockSnow, 'T', itemTabletColdLvl2);
		GameRegistry.addRecipe(new ItemStack(itemTabletLightningLvl1), 
				" L ", "LTL", " L ", 'L', new ItemStack(Item.dyePowder, 1, 4), 'T', itemTabletLightningBase);
		GameRegistry.addRecipe(new ItemStack(itemTabletLightningLvl2),
				"LLL", "LTL", "LLL", 'L', new ItemStack(Item.dyePowder, 1, 4), 'T', itemTabletLightningLvl1);
		GameRegistry.addRecipe(new ItemStack(itemTabletLightningLvl3), 
				" L ", "LTL", " L ", 'L', new ItemStack(Block.blockLapis, 1), 'T', itemTabletLightningLvl2);

		//Ultimate Spells
		GameRegistry.addRecipe(new ItemStack(itemTabletElementalFury), 
				" F ", "CRL", 'F', itemTabletFireLvl3, 'L', itemTabletLightningLvl3, 'C', itemTabletColdLvl3, 'R', Item.redstone);
		GameRegistry.addRecipe(new ItemStack(itemTabletWailOfTheSheWolf), 
				" F ", "CRL", " E ", 'F', itemTabletFireLvl3, 'L', itemTabletLightningLvl3, 'C', itemTabletColdLvl3, 'R', Item.redstone, 'E', Block.enderChest);
		GameRegistry.addRecipe(new ItemStack(itemTabletDisintegrate), 
				" F ", "CRL", " B ", 'F', itemTabletFireLvl3, 'L', itemTabletLightningLvl3, 'C', itemTabletColdLvl3, 'R', Item.redstone, 'B', Item.bucketLava);		

		//Shields
		GameRegistry.addRecipe(new ItemStack(itemTabletFireShield), 
				"TTT", "TBT", " T ", 'T', itemTabletBase, 'B', itemTabletFireBase);
		GameRegistry.addRecipe(new ItemStack(itemTabletColdShield), 
				"TTT", "TBT", " T ", 'T', itemTabletBase, 'B', itemTabletColdBase);
		GameRegistry.addRecipe(new ItemStack(itemTabletLightningShield), 
				"TTT", "TBT", " T ", 'T', itemTabletBase, 'B', itemTabletLightningBase);
		GameRegistry.addRecipe(new ItemStack(itemTabletSurgeShield), 
				"TTT", "TBT", " T ", 'T', itemTabletBase, 'B', Item.swordGold);
		GameRegistry.addRecipe(new ItemStack(itemTabletShieldOfInvulnerability), 
				" F ", "CRL", " S ", 'F', itemTabletFireShield, 'C', itemTabletColdShield, 'R', Item.redstone, 'L', itemTabletLightningShield, 'S', itemTabletSurgeShield);

		//Summons
		GameRegistry.addRecipe(new ItemStack(itemTabletSummonLvl1), 
				"BMB", " T ", 'T', itemTabletSummonBase, 'B', Item.bone, 'M', Item.porkRaw);
		GameRegistry.addRecipe(new ItemStack(itemTabletSummonLvl2), 
				"AOA", "BTB", "FFF", 'A', Item.arrow, 'O', Item.bow, 'B', Item.bone, 'T', itemTabletSummonLvl1, 'F', Item.rottenFlesh);
		GameRegistry.addRecipe(new ItemStack(itemTabletSummonLvl3),
				"BSB", "BTB", "BBB", 'B', Item.bone, 'S', new ItemStack(Item.skull, 1, 1), 'T', itemTabletSummonLvl2);

		//Protection
		GameRegistry.addRecipe(new ItemStack(itemTabletWallOfStone), 
				" B ", "BTB", " B ", 'T', itemTabletProtectionBase, 'B', Block.stone);
		GameRegistry.addRecipe(new ItemStack(itemTabletWallOfObsidian), 
				" B ", "BTB", " B ", 'T', itemTabletWallOfStone, 'B', Block.obsidian);
		GameRegistry.addRecipe(new ItemStack(itemTabletWallOfBedrock), 
				" Q ", "QTQ", " Q ", 'T', itemTabletWallOfObsidian, 'Q', Item.netherQuartz);
		GameRegistry.addRecipe(new ItemStack(itemTabletColorSpray), 
				" R ", "BTY", " G ", 'T', itemTabletProtectionBase, 'R', new ItemStack(Item.dyePowder, 1, 1), 'B', new ItemStack(Item.dyePowder, 1, 4), 'Y', new ItemStack(Item.dyePowder, 1,11), 'G', new ItemStack(Item.dyePowder, 1, 2));
		GameRegistry.addRecipe(new ItemStack(itemTabletPush),
				" P ", "-T-", " R ", 'P', Block.pistonBase, '-', Block.torchRedstoneActive, 'T', itemTabletProtectionBase, 'R', Item.redstone);
		GameRegistry.addRecipe(new ItemStack(itemTabletGrease),
				"FMC", " T ", 'F', Block.furnaceIdle, 'M', Item.porkRaw, 'T', itemTabletMundaneBase, 'C', Item.coal);
		GameRegistry.addRecipe(new ItemStack(itemTabletBlink),
				" E ", "GTG", " G ", 'E', Item.enderPearl, 'G', Block.thinGlass, 'T', itemTabletProtectionBase);

		//Divination
		GameRegistry.addRecipe(new ItemStack(itemTabletTransport),
				"RRR", "RTR", "RRR", 'R', Block.rail, 'T', itemTabletDivinationBase);
		GameRegistry.addRecipe(new ItemStack(itemTabletDimensionDoor),
				"OOO", "OTO", "OFO", 'O', Block.obsidian, 'T', itemTabletTransport, 'F', Item.flintAndSteel);
		
		//Mundane
		GameRegistry.addRecipe(new ItemStack(itemTabletHaste),
				" M ", "RT-", 'M', Item.minecartEmpty, 'R', Block.railPowered, 'T', itemTabletMundaneBase, '-', Block.torchRedstoneActive);
		GameRegistry.addRecipe(new ItemStack(itemTabletAdvanceTime),
				" C ", "RTR", " R ", 'C', Item.pocketSundial, 'R', Item.redstone, 'T', itemTabletMundaneBase);
		GameRegistry.addRecipe(new ItemStack(itemTabletAdvanceTime),
				" C ", "RTR", " R ", 'C', Item.pocketSundial, 'R', Item.redstone, 'T', itemTabletMundaneBase);
		GameRegistry.addRecipe(new ItemStack(itemTabletChangeWeather),
				" B ", "STS", " F ", 'B', Item.bucketWater, 'S', Block.blockSnow, 'T', itemTabletMundaneBase, 'F', Block.plantYellow);
		GameRegistry.addRecipe(new ItemStack(itemTabletFlightLvl1),
				" F ", "FTF", " F ", 'T', itemTabletMundaneBase, 'F', Item.feather);
		GameRegistry.addRecipe(new ItemStack(itemTabletFlightLvl2),
				"FFF", "FTF", "FFF", 'T', itemTabletFlightLvl1, 'F', Item.feather);
		GameRegistry.addRecipe(new ItemStack(itemTabletFishForm),
				" F ", "FTF", " W ", 'T', itemTabletMundaneBase, 'F', Item.fishRaw, 'W', Item.bucketWater);

		//Disruption
		GameRegistry.addRecipe(new ItemStack(itemTabletBreach),
				" P ", "ATA", " A ", 'T', itemTabletDisruptionBase, 'P', itemTabletProtectionBase, 'A', Item.arrow);
		GameRegistry.addRecipe(new ItemStack(itemTabletMiscastMagic),
				" P ", "PTP", " P ", 'T', itemTabletBreach, 'P', Item.blazePowder);
		GameRegistry.addRecipe(new ItemStack(itemTabletChaos),
				" R ", "RTR", " R ", 'T', itemTabletMiscastMagic, 'R', Item.blazeRod);

		//Misc
		GameRegistry.addRecipe(new ItemStack(itemTabletSummonChestFullOfCookies), 
				" C ", "CTC", " H ", 'T', itemTabletBase, 'C', new ItemStack(Item.dyePowder, 1, 3), 'H', Block.chest);
	}

	private void registerLocalizations()
	{
		LanguageRegistry.addName(blockPrimaryMushroomRedOrange, "Red Orange Mushroom");
		LanguageRegistry.addName(blockPrimaryMushroomPinkOrange, "Pink Orange Mushroom");
		LanguageRegistry.addName(blockPrimaryMushroomBlueGrey, "Blue Grey Mushroom");
		LanguageRegistry.addName(blockHybridMushroomOrange, "Fire Mushroom");
		LanguageRegistry.addName(blockHybridMushroomWhite, "White Mushroom");
		LanguageRegistry.addName(blockHybridMushroomOrangeGrey, "Orange Grey Mushroom");
		LanguageRegistry.addName(blockHybridMushroomLightBlue, "Cold Mushroom");
		LanguageRegistry.addName(blockHybridMushroomGrey, "Protection Mushroom");
		LanguageRegistry.addName(blockHybridMushroomYellow, "Lightning Mushroom");
		LanguageRegistry.addName(blockHybridMushroomRainbow, "Mundane Mushroom");
		LanguageRegistry.addName(blockHybridMushroomGold, "Disruption Mushroom");
		LanguageRegistry.addName(blockHybridMushroomBlack, "Divination Mushroom");
		LanguageRegistry.addName(blockHybridMushroomPurple, "Summon Mushroom");
	}

	/**
	 * Writes the specified object's string representation to System.out.
	 * 
	 * @param 	obj	The object to write to System.out.
	 */
	public void log(Object obj)
	{
		Side side = FMLCommonHandler.instance().getEffectiveSide();

		if (obj instanceof Throwable)
		{
			((Throwable)obj).printStackTrace();
		}

		try
		{
			logger.log(Level.FINER, "Spellbound " + side.toString() + ": " + obj.toString());
			System.out.println("Spellbound " + side.toString() + ": " + obj.toString());

			MinecraftServer server = MinecraftServer.getServer();

			if (server != null)
			{
				if (server.isDedicatedServer())
				{
					MinecraftServer.getServer().logInfo("Spellbound: " + obj.toString());
				}
			}
		}

		catch (NullPointerException e)
		{
			logger.log(Level.FINER, "Spellbound " + side.toString() + ": null");
			System.out.println("Spellbound: null");

			MinecraftServer server = MinecraftServer.getServer();

			if (server != null)
			{
				if (server.isDedicatedServer())
				{
					MinecraftServer.getServer().logDebug("Spellbound " + side.toString() + ": null");
				}
			}
		}
	}

	/**
	 * Stops the game and writes the error to the Forge crash log.
	 * 
	 * @param 	description	A string providing a short description of the problem.
	 * @param 	e			The exception that caused this method to be called.
	 */
	@SideOnly(Side.CLIENT)
	public void quitWithDescription(String description)
	{
		Writer stackTrace = new StringWriter();

		Exception e = new Exception();
		PrintWriter stackTraceWriter = new PrintWriter(stackTrace);
		e.printStackTrace(stackTraceWriter);

		logger.log(Level.FINER, "Spellbound: An exception occurred.\n>>>>>" + description + "<<<<<\n" + stackTrace.toString());
		System.out.println("Spellbound: An exception occurred.\n>>>>>" + description + "<<<<<\n" + stackTrace.toString());

		CrashReport crashReport = new CrashReport("Spellbound: " + description, e);
		Minecraft.getMinecraft().crashed(crashReport);
		Minecraft.getMinecraft().displayCrashReport(crashReport);
	}
	
	/**
	 * Stops the game and writes the error to the Forge crash log.
	 * 
	 * @param 	description	A string providing a short description of the problem.
	 * @param 	e			The exception that caused this method to be called.
	 */
	@SideOnly(Side.CLIENT)
	public void quitWithException(String description, Exception e)
	{
		Writer stackTrace = new StringWriter();

		PrintWriter stackTraceWriter = new PrintWriter(stackTrace);
		e.printStackTrace(stackTraceWriter);

		logger.log(Level.FINER, "Spellbound: An exception occurred.\n>>>>>" + description + "<<<<<\n" + stackTrace.toString());
		System.out.println("Spellbound: An exception occurred.\n>>>>>" + description + "<<<<<\n" + stackTrace.toString());

		CrashReport crashReport = new CrashReport("Spellbound: " + description, e);
		
		Minecraft.getMinecraft().crashed(crashReport);
		Minecraft.getMinecraft().displayCrashReport(crashReport);
	}

	public void addActiveSpellToPlayer(EntityPlayer caster, AbstractSpell spell, int duration)
	{
		final List<SpellEntry> activeSpells = this.getActiveSpells().get(caster);

		if (activeSpells == null)
		{
			final List<SpellEntry> entryList = new ArrayList<SpellEntry>();
			entryList.add(new SpellEntry(spell, duration));
			this.getActiveSpells().put(caster, entryList);
		}

		else
		{
			activeSpells.add(new SpellEntry(spell, duration));
			this.getActiveSpells().put(caster, activeSpells);
		}
	}

	public boolean playerHasActiveSpell(EntityPlayer caster, Class spellClass)
	{
		final List<SpellEntry> activeSpells = this.getActiveSpells().get(caster);

		if (activeSpells != null)
		{
			for (final SpellEntry entry : activeSpells)
			{
				if (entry.spell.getClass().getSimpleName().equals(spellClass.getSimpleName()))
				{
					return true;
				}
			}
		}

		return false;
	}

	public void removeActiveSpellFromPlayer(EntityPlayer caster, Class spellClass)
	{
		final Map<EntityPlayer, Integer> badEntries = new HashMap<EntityPlayer, Integer>();
		final List<SpellEntry> activeSpells = this.getActiveSpells().get(caster);

		int index = 0;
		for (final SpellEntry entry : activeSpells)
		{
			if (entry.spell.getClass().getSimpleName().equals(spellClass.getSimpleName()))
			{
				badEntries.put(caster, index);
			}

			index++;
		}

		//Clean up old entries.
		for (final Map.Entry<EntityPlayer, Integer> badEntry : badEntries.entrySet())
		{
			final List<SpellEntry> spells = this.getActiveSpells().get(badEntry.getKey());
			final SpellEntry spellEntry = spells.get(badEntry.getValue());
			
			caster.addChatMessage(spellEntry.spell.getSpellDisplayName() + " has been dispelled!");
			spells.remove(spellEntry);
		}
	}

	public void sendMessageToPlayer(EntityPlayer player, String message)
	{
		if (player.worldObj.isRemote)
		{
			player.addChatMessage(message);
		}

		else
		{
			PacketDispatcher.sendPacketToPlayer(PacketHandler.createChatMessagePacket(message), (Player)player);
		}
	}

	public Map<EntityPlayer, List<SpellEntry>> getActiveSpells() 
	{
		return activeSpells;
	}

	public static boolean getBooleanWithProbability(int probability)
	{
		if (probability <= 0)
		{
			return false;
		}

		else
		{
			return modRandom.nextInt(100) + 1 <= probability;
		}
	}

	public static SpellboundCore getInstance()
	{
		return instance;
	}
}
