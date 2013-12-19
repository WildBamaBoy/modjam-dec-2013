/**********************************************
 * SpellSummonChestFullOfCookies.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.spells;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import spellbound.core.SpellboundCore;
import spellbound.core.util.Point3D;
import spellbound.core.util.Logic;
import spellbound.enums.EnumItemInUseTime;
import spellbound.enums.EnumSpellRange;

public class SpellSummonChestFullOfCookies extends AbstractSpell 
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Summon Chest Full of Cookies";
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		caster.worldObj.playSoundAtEntity(caster, "random.burp", 1.0F, 1.0F);

		for (final Point3D point : Logic.getNearbyBlocks(caster.worldObj, (int)caster.posX, (int)caster.posY, (int)caster.posZ, 5, 0))
		{
			if (caster.worldObj.getBlockId(point.posX, point.posY - 1, point.posZ) != 0 && SpellboundCore.modRandom.nextBoolean()) 
			{
				caster.worldObj.setBlock(point.posX, point.posY, point.posZ, Block.chest.blockID);
				final IInventory inventory = Block.chest.getInventory(caster.worldObj, point.posX, point.posY, point.posZ);

				for (int i = 0; i < inventory.getSizeInventory(); i++)
				{
					inventory.setInventorySlotContents(i, new ItemStack(Item.cookie, 64, 0));
				}

				break;
			}
		}
	}

	@Override
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit) 
	{
		//No target effect.
	}

	@Override
	public EnumSpellRange getSpellType() 
	{
		return EnumSpellRange.SELF;
	}

	@Override
	public EnumItemInUseTime getSpellCastDuration() 
	{
		return EnumItemInUseTime.FIVE_SECONDS;
	}
}
