/**********************************************
 * SpellElementalFury.java
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
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import spellbound.core.SpellboundCore;
import spellbound.core.forge.PacketHandler;
import spellbound.entity.AbstractTargetSpell;
import spellbound.entity.EntityTargetSpellElementalFury;
import spellbound.entity.EntityTargetSpellFire;
import spellbound.enums.EnumItemInUseTime;
import spellbound.enums.EnumSpellRange;
import cpw.mods.fml.common.network.PacketDispatcher;

public class SpellElementalFury extends AbstractSpell 
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Elemental Fury";
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		caster.worldObj.playSoundAtEntity(caster, "mob.wither.spawn", 1.0F, 1.0F);
		caster.worldObj.playSoundAtEntity(caster, "ambient.weather.thunder", 1.0F, 1.0F);

		final AbstractTargetSpell spell = new EntityTargetSpellElementalFury(caster, this);
		caster.worldObj.spawnEntityInWorld(spell);
	}

	@Override
	public EnumSpellRange getSpellType() 
	{
		return EnumSpellRange.TARGET;
	}

	@Override
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit) 
	{
		final int radius = 8;
		final List entitiesList = entityHit == null ? worldObj.getEntitiesWithinAABB(Entity.class, AxisAlignedBB.getBoundingBox(posX - radius, posY - radius, posZ - radius, posX + radius, posY + radius, posZ + radius)) : worldObj.getEntitiesWithinAABB(Entity.class, AxisAlignedBB.getBoundingBox(entityHit.posX - radius, entityHit.posY - radius, entityHit.posZ - radius, entityHit.posX + radius, entityHit.posY + radius, entityHit.posZ + radius));

		for (final Object obj : entitiesList)
		{
			if (obj instanceof EntityLivingBase)
			{
				final EntityLivingBase livingEntity = (EntityLivingBase)obj;

				if (SpellboundCore.modRandom.nextBoolean())
				{
					livingEntity.attackEntityFrom(DamageSource.magic, 15.0F);
					livingEntity.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 1200));
				}

				else if (SpellboundCore.modRandom.nextBoolean())
				{
					livingEntity.attackEntityFrom(DamageSource.magic, 10.0F);
					livingEntity.setFire(15);
					worldObj.createExplosion(livingEntity, livingEntity.posX, livingEntity.posY, livingEntity.posZ, 5.0F, false);
				}

				else
				{
					livingEntity.attackEntityFrom(DamageSource.magic, 15.0F);

					final double spawnX = livingEntity.posX;
					final double spawnY = livingEntity.posY;
					final double spawnZ = livingEntity.posZ;

					worldObj.spawnEntityInWorld(new EntityLightningBolt(worldObj, spawnX, spawnY, spawnZ));
					PacketDispatcher.sendPacketToAllPlayers(PacketHandler.createLightningPacket(spawnX, spawnY, spawnZ));
				}
			}
		}
	}

	@Override
	public EnumItemInUseTime getSpellCastDuration() 
	{
		return EnumItemInUseTime.FIVE_SECONDS;
	}
}
