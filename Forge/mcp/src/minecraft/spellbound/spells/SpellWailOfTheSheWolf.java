/**********************************************
 * SpellWailOfTheSheWolf.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.spells;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import spellbound.core.SpellboundCore;
import spellbound.enums.EnumItemInUseTime;
import spellbound.enums.EnumSpellRange;

public class SpellWailOfTheSheWolf extends AbstractSpell
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Wail of the She Wolf";
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		caster.worldObj.playSoundAtEntity(caster, "mob.wither.idle", 1.0F, 1.0F);
		caster.worldObj.playSoundAtEntity(caster, "spellbound:banshee", 1.0F, 1.0F);

		final List<Entity> entitiesInArea = caster.worldObj.getEntitiesWithinAABBExcludingEntity(caster, AxisAlignedBB.getBoundingBox(caster.posX - 20, caster.posY - 20, caster.posZ - 20, caster.posX + 20, caster.posY + 20, caster.posZ + 20));

		for (final Entity entity : entitiesInArea)
		{
			if (entity instanceof EntityLivingBase && !(entity instanceof EntityPlayer))
			{
				entity.attackEntityFrom(DamageSource.magic, 500.0F);
			}

			else if (entity instanceof EntityPlayer && !SpellboundCore.getInstance().entityHasActiveSpell(caster, SpellShieldOfInvulnerability.class))
			{
				entity.attackEntityFrom(DamageSource.magic, 500.0F);
			}
		}
	}

	@Override
	public EnumSpellRange getSpellType() 
	{
		return EnumSpellRange.AREA;
	}

	@Override
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit) 
	{
		//No target effect.
	}

	@Override
	public EnumItemInUseTime getSpellCastDuration() 
	{
		return EnumItemInUseTime.FIVE_SECONDS;
	}
}
