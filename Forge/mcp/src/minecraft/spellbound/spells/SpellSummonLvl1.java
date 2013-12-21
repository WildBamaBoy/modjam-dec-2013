/**********************************************
 * SpellSummonLvl1.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.spells;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import spellbound.enums.EnumItemInUseTime;
import spellbound.enums.EnumSpellRange;

public class SpellSummonLvl1 extends AbstractSpell
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Summon Wolf";
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		caster.worldObj.playSoundAtEntity(caster, "mob.wither.idle", 1.0F, 1.0F);

		final EntityWolf wolf = new EntityWolf(caster.worldObj);
		
		wolf.setTamed(true);
		wolf.setOwner(caster.username);
        wolf.setHealth(20.0F);
        wolf.worldObj.setEntityState(wolf, (byte)7);
		wolf.setPosition(caster.posX, caster.posY, caster.posZ);
		
		caster.worldObj.spawnEntityInWorld(wolf);
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
		return EnumItemInUseTime.ONE_SECOND;
	}
}
