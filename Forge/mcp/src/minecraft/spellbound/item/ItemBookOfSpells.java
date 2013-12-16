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
		
		bookPages.appendTag(new NBTTagString("1", "Content pg1"));
		bookPages.appendTag(new NBTTagString("2", "Content pg2"));
		bookPages.appendTag(new NBTTagString("3", "Content pg3"));
		bookPages.appendTag(new NBTTagString("4", "Content pg4"));
		bookPages.appendTag(new NBTTagString("5", "Content pg5"));
		
		bookStack.setTagInfo("pages", bookPages);
		bookStack.setTagInfo("author", new NBTTagString("author", "Spellbound"));
		bookStack.setTagInfo("title", new NBTTagString("title", "The Book of Spells"));
		bookStack.itemID = Item.writtenBook.itemID;
		
		return bookStack;
	}

	@Override
	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5)
	{
		NBTTagList bookPages = new NBTTagList("pages");

		bookPages.appendTag(new NBTTagString("25",
				"Elemental Fury\n\n"
				+ "  - F -   F = Lvl3 Fire\n"
				+ "  C R L   C = Lvl3 Cold.\n"
				+ "  - - -   L = Lvl3 Lght.\n"
				+ "     R = Redstone \n"
				+ "\nAll Lvl 3 elemental spells combine into one large explosion"
				+ "of energy."));
		
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
				+ "\n\nNotes: N/A"));
		
		bookPages.appendTag(new NBTTagString("12", 
				"Lightning Mushroom"
				+ "\n+ Rainbow = Gold"
				+ "\n+ Red Orange = Rainbow"
				+ "\n\nNotes: Makes lightning tablets."));
		
		bookPages.appendTag(new NBTTagString("13", 
				"Rainbow Mushroom"
				+ "\n+ Yellow = Gold"
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

		
		par1ItemStack.setTagInfo("pages", bookPages);
		par1ItemStack.setTagInfo("author", new NBTTagString("author", "Spellbound"));
		par1ItemStack.setTagInfo("title", new NBTTagString("title", "The Book of Spells"));
		par1ItemStack.itemID = Item.writtenBook.itemID;
	}
}
