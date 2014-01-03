/**********************************************
 * AbstractSpell.java
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
import spellbound.enums.EnumItemInUseTime;
import spellbound.enums.EnumSpellRange;
import spellbound.surges.AbstractSurge;

public abstract class AbstractSpell 
{
	public EntityPlayer caster;

	public String getSpellChargeSound()
	{
		switch (getSpellCastDuration())
		{
		case INSTANT: return "null";
		case ONE_SECOND: return "spellbound:spellcharge1second";
		case TWO_SECONDS: return "spellbound:spellcharge2seconds";
		case THREE_SECONDS: return "spellbound:spellcharge3seconds";
		case FOUR_SECONDS: return "spellbound:spellcharge4seconds";
		case FIVE_SECONDS: return "spellbound:spellcharge5seconds";
		default: return "spellbound:spellcharge5seconds";
		}
	}
	
	public AbstractSurge doMagicSurge(EntityPlayer caster)
	{
		this.caster = caster;
		int chanceOfSurge = 1;
		
		if (SpellboundCore.getInstance().entityHasActiveSpell(caster, SpellChaos.class))
		{
			chanceOfSurge = 80;
		}
		
		if (SpellboundCore.getInstance().entityHasActiveSpell(caster, SpellSurgeShield.class) || SpellboundCore.getInstance().entityHasActiveSpell(caster, SpellShieldOfInvulnerability.class))
		{
			chanceOfSurge = 0;
		}
		
		if (SpellboundCore.getBooleanWithProbability(chanceOfSurge))
		{
			if (chanceOfSurge == 1 && SpellboundCore.modRandom.nextBoolean())
			{
				return null;
			}
			
			return Constants.SURGES[SpellboundCore.modRandom.nextInt(Constants.SURGES.length)];
		}
		
		else
		{
			return null;
		}
	}

	public abstract String getSpellDisplayName();
	
	public abstract EnumItemInUseTime getSpellCastDuration();

	public abstract void doSpellCasterEffect(EntityPlayer caster);

	public abstract void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit);
	
	public abstract EnumSpellRange getSpellType();
}
