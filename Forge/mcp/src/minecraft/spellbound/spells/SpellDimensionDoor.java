/**********************************************
 * SpellDimensionDoor.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.spells;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import spellbound.core.SpellboundCore;
import spellbound.enums.EnumItemInUseTime;
import spellbound.enums.EnumSpellRange;

public class SpellDimensionDoor extends AbstractSpell
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Dimension Door";
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		caster.worldObj.playSoundAtEntity(caster, "mob.endermen.portal", 1.0F, 1.0F);

		if (!caster.worldObj.isRemote)
		{
			final int heading = MathHelper.floor_double((double)(caster.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			final int transportAmount = SpellboundCore.modRandom.nextInt(200) + 100;

			double newPlayerX = 0.0D;
			double newPlayerY = 0.0D;
			double newPlayerZ = 0.0D;

			if (heading == 0)
			{
				newPlayerX = caster.posX;
				newPlayerY = 255;
				newPlayerZ = caster.posZ + transportAmount;
			}

			else if (heading == 1)
			{
				newPlayerX = caster.posX - transportAmount;
				newPlayerY = 255;
				newPlayerZ = caster.posZ;
			}

			else if (heading == 2)
			{
				newPlayerX = caster.posX;
				newPlayerY = 255;
				newPlayerZ = caster.posZ - transportAmount;
			}

			else if (heading == 3)
			{
				newPlayerX = caster.posX + transportAmount;
				newPlayerY = 255;
				newPlayerZ = caster.posZ;
			}

			while (caster.worldObj.getBlockId((int)newPlayerX, (int)newPlayerY, (int)newPlayerZ) == 0 && newPlayerY != 0)
			{
				newPlayerY--;
			}

			final EntityPlayerMP casterMP = (EntityPlayerMP)caster;
			casterMP.mountEntity((Entity)null);
			casterMP.playerNetServerHandler.setPlayerLocation(newPlayerX, newPlayerY + 1, newPlayerZ, caster.rotationYaw, caster.rotationPitch);
			caster.worldObj.playSoundAtEntity(casterMP, "mob.endermen.portal", 1.0F, 1.0F);
		}
	}

	@Override
	public EnumSpellRange getSpellType() 
	{
		return EnumSpellRange.SELF;
	}

	@Override
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit) 
	{
		//No target effect.
	}
	
	@Override
	public EnumItemInUseTime getSpellCastDuration() 
	{
		return EnumItemInUseTime.FOUR_SECONDS;
	}
}
