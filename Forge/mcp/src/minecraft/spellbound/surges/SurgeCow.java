/**********************************************
 * SurgeCow.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.surges;

import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;

public class SurgeCow extends AbstractSurge
{
	@Override
	public String getSpellDisplayName() 
	{
		return "...Cow?";
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		caster.worldObj.playSoundAtEntity(caster, "spellbound:surge", 1.0F, 1.0F);
		
		final EntityCow cow = new EntityCow(caster.worldObj);
		cow.setPosition(caster.posX, caster.posY, caster.posZ);
		
		caster.worldObj.spawnEntityInWorld(cow);
	}
}
