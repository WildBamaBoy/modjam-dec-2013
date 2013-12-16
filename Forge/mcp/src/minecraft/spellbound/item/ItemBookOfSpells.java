package spellbound.item;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemEditableBook;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import spellbound.core.SpellboundCore;

public class ItemBookOfSpells extends ItemEditableBook
{
	public ItemBookOfSpells(int itemId) 
	{
		super(itemId);
		this.setCreativeTab(SpellboundCore.instance.spellboundTab);
		this.setUnlocalizedName("bookofspells");
		LanguageRegistry.addName(this, "The Book of Spells");

		this.setTextureName("book_normal");
	}

	public static ItemStack addBookInfoToStack(ItemStack bookStack)
	{
		NBTTagList bookPages = new NBTTagList("pages");
		
		bookPages.appendTag(new NBTTagString("1", 
				"\n   Table of Contents\n"
				+ "\nMushrooms..........................2"
				+ "\nSpell Basics......................17"
				+ "\nRecipes.................................20"));
		
		bookPages.appendTag(new NBTTagString("2", 
				"       Mushrooms \n\n"
				+ "   Mushrooms are used in the crafting of base spell tablets. \n\nA spellcaster"
				+ "must find and breed mushrooms to produce the mushrooms that can be used in spells."));
		
		bookPages.appendTag(new NBTTagString("3", 
				"There are three types of mushrooms found in the wilderness:"
				+ "\n\n-Red with orange dots"
				+ "\n-Red with pink dots"
				+ "\n-Blue with grey dots"
				+ "\n\nTo breed a mushroom, place it beside a valid mate, and a new hybrid mushroom will eventually form."));
		
		bookPages.appendTag(new NBTTagString("4", 
				"Red Orange Mushroom"
				+ "\n\n+ Pink Orange = Fire or White"
				+ "\n+ Yellow = Rainbow"
				+ "\n\nNotes: Spawns naturally."));
		
		bookPages.appendTag(new NBTTagString("5", 
				"Pink Orange Mushroom"
				+ "\n\n+ Red Orange = Fire or White"
				+ "\n\nNotes: Spawns naturally."));
		
		bookPages.appendTag(new NBTTagString("6", 
				"Blue Grey Mushroom"
				+ "\n+ Grey = Black"
				+ "\n+ Orange Grey = Grey or Cold"
				+ "\n+ Fire = Orange Grey"
				+ "\n\nNotes: Spawns naturally."));
		
		bookPages.appendTag(new NBTTagString("7", 
				"Fire Mushroom"
				+ "\n+ Blue Grey = Orange Grey"
				+ "\n\nNotes: Makes fire tablets."));
		
		bookPages.appendTag(new NBTTagString("8", 
				"White Mushroom"
				+ "\n\nNotes: Breeds with all other mushrooms, making either the same color or another white mushroom."));
		
		bookPages.appendTag(new NBTTagString("9", 
				"Orange Grey Mushroom"
				+ "\n+ Blue Grey = Grey or Cold"
				+ "\n\nNotes: N/A"));
		
		bookPages.appendTag(new NBTTagString("10", 
				"Cold Mushroom"
				+ "\nNo mates!"
				+ "\n\nNotes: Makes cold tablets."));
		
		bookPages.appendTag(new NBTTagString("11", 
				"Grey Mushroom"
				+ "\n+ Orange Grey = Lightning"
				+ "\n+ Blue Grey = Black"
				+ "\n+ Rainbow = Purple"
				+ "\n\nNotes: N/A"));
		
		bookPages.appendTag(new NBTTagString("12", 
				"Lightning Mushroom"
				+ "\n+ Rainbow = Gold"
				+ "\n+ Red Orange = Rainbow"
				+ "\n\nNotes: Makes lightning tablets."));
		
		bookPages.appendTag(new NBTTagString("13", 
				"Rainbow Mushroom"
				+ "\n+ Yellow = Gold"
				+ "\n+ Grey = Purple"
				+ "\n\nNotes: N/A"));
		
		bookPages.appendTag(new NBTTagString("14", 
				"Gold Mushroom"
				+ "\nNo mates!"
				+ "\n\nNotes: N/A"));
		
		bookPages.appendTag(new NBTTagString("15", 
				"Black Mushroom"
				+ "\nNo mates!"
				+ "\n\nNotes: N/A"));
		
		bookPages.appendTag(new NBTTagString("16", 
				"\n\n\n\n\n       Spell Basics"));

		bookPages.appendTag(new NBTTagString("17", 
				"Spells are made and cast by crafting spell tablets."
				+ "\n\nSpell tablets begin with a blank tablet. \n\n"
				+ "BLANK TABLET"
				+ "\n           - C -"
				+ "\n           C - C"
				+ "\n           - C - "
				+ "\nWhere 'C' is a ball of clay."));
		
		bookPages.appendTag(new NBTTagString("18", 
				"Casting spells is easy. Simply right-click with a spell to allow it to charge."
				+ "\n\nEach spell has a specified charge time. You will hear a *ping!* when the spell is ready to fire. \n\nRelease the mouse button to do so."));
		
		bookPages.appendTag(new NBTTagString("19", 
				"Be warned, magic energy is unstable. Sometimes, your spell will turn into a magical surge.\n\n"
				+ "Magical surges are often devastating to the environment and caster.\n\n"
				+ "There's a reason why surges are undocumented..."));
		
		bookPages.appendTag(new NBTTagString("20", 
				"\n\n\n\n\n           Recipes"));
		
		bookPages.appendTag(new NBTTagString("21", "       Spell Tablets\n\n"
				+ "Fire Tablet\n"
				+ "  - F -\n"
				+ "  F T F   F = Fire Msh.\n"
				+ "  - F -   T = Blank Tab.\n\n"
				+ "Cold Tablet\n"
				+ "  - C -\n"
				+ "  C T C   C = Cold Msh.\n"
				+ "  - C -   T = Blank Tab.\n\n"));
		
		bookPages.appendTag(new NBTTagString("22",
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

		bookPages.appendTag(new NBTTagString("23",
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
		
		bookPages.appendTag(new NBTTagString("24", "\n\n\n\n\n        Fire Spells\n"));
		
		bookPages.appendTag(new NBTTagString("24",
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
		bookPages.appendTag(new NBTTagString("25",
				"Fire Shield (Lvl1)\n"
				+ "  B B B\n"
				+ "  B T B   B = Blank Tab.\n"
				+ "  - B -   T = Fire Tab.\n\n"
				+ "Protects from fire and fire spells."));
		
		bookPages.appendTag(new NBTTagString("24", "\n\n\n\n\n        Cold Spells\n"));
		
		bookPages.appendTag(new NBTTagString("24",
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
		bookPages.appendTag(new NBTTagString("25",
				"Cold Shield (Lvl1)\n"
				+ "  B B B\n"
				+ "  B C B   B = Blank Tab.\n"
				+ "  - B -   T = Cold Tab.\n\n"
				+ "Protects from cold spells."));
		
		bookPages.appendTag(new NBTTagString("24", "\n\n\n\n\n     Lightning Spells\n"));
		
		bookPages.appendTag(new NBTTagString("24",
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
		bookPages.appendTag(new NBTTagString("25",
				"Lightning Shield (Lvl1)\n"
				+ "  B B B\n"
				+ "  B C B   B = Blank Tab.\n"
				+ "  - B -   T = Lght. Tab.\n\n"
				+ "Protects from lightning spells."));
		
		bookPages.appendTag(new NBTTagString("24", "\n\n\n\n\n   Ultimate Spells\n"));
		
		bookPages.appendTag(new NBTTagString("25",
				"Wail of the Banshee\n\n"
				+ "  - F -   F = Lvl3 Fire\n"
				+ "  C R L   C = Lvl3 Cold.\n"
				+ "  - E -   L = Lvl3 Lght.\n"
				+ "     R = Redstone \n"
				+ "     E = Ender Chest\n"
				+ "\nEnergies release from the ender chest with a horrifying scream. All enemies in the area die."));

		bookPages.appendTag(new NBTTagString("25",
				"Elemental Fury\n\n"
				+ "  - F -   F = Lvl3 Fire\n"
				+ "  C R L   C = Lvl3 Cold.\n"
				+ "  - - -   L = Lvl3 Lght.\n"
				+ "     R = Redstone \n"
				+ "\nAll Lvl 3 elemental spells combine into one large explosion of energy."));
		
		bookPages.appendTag(new NBTTagString("25",
				"Disintegrate\n\n"
				+ "  - F -   F = Lvl3 Fire\n"
				+ "  C R L   C = Lvl3 Cold.\n"
				+ "  - L -   L = Lvl3 Lght.\n"
				+ "     R = Redstone \n"
				+ "     L = Lava\n"
				+ "\nEnemies turn into bone meal or catch fire."));
		
		bookPages.appendTag(new NBTTagString("25",
				"Shield of Invulnerability\n\n"
				+ "  - F -   F = Fire Shld.\n"
				+ "  C R L   C = Cold Shld.\n"
				+ "  - S -   L = Lght. Shld\n"
				+ "     R = Redstone \n"
				+ "     S = Surge Shld.\n"
				+ "\nNo offensive spells can affect you, even those that disable shields."));
		
		bookPages.appendTag(new NBTTagString("24", "\n\n\n\n\n   Protection Spells\n"));
		
		bookPages.appendTag(new NBTTagString("24",
				"Wall of Stone (Lvl1)\n"
				+ "  S S S\n"
				+ "  S T S   S = Stone\n"
				+ "  S S S   T = Prot Tab.\n\n"
				+ "Wall of Obsidian (Lvl2)\n"
				+ "  O O O\n"
				+ "  O T O   O = Obsidian\n"
				+ "  O O O   T = Lvl1 Wall\n\n"
				+ "Wall of Bedrock\n"
				+ "  - Q -\n"
				+ "  Q T Q   Q = Quartz\n"
				+ "  - Q -   T = Lvl2 Wall\n\n"));
		bookPages.appendTag(new NBTTagString("25",
				"Push\n\n"
				+ "  - P -   P = Piston\n"
				+ "  O T O   O = Red Tch.\n"
				+ "  - R -   T = Prot Tab.\n"
				+ "     R = Redstone \n"
				+ "\n\nEnemies around you are pushed away. Can not push players."));
		bookPages.appendTag(new NBTTagString("25",
				"Color Spray\n\n"
				+ "  - R -   R = Red\n"
				+ "  B T Y   B = Blue\n"
				+ "  - G -   Y = Yellow\n"
				+ "     G = Green \n"
				+ "     T = Prot Tab.\n"
				+ "\nEnemies in front of you are blinded."));
		bookPages.appendTag(new NBTTagString("25",
				"Blink\n\n"
				+ "  - E -   E = End Pearl\n"
				+ "  G T G   T = Prot Tab.\n"
				+ "  - G -   G = Gla. Pane\n"
				+ "\nYou become invisible for a short time."));
		
		bookPages.appendTag(new NBTTagString("24", "\n\n\n\n\n    Divination Spells\n"));
		
		bookPages.appendTag(new NBTTagString("25",
				"Transport\n\n"
				+ "  R R R \n"
				+ "  R T R   T = Div. Tab.\n"
				+ "  R R R   R = Rail\n"
				+ "\n\nYou are granted super speed for a fraction of a second, allowing you to reach your destination in the blink of an eye."));

		bookPages.appendTag(new NBTTagString("25",
				"Dimension Door\n\n"
				+ "  O O O   O = Obsidian\n"
				+ "  O T O   T = Lvl1 Div.\n"
				+ "  O F O   F = Flnt/Stl.\n"
				+ "\n\nYou create a Nether portal and step inside, only to appear out of the other side a several hundred blocks away."));
		
		bookPages.appendTag(new NBTTagString("24", "\n\n\n\n\n    Mundane Spells\n"));
		
		bookPages.appendTag(new NBTTagString("25",
				"Haste\n\n"
				+ "  - M -  T = Mund Tab.\n"
				+ "  P T R  P = Pwr. Rl.\n"
				+ "  - - -  R = Red Tch\n"
				+ "         M = Minecart"
				+ "\n\nYou can move faster and break blocks faster for a short time."));
		
		bookPages.appendTag(new NBTTagString("25",
				"Advance Time\n\n"
				+ "  - C -  C = Clock\n"
				+ "  R T R  T = Mund. Tab\n"
				+ "  - R -  R = Redstone\n"
				+ "\n\nTime advances by a random amount, making crops grow instantly."));
		
		bookPages.appendTag(new NBTTagString("25",
				"Change Weather\n\n"
				+ "  - W -  W = Water\n"
				+ "  S T S  T = Mund. Tab\n"
				+ "  - F -  F = Yel. Flr.\n"
				+ "         S = Snow Blk."
				+ "\n\nYou manipulate the weather, spawning a torrential downpour or brilliant sunshine."));
		
		bookPages.appendTag(new NBTTagString("25",
				"Flight\n\n"
				+ "  - F -   \n"
				+ "  F T F   T = Mund. Tab\n"
				+ "  - F -   F = Feather\n"
				+ "\n\nYou take flight for 20 seconds. Careful where you land!"));
		
		bookPages.appendTag(new NBTTagString("25",
				"Fish Form\n\n"
				+ "  - F -   F = Raw Fish\n"
				+ "  F T F   T = Lvl1 Div.\n"
				+ "  - W -   W = Water\n"
				+ "\n\nYou can breathe underwater for a short time."));
		
		bookPages.appendTag(new NBTTagString("25",
				"Grease\n\n"
				+ "  F M C   F = Furnace\n"
				+ "  - T -   M = Raw Pork\n"
				+ "  - F -   C = Coal"
				+ "      T = Mund. Tab\n"
				+ "\n\nPigs are turned into cooked porkchops."));
		
		bookPages.appendTag(new NBTTagString("24", "\n\n\n\n\n    Disruption Spells\n"));

		bookPages.appendTag(new NBTTagString("25",
				"Breach (Lvl 1)\n\n"
				+ "  - P -   P = Prot Tab.\n"
				+ "  A T A   T = Dis. Tab.\n"
				+ "  - A -   A = Arrow\n"
				+ "\n\nThe target's spell protections are removed. Can not effect players with Shield of Invulnerability."));

		bookPages.appendTag(new NBTTagString("25",
				"Miscast Magic (Lvl 2)\n\n"
				+ "  - P -   \n"
				+ "  P T P   T = Lvl1 Dis.\n"
				+ "  - P -   P = Blz. Pdr.\n"
				+ "\n\nThe target can no longer cast spells for a short time. Can not effect players with Shield of Invulnerability."));
		
		bookPages.appendTag(new NBTTagString("25",
				"Chaos\n\n"
				+ "  - R -   \n"
				+ "  R T R   R = Blz. Rod\n"
				+ "  - R -   T = Lvl2 Dis.\n"
				+ "\n\nThe target has a high chance of suffering a magical surge. Can not effect players with Shield of Invulnerability."));
		
		bookPages.appendTag(new NBTTagString("24", "\n\n\n\n\n       Misc. Spells\n"));
		
		bookPages.appendTag(new NBTTagString("25",
				"Summon Chest Full of Cookies\n\n"
				+ "  - C -   C = Cookie\n"
				+ "  C T C   T = Blank Tab.\n"
				+ "  - H -   H = Chest\n"
				+ "\n\nTired of farming & hunting? How about COOKIES!!!"));
		
		bookStack.setTagInfo("pages", bookPages);
		bookStack.setTagInfo("author", new NBTTagString("author", "Spellbound"));
		bookStack.setTagInfo("title", new NBTTagString("title", "The Book of Spells"));
		bookStack.itemID = Item.writtenBook.itemID;
		
		return bookStack;
	}

	@Override
	public void onUpdate(ItemStack bookStack, World par2World, Entity par3Entity, int par4, boolean par5)
	{
		NBTTagList bookPages = new NBTTagList("pages");
		
		bookPages.appendTag(new NBTTagString("1", 
				"\n   Table of Contents\n"
				+ "\nMushrooms..........................2"
				+ "\nSpell Basics......................17"
				+ "\nRecipes.................................20"));
		
		bookPages.appendTag(new NBTTagString("2", 
				"       Mushrooms \n\n"
				+ "   Mushrooms are used in the crafting of base spell tablets. \n\nA spellcaster"
				+ "must find and breed mushrooms to produce the mushrooms that can be used in spells."));
		
		bookPages.appendTag(new NBTTagString("3", 
				"There are three types of mushrooms found in the wilderness:"
				+ "\n\n-Red with orange dots"
				+ "\n-Red with pink dots"
				+ "\n-Blue with grey dots"
				+ "\n\nTo breed a mushroom, place it beside a valid mate, and a new hybrid mushroom will eventually form."));
		
		bookPages.appendTag(new NBTTagString("4", 
				"Red Orange Mushroom"
				+ "\n\n+ Pink Orange = Fire or White"
				+ "\n+ Yellow = Rainbow"
				+ "\n\nNotes: Spawns naturally."));
		
		bookPages.appendTag(new NBTTagString("5", 
				"Pink Orange Mushroom"
				+ "\n\n+ Red Orange = Fire or White"
				+ "\n\nNotes: Spawns naturally."));
		
		bookPages.appendTag(new NBTTagString("6", 
				"Blue Grey Mushroom"
				+ "\n+ Grey = Black"
				+ "\n+ Orange Grey = Grey or Cold"
				+ "\n+ Fire = Orange Grey"
				+ "\n\nNotes: Spawns naturally."));
		
		bookPages.appendTag(new NBTTagString("7", 
				"Fire Mushroom"
				+ "\n+ Blue Grey = Orange Grey"
				+ "\n\nNotes: Makes fire tablets."));
		
		bookPages.appendTag(new NBTTagString("8", 
				"White Mushroom"
				+ "\n\nNotes: Breeds with all other mushrooms, making either the same color or another white mushroom."));
		
		bookPages.appendTag(new NBTTagString("9", 
				"Orange Grey Mushroom"
				+ "\n+ Blue Grey = Grey or Cold"
				+ "\n\nNotes: N/A"));
		
		bookPages.appendTag(new NBTTagString("10", 
				"Cold Mushroom"
				+ "\nNo mates!"
				+ "\n\nNotes: Makes cold tablets."));
		
		bookPages.appendTag(new NBTTagString("11", 
				"Grey Mushroom"
				+ "\n+ Orange Grey = Lightning"
				+ "\n+ Blue Grey = Black"
				+ "\n+ Rainbow = Purple"
				+ "\n\nNotes: N/A"));
		
		bookPages.appendTag(new NBTTagString("12", 
				"Lightning Mushroom"
				+ "\n+ Rainbow = Gold"
				+ "\n+ Red Orange = Rainbow"
				+ "\n\nNotes: Makes lightning tablets."));
		
		bookPages.appendTag(new NBTTagString("13", 
				"Rainbow Mushroom"
				+ "\n+ Yellow = Gold"
				+ "\n+ Grey = Purple"
				+ "\n\nNotes: N/A"));
		
		bookPages.appendTag(new NBTTagString("14", 
				"Gold Mushroom"
				+ "\nNo mates!"
				+ "\n\nNotes: N/A"));
		
		bookPages.appendTag(new NBTTagString("15", 
				"Black Mushroom"
				+ "\nNo mates!"
				+ "\n\nNotes: N/A"));
		
		bookPages.appendTag(new NBTTagString("16", 
				"\n\n\n\n\n       Spell Basics"));

		bookPages.appendTag(new NBTTagString("17", 
				"Spells are made and cast by crafting spell tablets."
				+ "\n\nSpell tablets begin with a blank tablet. \n\n"
				+ "BLANK TABLET"
				+ "\n           - C -"
				+ "\n           C - C"
				+ "\n           - C - "
				+ "\nWhere 'C' is a ball of clay."));
		
		bookPages.appendTag(new NBTTagString("18", 
				"Casting spells is easy. Simply right-click with a spell to allow it to charge."
				+ "\n\nEach spell has a specified charge time. You will hear a *ping!* when the spell is ready to fire. \n\nRelease the mouse button to do so."));
		
		bookPages.appendTag(new NBTTagString("19", 
				"Be warned, magic energy is unstable. Sometimes, your spell will turn into a magical surge.\n\n"
				+ "Magical surges are often devastating to the environment and caster.\n\n"
				+ "There's a reason why surges are undocumented..."));
		
		bookPages.appendTag(new NBTTagString("20", 
				"\n\n\n\n\n           Recipes"));
		
		bookPages.appendTag(new NBTTagString("21", "       Spell Tablets\n\n"
				+ "Fire Tablet\n"
				+ "  - F -\n"
				+ "  F T F   F = Fire Msh.\n"
				+ "  - F -   T = Blank Tab.\n\n"
				+ "Cold Tablet\n"
				+ "  - C -\n"
				+ "  C T C   C = Cold Msh.\n"
				+ "  - C -   T = Blank Tab.\n\n"));
		
		bookPages.appendTag(new NBTTagString("22",
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

		bookPages.appendTag(new NBTTagString("23",
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
		
		bookPages.appendTag(new NBTTagString("24", "\n\n\n\n\n        Fire Spells\n"));
		
		bookPages.appendTag(new NBTTagString("24",
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
		bookPages.appendTag(new NBTTagString("25",
				"Fire Shield (Lvl1)\n"
				+ "  B B B\n"
				+ "  B T B   B = Blank Tab.\n"
				+ "  - B -   T = Fire Tab.\n\n"
				+ "Protects from fire and fire spells."));
		
		bookPages.appendTag(new NBTTagString("24", "\n\n\n\n\n        Cold Spells\n"));
		
		bookPages.appendTag(new NBTTagString("24",
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
		bookPages.appendTag(new NBTTagString("25",
				"Cold Shield (Lvl1)\n"
				+ "  B B B\n"
				+ "  B C B   B = Blank Tab.\n"
				+ "  - B -   T = Cold Tab.\n\n"
				+ "Protects from cold spells."));
		
		bookPages.appendTag(new NBTTagString("24", "\n\n\n\n\n     Lightning Spells\n"));
		
		bookPages.appendTag(new NBTTagString("24",
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
		bookPages.appendTag(new NBTTagString("25",
				"Lightning Shield (Lvl1)\n"
				+ "  B B B\n"
				+ "  B C B   B = Blank Tab.\n"
				+ "  - B -   T = Lght. Tab.\n\n"
				+ "Protects from lightning spells."));
		
		bookPages.appendTag(new NBTTagString("24", "\n\n\n\n\n   Ultimate Spells\n"));
		
		bookPages.appendTag(new NBTTagString("25",
				"Wail of the Banshee\n\n"
				+ "  - F -   F = Lvl3 Fire\n"
				+ "  C R L   C = Lvl3 Cold.\n"
				+ "  - E -   L = Lvl3 Lght.\n"
				+ "     R = Redstone \n"
				+ "     E = Ender Chest\n"
				+ "\nEnergies release from the ender chest with a horrifying scream. All enemies in the area die."));

		bookPages.appendTag(new NBTTagString("25",
				"Elemental Fury\n\n"
				+ "  - F -   F = Lvl3 Fire\n"
				+ "  C R L   C = Lvl3 Cold.\n"
				+ "  - - -   L = Lvl3 Lght.\n"
				+ "     R = Redstone \n"
				+ "\nAll Lvl 3 elemental spells combine into one large explosion of energy."));
		
		bookPages.appendTag(new NBTTagString("25",
				"Disintegrate\n\n"
				+ "  - F -   F = Lvl3 Fire\n"
				+ "  C R L   C = Lvl3 Cold.\n"
				+ "  - L -   L = Lvl3 Lght.\n"
				+ "     R = Redstone \n"
				+ "     L = Lava\n"
				+ "\nEnemies turn into bone meal or catch fire."));
		
		bookPages.appendTag(new NBTTagString("25",
				"Shield of Invulnerability\n\n"
				+ "  - F -   F = Fire Shld.\n"
				+ "  C R L   C = Cold Shld.\n"
				+ "  - S -   L = Lght. Shld\n"
				+ "     R = Redstone \n"
				+ "     S = Surge Shld.\n"
				+ "\nNo offensive spells can affect you, even those that disable shields."));
		
		bookPages.appendTag(new NBTTagString("24", "\n\n\n\n\n   Protection Spells\n"));
		
		bookPages.appendTag(new NBTTagString("24",
				"Wall of Stone (Lvl1)\n"
				+ "  S S S\n"
				+ "  S T S   S = Stone\n"
				+ "  S S S   T = Prot Tab.\n\n"
				+ "Wall of Obsidian (Lvl2)\n"
				+ "  O O O\n"
				+ "  O T O   O = Obsidian\n"
				+ "  O O O   T = Lvl1 Wall\n\n"
				+ "Wall of Bedrock\n"
				+ "  - Q -\n"
				+ "  Q T Q   Q = Quartz\n"
				+ "  - Q -   T = Lvl2 Wall\n\n"));
		bookPages.appendTag(new NBTTagString("25",
				"Push\n\n"
				+ "  - P -   P = Piston\n"
				+ "  O T O   O = Red Tch.\n"
				+ "  - R -   T = Prot Tab.\n"
				+ "     R = Redstone \n"
				+ "\n\nEnemies around you are pushed away. Can not push players."));
		bookPages.appendTag(new NBTTagString("25",
				"Color Spray\n\n"
				+ "  - R -   R = Red\n"
				+ "  B T Y   B = Blue\n"
				+ "  - G -   Y = Yellow\n"
				+ "     G = Green \n"
				+ "     T = Prot Tab.\n"
				+ "\nEnemies in front of you are blinded."));
		bookPages.appendTag(new NBTTagString("25",
				"Blink\n\n"
				+ "  - E -   E = End Pearl\n"
				+ "  G T G   T = Prot Tab.\n"
				+ "  - G -   G = Gla. Pane\n"
				+ "\nYou become invisible for a short time."));
		
		bookPages.appendTag(new NBTTagString("24", "\n\n\n\n\n    Divination Spells\n"));
		
		bookPages.appendTag(new NBTTagString("25",
				"Transport\n\n"
				+ "  R R R \n"
				+ "  R T R   T = Div. Tab.\n"
				+ "  R R R   R = Rail\n"
				+ "\n\nYou are granted super speed for a fraction of a second, allowing you to reach your destination in the blink of an eye."));

		bookPages.appendTag(new NBTTagString("25",
				"Dimension Door\n\n"
				+ "  O O O   O = Obsidian\n"
				+ "  O T O   T = Lvl1 Div.\n"
				+ "  O F O   F = Flnt/Stl.\n"
				+ "\n\nYou create a Nether portal and step inside, only to appear out of the other side a several hundred blocks away."));
		
		bookPages.appendTag(new NBTTagString("24", "\n\n\n\n\n    Mundane Spells\n"));
		
		bookPages.appendTag(new NBTTagString("25",
				"Haste\n\n"
				+ "  - M -  T = Mund Tab.\n"
				+ "  P T R  P = Pwr. Rl.\n"
				+ "  - - -  R = Red Tch\n"
				+ "         M = Minecart"
				+ "\n\nYou can move faster and break blocks faster for a short time."));
		
		bookPages.appendTag(new NBTTagString("25",
				"Advance Time\n\n"
				+ "  - C -  C = Clock\n"
				+ "  R T R  T = Mund. Tab\n"
				+ "  - R -  R = Redstone\n"
				+ "\n\nTime advances by a random amount, making crops grow instantly."));
		
		bookPages.appendTag(new NBTTagString("25",
				"Change Weather\n\n"
				+ "  - W -  W = Water\n"
				+ "  S T S  T = Mund. Tab\n"
				+ "  - F -  F = Yel. Flr.\n"
				+ "         S = Snow Blk."
				+ "\n\nYou manipulate the weather, spawning a torrential downpour or brilliant sunshine."));
		
		bookPages.appendTag(new NBTTagString("25",
				"Flight\n\n"
				+ "  - F -   \n"
				+ "  F T F   T = Mund. Tab\n"
				+ "  - F -   F = Feather\n"
				+ "\n\nYou take flight for 20 seconds. Careful where you land!"));
		
		bookPages.appendTag(new NBTTagString("25",
				"Fish Form\n\n"
				+ "  - F -   F = Raw Fish\n"
				+ "  F T F   T = Lvl1 Div.\n"
				+ "  - W -   W = Water\n"
				+ "\n\nYou can breathe underwater for a short time."));
		
		bookPages.appendTag(new NBTTagString("25",
				"Grease\n\n"
				+ "  F M C   F = Furnace\n"
				+ "  - T -   M = Raw Pork\n"
				+ "  - F -   C = Coal"
				+ "      T = Mund. Tab\n"
				+ "\n\nPigs are turned into cooked porkchops."));
		
		bookPages.appendTag(new NBTTagString("24", "\n\n\n\n\n    Disruption Spells\n"));

		bookPages.appendTag(new NBTTagString("25",
				"Breach (Lvl 1)\n\n"
				+ "  - P -   P = Prot Tab.\n"
				+ "  A T A   T = Dis. Tab.\n"
				+ "  - A -   A = Arrow\n"
				+ "\n\nThe target's spell protections are removed. Can not effect players with Shield of Invulnerability."));

		bookPages.appendTag(new NBTTagString("25",
				"Miscast Magic (Lvl 2)\n\n"
				+ "  - P -   \n"
				+ "  P T P   T = Lvl1 Dis.\n"
				+ "  - P -   P = Blz. Pdr.\n"
				+ "\n\nThe target can no longer cast spells for a short time. Can not effect players with Shield of Invulnerability."));
		
		bookPages.appendTag(new NBTTagString("25",
				"Chaos\n\n"
				+ "  - R -   \n"
				+ "  R T R   R = Blz. Rod\n"
				+ "  - R -   T = Lvl2 Dis.\n"
				+ "\n\nThe target has a high chance of suffering a magical surge. Can not effect players with Shield of Invulnerability."));
		
		bookPages.appendTag(new NBTTagString("24", "\n\n\n\n\n       Misc. Spells\n"));
		
		bookPages.appendTag(new NBTTagString("25",
				"Summon Chest Full of Cookies\n\n"
				+ "  - C -   C = Cookie\n"
				+ "  C T C   T = Blank Tab.\n"
				+ "  - H -   H = Chest\n"
				+ "\n\nTired of farming & hunting? How about COOKIES!!!"));
		
		bookStack.setTagInfo("pages", bookPages);
		bookStack.setTagInfo("author", new NBTTagString("author", "Spellbound"));
		bookStack.setTagInfo("title", new NBTTagString("title", "The Book of Spells"));
		bookStack.itemID = Item.writtenBook.itemID;
	}
}
