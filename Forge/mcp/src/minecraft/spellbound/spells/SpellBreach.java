/**********************************************
 * SpellBreach.java
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
import spellbound.core.SpellboundCore;
import spellbound.entity.EntityTargetSpellDisruption;
import spellbound.enums.EnumItemInUseTime;
import spellbound.enums.EnumSpellRange;

public class SpellBreach extends AbstractSpell
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Breach";
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		caster.worldObj.playSoundAtEntity(caster, "mob.ghast.fireball", 1.0F, 1.0F);
		caster.worldObj.spawnEntityInWorld(new EntityTargetSpellDisruption(caster, this));
	}

	@Override
	public EnumSpellRange getSpellType() 
	{
		return EnumSpellRange.TARGET;
	}

	@Override
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit) 
	{
		if (entityHit instanceof EntityPlayer && !SpellboundCore.getInstance().playerHasActiveSpell((EntityPlayer)entityHit, SpellShieldOfInvulnerability.class))
		{
			SpellboundCore.getInstance().removeActiveSpellFromPlayer((EntityPlayer) entityHit, SpellFireShield.class);
			SpellboundCore.getInstance().removeActiveSpellFromPlayer((EntityPlayer) entityHit, SpellColdShield.class);
			SpellboundCore.getInstance().removeActiveSpellFromPlayer((EntityPlayer) entityHit, SpellLightningShield.class);
			SpellboundCore.getInstance().removeActiveSpellFromPlayer((EntityPlayer) entityHit, SpellSurgeShield.class);
		}
	}

	@Override
	public EnumItemInUseTime getSpellCastDuration() 
	{
		return EnumItemInUseTime.TWO_SECONDS;
	}
}
