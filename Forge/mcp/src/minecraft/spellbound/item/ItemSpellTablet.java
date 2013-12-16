package spellbound.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import spellbound.spells.AbstractSpell;
import spellbound.util.Color;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSpellTablet extends SpellboundItem
{
	public final AbstractSpell spell;
	public final int level;

	public ItemSpellTablet(int itemId, String unlocalizedName, AbstractSpell spell, int level)
	{
		super(itemId, unlocalizedName, spell.getSpellDisplayName());
		this.spell = spell;
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
		infoList.add(Color.BLUE + "@(" + spell.getSpellType() + ")");
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World worldObj, EntityPlayer entityPlayer) 
	{
		if (worldObj.isRemote)
		{
			entityPlayer.addChatMessage("You have cast: " + spell.getSpellDisplayName() + ".");
		}

		spell.doSpellCasterEffect(entityPlayer);
		return super.onItemRightClick(itemStack, worldObj, entityPlayer);
	}
}
