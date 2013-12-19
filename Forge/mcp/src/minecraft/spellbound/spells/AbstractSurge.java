/**********************************************
 * AbstractSurge.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.spells;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import spellbound.enums.EnumItemInUseTime;
import spellbound.enums.EnumSpellRange;

public abstract class AbstractSurge extends AbstractSpell
{
	@Override
	public final EnumItemInUseTime getSpellCastDuration() 
	{
		return EnumItemInUseTime.INSTANT;
	}

	@Override
	public final void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit) 
	{
		//No target effect.
	}

	@Override
	public final EnumSpellRange getSpellType() 
	{
		return EnumSpellRange.SELF;
	}
}
