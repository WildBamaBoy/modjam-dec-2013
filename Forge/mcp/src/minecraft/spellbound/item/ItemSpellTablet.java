package spellbound.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import spellbound.effects.AbstractEffect;
import spellbound.util.Color;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

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
		infoList.add(Color.BLUE + "Lvl. " + level);
		infoList.add(Color.BLUE + "@(" + spellEffect.getSpellType() + ")");
	}
}
