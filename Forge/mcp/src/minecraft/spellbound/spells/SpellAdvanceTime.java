/**********************************************
 * SpellAdvanceTime.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.spells;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import spellbound.core.Constants;
import spellbound.core.SpellboundCore;
import spellbound.core.util.Point3D;
import spellbound.core.util.Logic;
import spellbound.enums.EnumItemInUseTime;
import spellbound.enums.EnumSpellRange;

public class SpellAdvanceTime extends AbstractSpell
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Advance Time";
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		caster.worldObj.playSoundAtEntity(caster, "mob.wither.idle", 1.0F, 1.0F);
		
		if (!caster.worldObj.isRemote)
		{
			final long newWorldTime = caster.worldObj.getWorldTime() + SpellboundCore.modRandom.nextInt(5000) + 5000;
			caster.worldObj.setWorldTime(newWorldTime);

			for (final int cropID : Constants.CROP_IDS)
			{
				for (final Point3D point : Logic.getNearbyBlocks(caster.worldObj, (int)caster.posX, (int)caster.posY, (int)caster.posZ, Constants.RAD_ADVANCETIME, cropID))
				{
					caster.worldObj.setBlockMetadataWithNotify(point.posX, point.posY, point.posZ, 7, 2);
				}
			}
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
		return EnumItemInUseTime.THREE_SECONDS;
	}
}
