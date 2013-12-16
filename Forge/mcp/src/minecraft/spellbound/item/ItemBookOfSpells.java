package spellbound.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemEditableBook;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import spellbound.core.SpellboundCore;

public class ItemBookOfSpells extends ItemEditableBook
{
	public ItemBookOfSpells(int itemId) 
	{
		super(itemId);
		this.setCreativeTab(SpellboundCore.instance.spellboundTab);
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
}
