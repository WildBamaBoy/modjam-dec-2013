/**********************************************
 * SpellFireLvl2.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.spells;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import spellbound.core.SpellboundCore;
import spellbound.entity.EntityTargetSpellFire;
import spellbound.enums.EnumItemInUseTime;
import spellbound.enums.EnumSpellRange;

public class SpellFireLvl2 extends AbstractSpell
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Fireball";
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		caster.worldObj.playSoundAtEntity(caster, "mob.ghast.fireball", 1.0F, 1.0F);
		caster.worldObj.spawnEntityInWorld(new EntityTargetSpellFire(caster, this));
	}

	@Override
	public EnumSpellRange getSpellType() 
	{
		return EnumSpellRange.TARGET;
	}

	@Override
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit) 
	{
		if (entityHit == null)
		{
			worldObj.createExplosion(null, (double)posX, (double)posY, (double)posZ, 3.0F, true);
		}

		else
		{
			if (entityHit instanceof EntityPlayer)
			{
				if (!SpellboundCore.getInstance().playerHasActiveSpell((EntityPlayer)entityHit, SpellShieldOfInvulnerability.class) && !SpellboundCore.getInstance().playerHasActiveSpell((EntityPlayer)entityHit, SpellFireShield.class))
				{
					worldObj.createExplosion(entityHit, (double)posX, (double)posY, (double)posZ, 3.0F, true);
				}
			}

			else
			{
				entityHit.attackEntityFrom(DamageSource.magic, 5.0F);
				worldObj.createExplosion(entityHit, entityHit.posX, entityHit.posY, entityHit.posZ, 3.0F, true);
			}
		}
	}

	@Override
	public EnumItemInUseTime getSpellCastDuration() 
	{
		return EnumItemInUseTime.TWO_SECONDS;
	}
}
