/**********************************************
 * SpellSummonLvl2.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.spells;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import spellbound.core.SpellboundCore;
import spellbound.enums.EnumItemInUseTime;
import spellbound.enums.EnumSpellRange;

public class SpellSummonLvl2 extends AbstractSpell
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Summon Mob";
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		caster.worldObj.playSoundAtEntity(caster, "mob.wither.idle", 1.0F, 1.0F);

		final EntityMob mob = SpellboundCore.modRandom.nextBoolean() ? new EntitySkeleton(caster.worldObj) : new EntityZombie(caster.worldObj);
		
		if (mob instanceof EntitySkeleton)
		{
			mob.setCurrentItemOrArmor(0, new ItemStack(Item.bow, 1, 0));
		}
		
		mob.setPosition(caster.posX, caster.posY, caster.posZ);

		caster.worldObj.spawnEntityInWorld(mob);
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
		return EnumItemInUseTime.TWO_SECONDS;
	}
}
