/**********************************************
 * SpellLightningLvl1.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.spells;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import spellbound.core.SpellboundCore;
import spellbound.entity.EntityTargetSpellLightning;
import spellbound.enums.EnumItemInUseTime;
import spellbound.enums.EnumSpellRange;

public class SpellLightningLvl1 extends AbstractSpell
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Tazer";
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		caster.worldObj.playSoundAtEntity(caster, "mob.ghast.fireball", 1.0F, 1.0F);
		caster.worldObj.spawnEntityInWorld(new EntityTargetSpellLightning(caster, this));
	}

	@Override
	public EnumSpellRange getSpellType() 
	{
		return EnumSpellRange.TARGET;
	}

	@Override
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit) 
	{
		if (entityHit != null)
		{
			if (entityHit instanceof EntityPlayer)
			{
				if (!SpellboundCore.getInstance().playerHasActiveSpell((EntityPlayer)entityHit, SpellShieldOfInvulnerability.class) && !SpellboundCore.getInstance().playerHasActiveSpell((EntityPlayer)entityHit, SpellLightningShield.class))
				{							
					entityHit.attackEntityFrom(DamageSource.magic, 5.0F);
					entityHit.addPotionEffect(new PotionEffect(Potion.confusion.id, 1200));					
				}
			}

			else
			{
				entityHit.attackEntityFrom(DamageSource.magic, 5.0F);
				entityHit.addPotionEffect(new PotionEffect(Potion.confusion.id, 1200));
			}
		}
	}

	@Override
	public EnumItemInUseTime getSpellCastDuration() 
	{
		return EnumItemInUseTime.ONE_SECOND;
	}
}
