package spellbound.item;

import spellbound.core.SpellboundCore;
import net.minecraft.item.ItemEditableBook;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;

public class ItemBookOfSpells extends ItemEditableBook
{
	public ItemBookOfSpells(int itemId) 
	{
		super(itemId);
		this.setCreativeTab(SpellboundCore.instance.spellboundTab);
	}
	
	public static void addBookInfoToStack(ItemStack bookStack)
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
	}
}
