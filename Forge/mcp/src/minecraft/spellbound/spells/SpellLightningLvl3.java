/**********************************************
 * SpellLightningLvl3.java
 * Copyright (c) 2013 Wild Bama Boy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 **********************************************/

package spellbound.spells;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import spellbound.core.SpellboundCore;
import spellbound.core.forge.PacketHandler;
import spellbound.enums.EnumItemInUseTime;
import spellbound.enums.EnumSpellRange;
import cpw.mods.fml.common.network.PacketDispatcher;

public class SpellLightningLvl3 extends AbstractSpell
{
	@Override
	public String getSpellDisplayName() 
	{
		return "Area Lightning";
	}

	@Override
	public void doSpellCasterEffect(EntityPlayer caster) 
	{
		caster.worldObj.playSoundEffect(caster.posX, caster.posY, caster.posZ, "ambient.weather.thunder", 10000.0F, 1.0F);

		for (Object obj : caster.worldObj.getEntitiesWithinAABBExcludingEntity(caster, AxisAlignedBB.getBoundingBox(caster.posX - 35, caster.posY - 15, caster.posZ - 35, caster.posX + 35, caster.posY + 15, caster.posZ + 35)))
		{
			if (obj instanceof EntityLivingBase)
			{
				if (SpellboundCore.modRandom.nextBoolean() && SpellboundCore.modRandom.nextBoolean() && SpellboundCore.modRandom.nextBoolean() && SpellboundCore.modRandom.nextBoolean())
				{
					continue;
				}

				else
				{
					final EntityLivingBase entity = (EntityLivingBase)obj;

					if (entity instanceof EntityPlayer)
					{
						if (!SpellboundCore.getInstance().entityHasActiveSpell((EntityPlayer)entity, SpellShieldOfInvulnerability.class) && !SpellboundCore.getInstance().entityHasActiveSpell((EntityPlayer)entity, SpellLightningShield.class))
						{
							caster.worldObj.spawnEntityInWorld(new EntityLightningBolt(caster.worldObj, entity.posX, entity.posY, entity.posZ));
							PacketDispatcher.sendPacketToAllPlayers(PacketHandler.createLightningPacket(entity.posX, entity.posY, entity.posZ));
						}
					}

					else
					{
						caster.worldObj.spawnEntityInWorld(new EntityLightningBolt(caster.worldObj, entity.posX, entity.posY, entity.posZ));
						PacketDispatcher.sendPacketToAllPlayers(PacketHandler.createLightningPacket(entity.posX, entity.posY, entity.posZ));
					}
				}
			}
		}
	}

	@Override
	public EnumSpellRange getSpellType() 
	{
		return EnumSpellRange.AREA;
	}

	@Override
	public void doSpellTargetEffect(World worldObj, int posX, int posY, int posZ, EntityLivingBase entityHit) 
	{
		//No target effect.
	}

	@Override
	public EnumItemInUseTime getSpellCastDuration() 
	{
		return EnumItemInUseTime.THREE_SECONDS;
	}
}
