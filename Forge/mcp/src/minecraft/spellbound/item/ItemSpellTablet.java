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
	
	public ItemSpellTablet(int itemId, AbstractEffect spellEffect)
	{
		super(itemId);
		this.spellEffect = spellEffect;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List infoList, boolean unknown) 
	{
		super.addInformation(itemStack, entityPlayer, infoList, unknown);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack itemStack, int renderPass)
	{
		return true;
	}
}