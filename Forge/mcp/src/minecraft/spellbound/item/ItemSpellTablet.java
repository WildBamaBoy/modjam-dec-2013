/**********************************************
 * ItemSpellTablet.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import spellbound.core.Constants;
import spellbound.core.SpellboundCore;
import spellbound.enums.EnumItemInUseTime;
import spellbound.spells.AbstractSpell;
import spellbound.spells.SpellArchmagic;
import spellbound.spells.SpellMiscastMagic;
import spellbound.surges.AbstractSurge;
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
		infoList.add(Constants.COLOR_BLUE + "Lvl. " + level);
		infoList.add(Constants.COLOR_BLUE + "@(" + spell.getSpellType() + ")");
		infoList.add(Constants.COLOR_BLUE + "Cast Time: " + spell.getSpellCastDuration().getDisplayString());
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
		if (!entityPlayer.capabilities.isCreativeMode && !SpellboundCore.getInstance().entityHasActiveSpell(entityPlayer, SpellArchmagic.class))
		{
			entityPlayer.worldObj.playSoundAtEntity(entityPlayer, spell.getSpellChargeSound(), 1.0F, 1.0F);
		}
		entityPlayer.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
		return super.onItemRightClick(itemStack, worldObj, entityPlayer);
	}

	@Override
	public void onUsingItemTick(ItemStack stack, EntityPlayer player, int count) 
	{
		super.onUsingItemTick(stack, player, count);

		final int castDuration = SpellboundCore.getInstance().entityHasActiveSpell(player, SpellArchmagic.class) ? EnumItemInUseTime.INSTANT.getValue() : spell.getSpellCastDuration().getValue();
		if (count == getMaxItemUseDuration(stack) - castDuration && !player.capabilities.isCreativeMode)
		{
			player.worldObj.playSoundAtEntity(player, "random.orb", 1.0F, 1.0F);
		}
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack itemStack, World worldObj, EntityPlayer entityPlayer, int inUseCount)
	{
		final int castDuration = SpellboundCore.getInstance().entityHasActiveSpell(entityPlayer, SpellArchmagic.class) ? EnumItemInUseTime.INSTANT.getValue() : spell.getSpellCastDuration().getValue();

		if (inUseCount <= getMaxItemUseDuration(itemStack) - castDuration || entityPlayer.capabilities.isCreativeMode)
		{
			if (!entityPlayer.capabilities.isCreativeMode)
			{
				entityPlayer.inventory.decrStackSize(entityPlayer.inventory.currentItem, 1);
			}

			if (!worldObj.isRemote)
			{
				final AbstractSurge surge = spell.doMagicSurge(entityPlayer);

				if (SpellboundCore.getInstance().entityHasActiveSpell(entityPlayer, SpellMiscastMagic.class))
				{
					SpellboundCore.getInstance().sendMessageToPlayer(entityPlayer, "You're under the effects of Miscast Magic!");
				}

				else if (surge == null)
				{
					spell.caster = entityPlayer;
					spell.doSpellCasterEffect(entityPlayer);
				}

				else
				{
					SpellboundCore.getInstance().sendMessageToPlayer(entityPlayer, "Magic surge! " + surge.getSpellDisplayName());
					surge.doSpellCasterEffect(entityPlayer);
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
