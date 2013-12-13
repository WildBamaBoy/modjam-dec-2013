package spellbound.item;

import java.util.List;

import spellbound.effects.AbstractEffect;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemSpellTablet extends SBItem
{
	public final AbstractEffect spellEffect;
	public final int level;
	
	public ItemSpellTablet(int itemId, String unlocalizedName, AbstractEffect spellEffect, int level)
	{
		super(itemId, unlocalizedName, spellEffect.getSpellDisplayName());
		this.spellEffect = spellEffect;
		this.level = level;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack itemStack, int renderPass)
	{
		return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List infoList, boolean unknown) 
	{
		infoList.add("Lvl. " + level + "\n" +
					"@(" + spellEffect.getSpellType() + ")");
	}
}
