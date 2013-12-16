package spellbound.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import spellbound.core.SpellboundCore;
import spellbound.spells.AbstractSpell;
import spellbound.spells.AbstractSurge;
import spellbound.util.Color;
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
		infoList.add(Color.BLUE + "Cast Time: " + spell.getSpellCastDuration().getDisplayString());
	}

	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		return par1ItemStack;
	}

	public int getMaxItemUseDuration(ItemStack par1ItemStack)
	{
		return 72000;
	}

	public EnumAction getItemUseAction(ItemStack itemStack)
	{
		return EnumAction.bow;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World worldObj, EntityPlayer entityPlayer) 
	{
		entityPlayer.worldObj.playSoundAtEntity(entityPlayer, spell.getSpellChargeSound(), 1.0F, 1.0F);
		entityPlayer.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
		return super.onItemRightClick(itemStack, worldObj, entityPlayer);
	}

	@Override
	public void onUsingItemTick(ItemStack stack, EntityPlayer player, int count) 
	{
		super.onUsingItemTick(stack, player, count);

		if (count == getMaxItemUseDuration(stack) - spell.getSpellCastDuration().getValue())
		{
			player.worldObj.playSoundAtEntity(player, "random.orb", 1.0F, 1.0F);
		}
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack itemStack, World worldObj, EntityPlayer entityPlayer, int inUseCount)
	{
		if (inUseCount <= getMaxItemUseDuration(itemStack) - spell.getSpellCastDuration().getValue())
		{
			entityPlayer.inventory.decrStackSize(entityPlayer.inventory.currentItem, 1);
			
			if (!worldObj.isRemote)
			{
				AbstractSurge surge = spell.doMagicSurge(entityPlayer);
				
				if (SpellboundCore.instance.playerHasActiveSpell(entityPlayer, "SpellMiscastMagic"))
				{
					SpellboundCore.instance.sendMessageToPlayer(entityPlayer, "You're under the effects of Miscast Magic!");
				}
				
				else if (surge != null)
				{
					SpellboundCore.instance.sendMessageToPlayer(entityPlayer, "Magic surge! " + surge.getSpellDisplayName());
				}
				
				else
				{
					spell.doSpellCasterEffect(entityPlayer);
				}
			}
			
			super.onPlayerStoppedUsing(itemStack, worldObj, entityPlayer, inUseCount);
		}
		
		else
		{
			entityPlayer.worldObj.playSoundAtEntity(entityPlayer, "fire.ignite", 1.0F, 1.0F);
		}
	}
}
