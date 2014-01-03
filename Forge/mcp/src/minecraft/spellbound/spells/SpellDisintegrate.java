/**********************************************
 * SpellDisintegrate.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.spells;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import spellbound.core.SpellboundCore;
import spellbound.entity.EntityTargetSpellDisintegrate;
import spellbound.enums.EnumItemInUseTime;
import spellbound.enums.EnumSpellRange;

public class SpellDisintegrate extends AbstractSpell
{
	@Override
	public String getSpellDisplayName()
	{
		return "Disintegrate";
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		caster.worldObj.playSoundAtEntity(caster, "mob.wither.spawn", 1.0F, 1.0F);
		caster.worldObj.spawnEntityInWorld(new EntityTargetSpellDisintegrate(caster, this));
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
			if (SpellboundCore.getBooleanWithProbability(60))
			{
				if (entityHit instanceof EntityPlayer)
				{
					if (!SpellboundCore.getInstance().entityHasActiveSpell((EntityPlayer)entityHit, SpellShieldOfInvulnerability.class))
					{
						entityHit.attackEntityFrom(DamageSource.magic, 100.0F);
					}
				}

				else
				{
					final int dropAmount = SpellboundCore.modRandom.nextInt(5) + 3;
					final ItemStack dropStack = entityHit instanceof EntitySlime ? new ItemStack(Item.slimeBall, dropAmount, 0) : new ItemStack(Item.dyePowder, dropAmount, 15);

					entityHit.setDead();
					worldObj.spawnEntityInWorld(new EntityItem(worldObj, entityHit.posX, entityHit.posY, entityHit.posZ, dropStack));
				}
			}

			else
			{
				entityHit.setFire(10);
				entityHit.attackEntityFrom(DamageSource.magic, 10.0F);
			}
		}
	}

	@Override
	public EnumItemInUseTime getSpellCastDuration() 
	{
		return EnumItemInUseTime.FIVE_SECONDS;
	}
}
