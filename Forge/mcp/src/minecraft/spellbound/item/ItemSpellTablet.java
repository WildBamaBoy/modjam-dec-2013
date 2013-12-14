package spellbound.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import spellbound.effects.AbstractEffect;
import spellbound.util.Color;
import cpw.mods.fml.common.FMLCommonHandler;
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

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) 
	{
		if (!par3EntityPlayer.worldObj.isRemote)
		{
			spellEffect.doSpellEffect(par3EntityPlayer);
			par3EntityPlayer.addChatMessage("You have cast: " + spellEffect.getSpellDisplayName() + ".");
		}

		return super.onItemRightClick(par1ItemStack, par2World, par3EntityPlayer);
	}
}
