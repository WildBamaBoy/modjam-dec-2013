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

		bookPages.appendTag(new NBTTagString("1", 
				"\n   Table of Contents\n"
				+ "\nMushrooms..........................2"
				+ "\nSpell Basics.......................x"
				+ "\nRecipes..................................x"
				+ "\nSurges...................................x"));
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
				"Light Blue Mushroom"
				+ "\nNo mates!"
				+ "\n\nNotes: Makes cold tablets."));
		
		bookPages.appendTag(new NBTTagString("11", 
				"Grey Mushroom"
				+ "\n+ Orange Grey = Grey or Cold"
				+ "\n+ Blue Grey = Orange Grey"
				+ "\n\nNotes: Makes cold tablets."));
		bookPages.appendTag(new NBTTagString("12", 
				"Lightning Mushroom"
				+ "\n+ Grey = Black"
				+ "\n+ Orange Grey = Grey or Cold"
				+ "\n+ Orange = Orange Grey"
				+ "\n\nNotes: Makes cold tablets."));
		bookPages.appendTag(new NBTTagString("13", 
				"Rainbow Mushroom"
				+ "\n+ Grey = Black"
				+ "\n+ Orange Grey = Grey or Cold"
				+ "\n+ Orange = Orange Grey"
				+ "\n\nNotes: Makes cold tablets."));
		bookPages.appendTag(new NBTTagString("14", 
				"Gold Mushroom"
				+ "\n+ Grey = Black"
				+ "\n+ Orange Grey = Grey or Cold"
				+ "\n+ Orange = Orange Grey"
				+ "\n\nNotes: Makes cold tablets."));
		bookPages.appendTag(new NBTTagString("10", 
				"Black Mushroom"
				+ "\n+ Grey = Black"
				+ "\n+ Orange Grey = Grey or Cold"
				+ "\n+ Orange = Orange Grey"
				+ "\n\nNotes: Makes cold tablets."));
		
		bookPages.appendTag(new NBTTagString("5", 
				"\n\n\n\n\n       Spell Basics"));

		bookPages.appendTag(new NBTTagString("6", 
				"Spells are made and cast by crafting spell tablets."
				+ "\n\nSpell tablets begin with a blank tablet. \n\n"
				+ "BLANK TABLET"
				+ "\n           - C -"
				+ "\n           C - C"
				+ "\n           - C - "
				+ "\nWhere 'C' is a ball of clay."));
		bookPages.appendTag(new NBTTagString("3", "Content pg3"));
		bookPages.appendTag(new NBTTagString("4", "Content pg4"));
		bookPages.appendTag(new NBTTagString("5", "Content pg5"));
		
		par1ItemStack.setTagInfo("pages", bookPages);
		par1ItemStack.setTagInfo("author", new NBTTagString("author", "Spellbound"));
		par1ItemStack.setTagInfo("title", new NBTTagString("title", "The Book of Spells"));
		par1ItemStack.itemID = Item.writtenBook.itemID;
	}
}
