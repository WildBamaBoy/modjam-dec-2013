/**********************************************
 * ItemBookOfSpells.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.item;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemEditableBook;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.world.World;
import spellbound.core.SpellboundCore;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ItemBookOfSpells extends ItemEditableBook
{
	public ItemBookOfSpells(int itemId) 
	{
		super(itemId);
		this.setCreativeTab(SpellboundCore.getInstance().spellboundTab);
		this.setUnlocalizedName("bookofspells");
		LanguageRegistry.addName(this, "The Book of Spells");

		this.setTextureName("book_normal");
	}

	private NBTTagList putTableOfContents(NBTTagList bookTagList)
	{
		bookTagList.appendTag(new NBTTagString("1", 
				"\n   Table of Contents\n"
						+ "\nMushrooms..........................2"
						+ "\nSpell Basics......................16"
						+ "\nRecipes.................................20"));
		
		return bookTagList;
	}
	
	private NBTTagList putMushroomInformation(NBTTagList bookTagList)
	{
		bookTagList.appendTag(new NBTTagString("2", 
				"       Mushrooms \n\n"
						+ "   Mushrooms are used in the crafting of base spell tablets. \n\nA spellcaster"
						+ "must find and breed mushrooms to produce the mushrooms that can be used in spells."));

		bookTagList.appendTag(new NBTTagString("3", 
				"There are three types of mushrooms found in the wilderness:"
						+ "\n\n-Red with orange dots"
						+ "\n-Red with pink dots"
						+ "\n-Blue with grey dots"
						+ "\n\nTo breed a mushroom, place it beside a valid mate, and a new hybrid mushroom will eventually form."));

		bookTagList.appendTag(new NBTTagString("4", 
				"Red Orange Mushroom"
						+ "\n\n+ Pink Orange = Fire or White"
						+ "\n+ Lightning = Mundane"
						+ "\n\nNotes: Spawns naturally."));

		bookTagList.appendTag(new NBTTagString("5", 
				"Pink Orange Mushroom"
						+ "\n\n+ Red Orange = Fire or White"
						+ "\n\nNotes: Spawns naturally."));

		bookTagList.appendTag(new NBTTagString("6", 
				"Blue Grey Mushroom"
						+ "\n+ Protection = Divination"
						+ "\n+ Orange Grey = Protection or Cold"
						+ "\n+ Fire = Orange Grey"
						+ "\n\nNotes: Spawns naturally."));

		bookTagList.appendTag(new NBTTagString("7", 
				"Fire Mushroom"
						+ "\n+ Blue Grey = Orange Grey"
						+ "\n\nNotes: Makes fire tablets."));

		bookTagList.appendTag(new NBTTagString("8", 
				"White Mushroom"
						+ "\n\nNotes: Breeds with all other mushrooms, making either the same color or another white mushroom."));

		bookTagList.appendTag(new NBTTagString("9", 
				"Orange Grey Mushroom"
						+ "\n+ Blue Grey = Protection or Cold"
						+ "\n\nNotes: N/A"));

		bookTagList.appendTag(new NBTTagString("10", 
				"Cold Mushroom"
						+ "\nNo mates!"
						+ "\n\nNotes: Makes cold tablets."));

		bookTagList.appendTag(new NBTTagString("11", 
				"Protection Mushroom"
						+ "\n+ Orange Grey = Lightning"
						+ "\n+ Blue Grey = Divination"
						+ "\n+ Mundane = Summon"
						+ "\n\nNotes: N/A"));

		bookTagList.appendTag(new NBTTagString("12", 
				"Lightning Mushroom"
						+ "\n+ Mundane = Disruption"
						+ "\n+ Red Orange = Mundane"
						+ "\n\nNotes: Makes lightning tablets."));

		bookTagList.appendTag(new NBTTagString("13", 
				"Mundane Mushroom"
						+ "\n+ Yellow = Disruption"
						+ "\n+ Grey = Summon"
						+ "\n\nNotes: N/A"));

		bookTagList.appendTag(new NBTTagString("14", 
				"Disruption Mushroom"
						+ "\nNo mates!"
						+ "\n\nNotes: N/A"));

		bookTagList.appendTag(new NBTTagString("15", 
				"Divination Mushroom"
						+ "\nNo mates!"
						+ "\n\nNotes: N/A"));
		
		return bookTagList;
	}
	
	private NBTTagList putSpellBasics(NBTTagList bookTagList)
	{
		bookTagList.appendTag(new NBTTagString("16", 
				"\n\n\n\n\n       Spell Basics"));

		bookTagList.appendTag(new NBTTagString("17", 
				"Spells are made and cast by crafting spell tablets."
						+ "\n\nSpell tablets begin with a blank tablet. \n\n"
						+ "BLANK TABLET"
						+ "\n           - C -"
						+ "\n           C - C"
						+ "\n           - C - "
						+ "\nWhere 'C' is a ball of clay."));

		bookTagList.appendTag(new NBTTagString("18", 
				"Casting spells is easy. Simply right-click with a spell to allow it to charge."
						+ "\n\nEach spell has a specified charge time. You will hear a *ping!* when the spell is ready to fire. \n\nRelease the mouse button to do so."));

		bookTagList.appendTag(new NBTTagString("19", 
				"Be warned, magic energy is unstable. Sometimes, your spell will turn into a magical surge.\n\n"
						+ "Magical surges are often devastating to the environment and caster.\n\n"
						+ "There's a reason why surges are undocumented..."));

		bookTagList.appendTag(new NBTTagString("20", 
				"\n\n\n\n\n           Recipes"));

		bookTagList.appendTag(new NBTTagString("21", "       Spell Tablets\n\n"
				+ "Fire Tablet\n"
				+ "  - F -\n"
				+ "  F T F   F = Fire Msh.\n"
				+ "  - F -   T = Blank Tab.\n\n"
				+ "Cold Tablet\n"
				+ "  - C -\n"
				+ "  C T C   C = Cold Msh.\n"
				+ "  - C -   T = Blank Tab.\n\n"));

		bookTagList.appendTag(new NBTTagString("22",
				"Lightning Tablet\n"
						+ "  - L -\n"
						+ "  L T L   L = Lght. Msh.\n"
						+ "  - L -   T = Blank Tab.\n\n"
						+ "Summon Tablet\n"
						+ "  - S -\n"
						+ "  S T S   S = Summ. Msh.\n"
						+ "  - S -   T = Blank Tab.\n\n"
						+ "Protection Tablet\n"
						+ "  - P -\n"
						+ "  P T P   P = Prot. Msh.\n"
						+ "  - P -   T = Blank Tab.\n\n"));

		bookTagList.appendTag(new NBTTagString("23",
				"Divination Tablet\n"
						+ "  - D -\n"
						+ "  D T D   D = Div. Msh.\n"
						+ "  - D -   T = Blank Tab.\n\n"
						+ "Mundane Tablet\n"
						+ "  - S -\n"
						+ "  S T S   S = Mund. Msh.\n"
						+ "  - S -   T = Blank Tab.\n\n"
						+ "Disruption Tablet\n"
						+ "  - D -\n"
						+ "  D T D   D = Dis. Msh.\n"
						+ "  - D -   T = Blank Tab.\n\n"));
		return bookTagList;
	}
	
	private NBTTagList putElementalRecipes(NBTTagList bookTagList)
	{
		bookTagList.appendTag(new NBTTagString("24", "\n\n\n\n\n        Fire Spells\n"));

		bookTagList.appendTag(new NBTTagString("24",
				"Flaming Hands (Lvl1)\n"
						+ "  - R -\n"
						+ "  R T R   R = Redstone\n"
						+ "  - R -   T = Fire Tab.\n\n"
						+ "Fireball (Lvl2)\n"
						+ "  R R R\n"
						+ "  R T R   R = Redstone\n"
						+ "  R R R   T = Lvl1 Fire\n\n"
						+ "Greater Fireball\n"
						+ "  - B -\n"
						+ "  B T B   B = Redst. Blk.\n"
						+ "  - B -   T = Lvl2 Fire\n\n"));
		bookTagList.appendTag(new NBTTagString("25",
				"Fire Shield (Lvl1)\n"
						+ "  B B B\n"
						+ "  B T B   B = Blank Tab.\n"
						+ "  - B -   T = Fire Tab.\n\n"
						+ "Protects from fire and fire spells."));

		bookTagList.appendTag(new NBTTagString("24", "\n\n\n\n\n        Cold Spells\n\n" + "(Note: Extinguishes fire.)"));

		bookTagList.appendTag(new NBTTagString("24",
				"Icy Grip (Lvl1)\n"
						+ "  - S -\n"
						+ "  S T S   S = Snowball\n"
						+ "  - S -   T = Snow Tab.\n\n"
						+ "Icicle (Lvl2)\n"
						+ "  S S S\n"
						+ "  S T S   S = Snowball\n"
						+ "  S S S   T = Lvl1 Cold\n\n"
						+ "Cold Blast (Lvl3)\n"
						+ "  - B -\n"
						+ "  B T B   B = Snow Blk.\n"
						+ "  - B -   T = Lvl2 Cold\n\n"));
		bookTagList.appendTag(new NBTTagString("25",
				"Cold Shield (Lvl1)\n"
						+ "  B B B\n"
						+ "  B C B   B = Blank Tab.\n"
						+ "  - B -   T = Cold Tab.\n\n"
						+ "Protects from cold spells."));

		bookTagList.appendTag(new NBTTagString("24", "\n\n\n\n\n     Lightning Spells\n"));

		bookTagList.appendTag(new NBTTagString("24",
				"Tazer (Lvl1)\n"
						+ "  - L -\n"
						+ "  L T L   L = Lapis Laz.\n"
						+ "  - L -   T = Lght. Tab.\n\n"
						+ "Lightning Bolt (Lvl2)\n"
						+ "  L L L\n"
						+ "  L T L   L = Lapis Laz.\n"
						+ "  L L L   T = Lvl1 Lght.\n\n"
						+ "Area Lightning (Lvl3)\n"
						+ "  - B -\n"
						+ "  B T B   B = Lapis Blk.\n"
						+ "  - B -   T = Lvl2 Lght.\n\n"));
		bookTagList.appendTag(new NBTTagString("25",
				"Lightning Shield (Lvl1)\n"
						+ "  B B B\n"
						+ "  B C B   B = Blank Tab.\n"
						+ "  - B -   T = Lght. Tab.\n\n"
						+ "Protects from lightning spells."));

		bookTagList.appendTag(new NBTTagString("24", "\n\n\n\n\n     Ultimate Spells\n"));

		bookTagList.appendTag(new NBTTagString("25",
				"Wail of the She Wolf\n\n"
						+ "  - F -   F = Lvl3 Fire\n"
						+ "  C R L   C = Lvl3 Cold.\n"
						+ "  - E -   L = Lvl3 Lght.\n"
						+ "     R = Redstone \n"
						+ "     E = Ender Chest\n"
						+ "\nEnergies release from the ender chest with a horrifying scream. All enemies in the area die."));

		bookTagList.appendTag(new NBTTagString("25",
				"Elemental Fury\n\n"
						+ "  - F -   F = Lvl3 Fire\n"
						+ "  C R L   C = Lvl3 Cold.\n"
						+ "  - - -   L = Lvl3 Lght.\n"
						+ "     R = Redstone \n"
						+ "\nAll Lvl 3 elemental spells combine into one large explosion of energy."));

		bookTagList.appendTag(new NBTTagString("25",
				"Disintegrate\n\n"
						+ "  - F -   F = Lvl3 Fire\n"
						+ "  C R L   C = Lvl3 Cold.\n"
						+ "  - L -   L = Lvl3 Lght.\n"
						+ "     R = Redstone \n"
						+ "     L = Lava\n"
						+ "\nEnemies turn into bone meal or catch fire."));

		bookTagList.appendTag(new NBTTagString("25",
				"Shield of Invulnerability\n\n"
						+ "  - F -   F = Fire Shld.\n"
						+ "  C R L   C = Cold Shld.\n"
						+ "  - S -   L = Lght. Shld\n"
						+ "     R = Redstone \n"
						+ "     S = Surge Shld.\n"
						+ "\nNo offensive spells can affect you, even those that disable shields."));
		bookTagList.appendTag(new NBTTagString("25",
				"Panic Room\n\n"
						+ "  R T R\n"
						+ "  T T T   R = Redstone\n"
						+ "  R T R   T = Lvl3 Wall\n"
						+ "\n\nYou are encased in a room made of false bedrock."));
		
		return bookTagList;
	}
	
	private NBTTagList putSummonRecipes(NBTTagList bookTagList)
	{
		bookTagList.appendTag(new NBTTagString("24", "\n\n\n\n\n   Summoning Spells\n"));

		bookTagList.appendTag(new NBTTagString("25",
				"Summon Wolf (Lvl1)\n\n"
						+ "  B M B   B = Bone\n"
						+ "  - T -   M = Raw Pork\n"
						+ "  - - -   T = Sum. Tab.\n"
						+ "\n"
						+ "\nA tamed wolf appears at your location."));

		bookTagList.appendTag(new NBTTagString("25",
				"Summon Mob (Lvl2)\n\n"
						+ "  A O A   A = Arrow\n"
						+ "  B T B   O = Bow\n"
						+ "  F F F   B = Bone\n"
						+ "     F = Rot. Flesh\n"
						+ "     T = Lvl1 Summ.\n"
						+ "\nA zombie or skeleton appears at your location."));

		bookTagList.appendTag(new NBTTagString("25",
				"Summon Wither Skeleton\n\n"
						+ "  B S B  S = Wthr. Skull\n"
						+ "  B T B  T = Lvl2 Summ.\n"
						+ "  B B B  B = Bone\n"
						+ "     R = Redstone \n"
						+ "     L = Lava\n"
						+ "\nA wither skeleton appears at your location."));
		
		return bookTagList;
	}
	
	private NBTTagList putProtectionRecipes(NBTTagList bookTagList)
	{
		bookTagList.appendTag(new NBTTagString("24", "\n\n\n\n\n   Protection Spells\n"));

		bookTagList.appendTag(new NBTTagString("24",
				"Wall of Stone (Lvl1)\n"
						+ "  S S S\n"
						+ "  S T S   S = Stone\n"
						+ "  S S S   T = Prot Tab.\n\n"
						+ "Wall of Obsidian (Lvl2)\n"
						+ "  O O O\n"
						+ "  O T O   O = Obsidian\n"
						+ "  O O O   T = Lvl1 Wall\n\n"
						+ "Wall of Bedrock (Lvl3)\n"
						+ "  - Q -\n"
						+ "  Q T Q   Q = Quartz\n"
						+ "  - Q -   T = Lvl2 Wall\n\n"));
		bookTagList.appendTag(new NBTTagString("25",
				"Push\n\n"
						+ "  - P -   P = Piston\n"
						+ "  O T O   O = Red Tch.\n"
						+ "  - R -   T = Prot Tab.\n"
						+ "     R = Redstone \n"
						+ "\n\nEnemies around you are pushed away. Can not push players."));
		bookTagList.appendTag(new NBTTagString("25",
				"Color Spray\n\n"
						+ "  - R -   R = Red\n"
						+ "  B T Y   B = Blue\n"
						+ "  - G -   Y = Yellow\n"
						+ "     G = Green \n"
						+ "     T = Prot Tab.\n"
						+ "\nEnemies in front of you are blinded."));
		bookTagList.appendTag(new NBTTagString("25",
				"Blink\n\n"
						+ "  - E -   E = End Pearl\n"
						+ "  G T G   T = Prot Tab.\n"
						+ "  - G -   G = Gla. Pane\n"
						+ "\nYou become invisible for a short time."));
		return bookTagList;
	}
	
	private NBTTagList putDivinationRecipes(NBTTagList bookTagList)
	{
		bookTagList.appendTag(new NBTTagString("24", "\n\n\n\n\n    Divination Spells\n"));

		bookTagList.appendTag(new NBTTagString("25",
				"Transport\n\n"
						+ "  R R R \n"
						+ "  R T R   T = Div. Tab.\n"
						+ "  R R R   R = Rail\n"
						+ "\n\nYou are granted super speed for a fraction of a second, allowing you to reach your destination in the blink of an eye."));

		bookTagList.appendTag(new NBTTagString("25",
				"Dimension Door\n\n"
						+ "  O O O   O = Obsidian\n"
						+ "  O T O   T = Lvl1 Div.\n"
						+ "  O F O   F = Flnt/Stl.\n"
						+ "\n\nYou create a Nether portal and step inside, only to appear out of the other side several hundred blocks away."));
		return bookTagList;
	}
	
	private NBTTagList putMundaneRecipes(NBTTagList bookTagList)
	{
		bookTagList.appendTag(new NBTTagString("24", "\n\n\n\n\n    Mundane Spells\n"));

		bookTagList.appendTag(new NBTTagString("25",
				"Haste\n\n"
						+ "  - M -  T = Mund Tab.\n"
						+ "  P T R  P = Pwr. Rl.\n"
						+ "  - - -  R = Red Tch\n"
						+ "         M = Minecart"
						+ "\n\nYou can move faster and break blocks faster for a short time."));

		bookTagList.appendTag(new NBTTagString("25",
				"Advance Time\n\n"
						+ "  - C -  C = Clock\n"
						+ "  R T R  T = Mund. Tab\n"
						+ "  - R -  R = Redstone\n"
						+ "\n\nTime advances by a random amount, making crops grow instantly."));

		bookTagList.appendTag(new NBTTagString("25",
				"Change Weather\n\n"
						+ "  - W -  W = Water\n"
						+ "  S T S  T = Mund. Tab\n"
						+ "  - F -  F = Yel. Flr.\n"
						+ "         S = Snow Blk."
						+ "\n\nYou manipulate the weather, spawning a torrential downpour or brilliant sunshine."));

		bookTagList.appendTag(new NBTTagString("25",
				"Instant Levitation (Lvl1)\n\n"
						+ "  - F -   \n"
						+ "  F T F   T = Mund. Tab\n"
						+ "  - F -   F = Feather\n"
						+ "\n\nYou levitate above the ground for 1 second. Great for stopping falls!"));
		
		bookTagList.appendTag(new NBTTagString("25",
				"Flight (Lvl2)\n\n"
						+ "  F F F   \n"
						+ "  F T F   T = Flht. Lvl1\n"
						+ "  F F F   F = Feather\n"
						+ "\n\nYou take flight for 20 seconds. Careful where you land!"));

		bookTagList.appendTag(new NBTTagString("25",
				"Fish Form\n\n"
						+ "  - F -   F = Raw Fish\n"
						+ "  F T F   T = Lvl1 Div.\n"
						+ "  - W -   W = Water\n"
						+ "\n\nYou can breathe underwater for a short time."));

		bookTagList.appendTag(new NBTTagString("25",
				"Grease\n\n"
						+ "  F M C   F = Furnace\n"
						+ "  - T -   M = Raw Pork\n"
						+ "  - F -   C = Coal"
						+ "      T = Mund. Tab\n"
						+ "\n\nPigs are turned into cooked porkchops."));
		return bookTagList;
	}
	
	private NBTTagList putDisruptionRecipes(NBTTagList bookTagList)
	{
		bookTagList.appendTag(new NBTTagString("24", "\n\n\n\n\n    Disruption Spells\n"));

		bookTagList.appendTag(new NBTTagString("25",
				"Breach (Lvl 1)\n\n"
						+ "  - P -   P = Prot Tab.\n"
						+ "  A T A   T = Dis. Tab.\n"
						+ "  - A -   A = Arrow\n"
						+ "\n\nThe target's spell protections are removed. Can not effect players with Shield of Invulnerability."));

		bookTagList.appendTag(new NBTTagString("25",
				"Miscast Magic (Lvl 2)\n\n"
						+ "  - P -   \n"
						+ "  P T P   T = Lvl1 Dis.\n"
						+ "  - P -   P = Blz. Pdr.\n"
						+ "\n\nThe target can no longer cast spells for a short time. Can not effect players with Shield of Invulnerability."));

		bookTagList.appendTag(new NBTTagString("25",
				"Chaos (Lvl 3)\n\n"
						+ "  - R -   \n"
						+ "  R T R   R = Blz. Rod\n"
						+ "  - R -   T = Lvl2 Dis.\n"
						+ "\n\nThe target has a high chance of suffering a magical surge. Can not effect players with Shield of Invulnerability."));
		return bookTagList;
	}
	
	private NBTTagList putMiscRecipes(NBTTagList bookTagList)
	{
		bookTagList.appendTag(new NBTTagString("24", "\n\n\n\n\n       Misc. Spells\n"));

		bookTagList.appendTag(new NBTTagString("25",
				"Summon Chest Full of Cookies\n\n"
						+ "  - C -   C = Cookie\n"
						+ "  C T C   T = Blank Tab.\n"
						+ "  - H -   H = Chest\n"
						+ "\n\nCOOKIES!?!?!?"));
		return bookTagList;
	}
	
	@Override
	public void onUpdate(ItemStack itemStack, World world, Entity entity, int unknownInt, boolean unknownBool)
	{
		NBTTagList bookTagList = new NBTTagList("pages");

		bookTagList = putTableOfContents(bookTagList);
		bookTagList = putMushroomInformation(bookTagList);
		bookTagList = putSpellBasics(bookTagList);
		bookTagList = putElementalRecipes(bookTagList);
		bookTagList = putSummonRecipes(bookTagList);
		bookTagList = putProtectionRecipes(bookTagList);
		bookTagList = putDivinationRecipes(bookTagList);
		bookTagList = putMundaneRecipes(bookTagList);
		bookTagList = putDisruptionRecipes(bookTagList);
		bookTagList = putMiscRecipes(bookTagList);
		
		itemStack.setTagInfo("pages", bookTagList);
		itemStack.setTagInfo("author", new NBTTagString("author", "Spellbound"));
		itemStack.setTagInfo("title", new NBTTagString("title", "The Book of Spells"));
		itemStack.itemID = Item.writtenBook.itemID;
	}
}
